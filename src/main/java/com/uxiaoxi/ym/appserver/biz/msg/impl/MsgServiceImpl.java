/**
 * MsgServiceImpl.java
 */
package com.uxiaoxi.ym.appserver.biz.msg.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import com.uxiaoxi.ym.aliyun.bean.TDMsgOnsDTO;
import com.uxiaoxi.ym.aliyun.producer.MsgProducer;
import com.uxiaoxi.ym.appserver.biz.msg.IMsgService;
import com.uxiaoxi.ym.appserver.db.account.dao.IAccountDao;
import com.uxiaoxi.ym.appserver.db.account.dto.Account;
import com.uxiaoxi.ym.appserver.db.cluster.dao.IClusterUserDao;
import com.uxiaoxi.ym.appserver.db.cluster.dto.ClusterUser;
import com.uxiaoxi.ym.appserver.db.msg.dao.IMsgAccDao;
import com.uxiaoxi.ym.appserver.db.msg.dao.IMsgDao;
import com.uxiaoxi.ym.appserver.db.msg.dto.Msg;
import com.uxiaoxi.ym.appserver.db.msg.dto.MsgAcc;
import com.uxiaoxi.ym.appserver.framework.sms.Sms;
import com.uxiaoxi.ym.appserver.framework.util.CommonUtil;
import com.uxiaoxi.ym.appserver.web.common.vo.ListResult;
import com.uxiaoxi.ym.appserver.web.common.vo.ResResult;
import com.uxiaoxi.ym.appserver.web.common.vo.StatusConst;
import com.uxiaoxi.ym.appserver.web.msg.vo.MsgDataForm;
import com.uxiaoxi.ym.appserver.web.msg.vo.MsgForm;
import com.uxiaoxi.ym.appserver.web.msg.vo.MsgGSendForm;
import com.uxiaoxi.ym.appserver.web.msg.vo.MsgReadStateForm;
import com.uxiaoxi.ym.appserver.web.msg.vo.MsgReadStateVO;
import com.uxiaoxi.ym.appserver.web.msg.vo.MsgSendForm;
import com.uxiaoxi.ym.appserver.web.msg.vo.MsgStatusEnum;
import com.uxiaoxi.ym.appserver.web.msg.vo.MsgTagChangeForm;
import com.uxiaoxi.ym.appserver.web.msg.vo.MsgTypeEnum;
import com.uxiaoxi.ym.appserver.web.msg.vo.MsgVO;
import com.uxiaoxi.ym.appserver.web.msg.vo.MsgWithContentVO;
import com.uxiaoxi.ym.jpush.JpushUtil;
import com.uxiaoxi.ym.jpush.PushParam;
import com.uxiaoxi.ym.jpush.PushTypeEnum;

/**
 * @author renhao
 *
 * 2015年2月28日
 */
@Service
public class MsgServiceImpl implements IMsgService {
    
    private Logger LOG = LoggerFactory.getLogger(MsgServiceImpl.class);
    
    @Autowired
    private IMsgDao msgDao;
    
    @Autowired
    private IMsgAccDao msgAccDao;
    
    @Autowired
    private IClusterUserDao clusterUserDao;
    
    @Autowired
    private IAccountDao accountDao;
    
    @Autowired
    private MsgProducer producer;

    @Override
    public ResResult getlist(MsgForm form) {
        
        List<MsgVO> list = msgAccDao.getlist(form);
        if(list == null) {
            list = new ArrayList<MsgVO>();
        }
        ListResult<MsgVO> sr = new ListResult<MsgVO>();
        
        if(list.size() > 0) {
            sr.setLast(list.get(list.size()-1).getMid());
        } else {
            sr.setLast(form.getStart());
        }
        sr.setList(list);
        
        return new ResResult(StatusConst.SUCCESS,StatusConst.STRSUCCESS,sr);
        
    }

    @Override
    @Transactional
    public ResResult getdata(MsgDataForm form) {
        
        // 取数据
        MsgWithContentVO vo = msgAccDao.getdata(form);
        
        if(vo != null) {
            // 更新为已读
            MsgAcc record = new MsgAcc();
            record.setMsgId(form.getMid());
            record.setReaded(MsgStatusEnum.READ.getCode());
            record.setAccId(form.getUid());
            msgAccDao.updateReaded(record);
           
        }
        return  new ResResult(StatusConst.SUCCESS,StatusConst.STRSUCCESS,vo);
    }

    @Override
    public ResResult delMsg(MsgDataForm form) {
        
        // 不做真删除,只更新use_yn
        // msgAccDao.deleteByPrimaryKey(form.getMid());
        MsgAcc record = new MsgAcc();
        record.setMsgId(form.getMid());
        record.setUseYn(false);
        record.setAccId(form.getUid());
        msgAccDao.updateByExample(record);
        
        return new ResResult(StatusConst.SUCCESS,StatusConst.STRSUCCESS,null);
    }

    @Override
    public ResResult sendMsg(MsgSendForm form, BindingResult errors) {
        
        // 表单验证出错则返回登录页面
        if (errors !=null && errors.hasErrors()) {
            return new ResResult(StatusConst.FAILURE,"输入信息格式错误",errors.getAllErrors());
        }
        
        // 通过阿里云ons服务发送消息和推送
        producer.sendMsg(form);
        
        // 返回成功
        return new ResResult(StatusConst.SUCCESS,StatusConst.STRSUCCESS,null);
    }

    @Override
    public ResResult gsendMsg(MsgGSendForm form, BindingResult errors) {

        
        // 表单验证出错则返回登录页面
        if (errors !=null && errors.hasErrors()) {
            return new ResResult(StatusConst.FAILURE,"输入信息格式错误",errors.getAllErrors());
        }
        
        // 通过阿里云ons服务发送消息和推送
        producer.sendMsg(form);
        
        return new ResResult(StatusConst.SUCCESS,StatusConst.STRSUCCESS,null);
    }
    
    @Override
    public ResResult getReadState(MsgReadStateForm form){
        List<MsgReadStateVO> list = msgAccDao.getReadState(form);
        return new ResResult(StatusConst.SUCCESS,StatusConst.STRSUCCESS,list);
        
    }
    

    /**
     * 发送单人消息
     * 不要直接调用,应通过ons调用
     * 
     * @param form
     */
    @Override
    @Transactional
    public void sendMsg(MsgSendForm form) {
        
        Msg msg = new Msg();
        msg.setAccId(form.getUid());
        msg.setContent(form.getContent());
        msg.setCreateDt(new Date());
        msg.setMsgType(Long.valueOf(form.getMsgType()));
        msg.setTitle(form.getTitle());
        msg.setCluId(form.getGid());
        msg.setUrl(form.getUrl());
        msgDao.insert(msg);

        // 插入msg_acc表
        MsgAcc ma = new MsgAcc();
        ma.setAccId(form.getNid());
        ma.setCreateDt(new Date());
        ma.setMsgId(msg.getId());
        ma.setCluId(form.getGid());
        ma.setReaded(MsgStatusEnum.UNREAD.getCode());
        ma.setUseYn(true);
        msgAccDao.insert(ma);

        // 极光推送
        PushParam param = new PushParam();
        param.setAlias("u" + form.getNid());
        
        
        Account account = accountDao.selectByKey(form.getNid());
        
        // TODO 唐山校长会后删除
//        if(account!= null && StringUtils.isBlank(account.getRegid()) && "欢迎您参加“教育改革与创新”高级研修班".equals(form.getTitle())){
//            // 发送短信
//            try {
//                Sms.tplSendSms(761809, "#name#="+account.getName(), account.getPhone());
//            } catch (IOException e) {
//                LOG.debug(e.getMessage());
//            }
//        }

        // TODO 把title 换成 content,极光推送的长度限制
        param.setContent(form.getTitle());
        param.setMid(msg.getId());
        param.setType(form.getMsgType());
        param.setTypeEnum(PushTypeEnum.ALIAS);
        param.setUrl(form.getUrl());
        JpushUtil.SendPush(param, account.getVersion());
        
        

    }

    /**
     * 发多人消息
     * 不要直接调用,应通过ons调用
     * 
     * @param form
     */
    @Override
    @Transactional
    public void gsendMsg(MsgGSendForm form) {
        
        Msg msg = new Msg();
        msg.setAccId(form.getUid());
        msg.setContent(form.getContent());
        msg.setCreateDt(new Date());
        msg.setMsgType(Long.valueOf(form.getMsgType()));
        msg.setTitle(form.getTitle());
        msg.setCluId(form.getGid());
        msg.setUrl(form.getUrl());
        msgDao.insert(msg);

        // 找出该群组的所有用户
        List<ClusterUser> userlist = clusterUserDao.selectByGid(form.getGid());
        
        // 插入msg_acc表
        for (ClusterUser cu : userlist) {
            MsgAcc ma = new MsgAcc();
            ma.setAccId(cu.getAccId());
            ma.setCreateDt(new Date());
            ma.setMsgId(msg.getId());
            ma.setCluId(form.getGid());
            ma.setReaded(MsgStatusEnum.UNREAD.getCode());
            ma.setUseYn(true);
            msgAccDao.insert(ma);
        }

        // 极光推送
        PushParam param = new PushParam();
        param.setTag("g" + form.getGid());
        // TODO 把title 换成 content ,极光推送的长度限制
        param.setContent(form.getTitle());
        param.setMid(msg.getId());
        param.setType(form.getMsgType());
        param.setTypeEnum(PushTypeEnum.TAG);
        param.setUrl(msg.getUrl());
        JpushUtil.gSendPush(param);
    }

    @Override
    @Transactional
    public void sendMsg(TDMsgOnsDTO od) {
        
        Account account = accountDao.getAccountByMobile(od.getPhone());
        
        if(account != null ) {
            
            Msg msg = new Msg();
            // TODO 发送者设置为0了
            msg.setAccId(0l);
            msg.setContent(od.getMessage());
            msg.setCreateDt(new Date());
            msg.setMsgType(Long.valueOf(MsgTypeEnum.TXT.getCode()));
            msg.setTitle(od.getMessage());
            // 获得学校的cluster
            msg.setCluId(0l);
            msg.setUrl(od.getImgUrl());
            msgDao.insert(msg);
            
            // 插入msg_acc表
            MsgAcc ma = new MsgAcc();
            ma.setAccId(account.getId());
            ma.setCreateDt(new Date());
            ma.setMsgId(msg.getId());
            ma.setCluId(0L);
            ma.setReaded(MsgStatusEnum.UNREAD.getCode());
            ma.setUseYn(true);
            msgAccDao.insert(ma);
            
            
            // 极光推送
            PushParam param = new PushParam();
            param.setAlias("u" + account.getId());
            
            // TODO 把title 换成 content,极光推送的长度限制
            param.setContent(msg.getTitle());
            param.setMid(msg.getId());
            param.setType(MsgTypeEnum.TXT.getCode());
            param.setTypeEnum(PushTypeEnum.ALIAS);
            param.setUrl(msg.getUrl());
            JpushUtil.SendPush(param, account.getVersion());
            
        } else {
            // TODO 发送短信
        }
    }
    
    
    @Override
    public ResResult tagChange(MsgTagChangeForm form) {
    	
        // 取得用户
        Account account = accountDao.selectByKey(form.getUid());
        Set<String> tagsToAdd = new HashSet<String>();
        Set<String> tagsToRemove = new HashSet<String>();
        
//    	//请求恢复推送
//        if(form.getStatus() == 0) {
//        	
//            List<ClusterUser>  culist = clusterUserDao.getAllByUid(account.getId());
//            for(ClusterUser cu : culist) {
//            	tagsToAdd.add(CommonUtil.buildGtag(cu.getCluId()));
//            }
//      
//            JpushUtil.updateDeviceTagAlias(account.getRegid(), null, tagsToAdd, null, account.getVersion());
//            
//        //请求解除推送    
//        }else if(form.getStatus() == 1){
//        	
//        }else{
//        	return new ResResult(StatusConst.FAILURE,"请求不明",null);
//        }
        
        clusterUserDao.updateJpushFlg(form);
        
        JpushUtil.updateDeviceTagAlias(account.getRegid(), false, true);
        
        List<ClusterUser>  culist = clusterUserDao.getAllByUid(account.getId());
        for(ClusterUser cu : culist) {
        	tagsToAdd.add(CommonUtil.buildGtag(cu.getCluId()));
        }
        JpushUtil.updateDeviceTagAlias(account.getRegid(), null, tagsToAdd, null, account.getVersion());

        return new ResResult(StatusConst.SUCCESS,StatusConst.STRSUCCESS,null);
        
    }
}

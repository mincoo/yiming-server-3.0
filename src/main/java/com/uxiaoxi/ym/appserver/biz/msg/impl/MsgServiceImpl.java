/**
 * MsgServiceImpl.java
 */
package com.uxiaoxi.ym.appserver.biz.msg.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;





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
import com.uxiaoxi.ym.appserver.db.msg.dao.IOptionLogDao;
import com.uxiaoxi.ym.appserver.db.msg.dto.Msg;
import com.uxiaoxi.ym.appserver.db.msg.dto.MsgAcc;
import com.uxiaoxi.ym.appserver.db.msg.dto.OptionLog;
import com.uxiaoxi.ym.appserver.framework.util.CommonUtil;
import com.uxiaoxi.ym.appserver.web.common.vo.ListResult;
import com.uxiaoxi.ym.appserver.web.common.vo.ResResult;
import com.uxiaoxi.ym.appserver.web.common.vo.ResultBean;
import com.uxiaoxi.ym.appserver.web.common.vo.StatusConst;
import com.uxiaoxi.ym.appserver.web.msg.form.MsgDataForm;
import com.uxiaoxi.ym.appserver.web.msg.form.MsgListForm;
import com.uxiaoxi.ym.appserver.web.msg.form.MsgGSendForm;
import com.uxiaoxi.ym.appserver.web.msg.form.MsgActionForm;
import com.uxiaoxi.ym.appserver.web.msg.form.MsgSendForm;
import com.uxiaoxi.ym.appserver.web.msg.form.MsgTagChangeForm;
import com.uxiaoxi.ym.appserver.web.msg.vo.MsgDataPatInfo;
import com.uxiaoxi.ym.appserver.web.msg.vo.MsgListVO;
import com.uxiaoxi.ym.appserver.web.msg.vo.MsgTypeEnum;
import com.uxiaoxi.ym.appserver.web.msg.vo.MsgVO;
import com.uxiaoxi.ym.jpush.JpushUtil;
import com.uxiaoxi.ym.jpush.PushParam;
import com.uxiaoxi.ym.jpush.PushTypeEnum;

/**
 * @author renhao
 *
 *         2015年2月28日
 */
@Service
public class MsgServiceImpl implements IMsgService {

//     private Logger LOG = LoggerFactory.getLogger(MsgServiceImpl.class);

    @Autowired
    private IMsgDao msgDao;

    @Autowired
    private IMsgAccDao msgAccDao;

    @Autowired
    private IClusterUserDao clusterUserDao;

    @Autowired
    private IAccountDao accountDao;

    @Autowired
    private IOptionLogDao optionLogDao;

    @Autowired
    private MsgProducer producer;

    @Override
    public ResResult getlist(MsgListForm form) {
        
        List<MsgListVO> list = msgAccDao.getlist(form);

        if (list == null) {
            list = new ArrayList<MsgListVO>();
        }

        List<MsgListVO> l = new ArrayList<MsgListVO>();

        // 计算sum1、sum2
        for (MsgListVO md : list) {
            Long sum1 = msgAccDao.getSum(md.getMid(), Long.valueOf(1));
            Long sum2 = msgAccDao.getSum(md.getMid(), Long.valueOf(2));
            Long sum0 = msgAccDao.getSum(md.getMid(), Long.valueOf(0));

            md.setSum1(sum1);
            md.setSum2(sum2);
            md.setSum0(sum0);
            l.add(md);
        }

        ListResult<MsgListVO> sr = new ListResult<MsgListVO>();

        sr.setList(list);

        return new ResResult(StatusConst.SUCCESS, StatusConst.STRSUCCESS, sr);

    }

    @Override
    public ResResult getdata(MsgDataForm form) {

        // 取数据
        MsgVO vo = msgAccDao.getdata(form);

        List<MsgDataPatInfo> list = msgAccDao.getDataAcc(form.getMid());

        if(list==null || list.size()==0){
            return new ResResult(vo);
        }
        
        int sum1 = 0;
        int sum2 = 0;
        // 计算sum1、sum2
        for (MsgDataPatInfo md : list) {
            if (md.getSelected().intValue() == 1) {
                sum1 ++;
            } else if (md.getSelected().intValue() == 2) {
                sum2 ++;
            } else {

            }
        }
        vo.setSize(Long.valueOf(list.size()));
        vo.setList(list);
        vo.setSum1(Long.valueOf(sum1));
        vo.setSum2(Long.valueOf(sum2));
        vo.setSum0(Long.valueOf(list.size() - sum1 - sum2));

        return new ResResult(vo);
    }

    @Override
    @Transactional
    public ResResult delMsg(MsgDataForm form) {

        // 不做真删除,只更新use_yn
        // msgAccDao.deleteByPrimaryKey(form.getMid());
        MsgAcc record = new MsgAcc();
        record.setMsgId(form.getMid());
        record.setUseYn(false);
        record.setAccId(form.getUid());
        msgAccDao.updateByExample(record);
        
        
        OptionLog re = new OptionLog();
        re.setDataId(form.getMid());
        re.setOptionType("D");
        re.setDataAfter(record.toString());
        re.setCreateAt(new Date());
        optionLogDao.insert(re);
        
        // 找出该群组的所有用户
        List<ClusterUser> userlist = clusterUserDao.selectByGid(form.getGid());

        // 插入msg_acc表
        for (ClusterUser cu : userlist) {
            // 插入msg_acc表
            MsgAcc ma = new MsgAcc();
            ma.setAccId(cu.getAccId());
            ma.setMsgId(form.getMid());
            ma.setVersion(re.getId());
            ma.setCluId(form.getGid());
            msgAccDao.updateByExample(ma);
        }

        return new ResResult(StatusConst.SUCCESS, StatusConst.STRSUCCESS, null);
    }

    @Override
    public ResResult sendMsg(MsgSendForm form, BindingResult errors) {

        // 表单验证出错则返回登录页面
        if (errors != null && errors.hasErrors()) {
            return new ResResult(StatusConst.FAILURE, "输入信息格式错误",
                    errors.getAllErrors());
        }

        // 通过阿里云ons服务发送消息和推送
        producer.sendMsg(form);

        // 返回成功
        return new ResResult(StatusConst.SUCCESS, StatusConst.STRSUCCESS, null);
    }

    @Override
    public ResResult gsendMsg(MsgGSendForm form, BindingResult errors) {

        // 表单验证出错则返回登录页面
        if (errors != null && errors.hasErrors()) {
            return new ResResult(StatusConst.FAILURE, "输入信息格式错误",
                    errors.getAllErrors());
        }

        // 通过阿里云ons服务发送消息和推送
        producer.sendMsg(form);

        return new ResResult(StatusConst.SUCCESS, StatusConst.STRSUCCESS, null);
    }


    /**
     * 发多人消息 不要直接调用,应通过ons调用
     * 
     * @param form
     */
    @Override
    @Transactional
    public void gsendMsg(MsgGSendForm form) {
        
        String gids = form.getGid();
        String[] gidList = gids.split(",");
        
        for(int i=0;i<gidList.length;i++){
            Msg msg = new Msg();
            msg.setSenderId(form.getUid());
            msg.setContent(form.getContent());
            msg.setCreateAt(new Date());
            msg.setMsgType(Long.valueOf(form.getMsgType()));
            msg.setStype(form.getRetype());
            //msg.setCluId(Long.valueOf(form.getGid()));
            msg.setCluId(Long.valueOf(gidList[i]));
            msg.setUrl(form.getUrl());
            msg.setSelect1(form.getSelect1());
            msg.setSelect2(form.getSelect2());
            msgDao.insert(msg);
            
            //消息总版本
            OptionLog re = new OptionLog();
            re.setOptionType("A");
            re.setDataAfter(msg.toString());
            re.setDataId(msg.getId());
            re.setCreateAt(new Date());
            optionLogDao.insert(re);
            
            // 找出该群组的所有用户
            List<ClusterUser> userlist = clusterUserDao.selectByGid(Long.valueOf(gidList[i]));
    
            // 插入msg_acc表
            for (ClusterUser cu : userlist) {
                MsgAcc ma = new MsgAcc();
                ma.setAccId(cu.getAccId());
                ma.setCreateAt(new Date());
                ma.setMsgId(msg.getId());
                ma.setVersion(re.getId());
                ma.setCluId(Long.valueOf(gidList[i]));
                ma.setSelected(0);//未选择状态
                ma.setUseYn(true);
                msgAccDao.insert(ma);
            }
    
          /*  // 极光推送
             PushParam param = new PushParam();
             param.setTag("g" + Long.valueOf(gidList[i]));
             // TODO 把title 换成 content ,极光推送的长度限制
             param.setContent(form.getContent());
             param.setMid(msg.getId());
             param.setType(form.getMsgType());
             param.setTypeEnum(PushTypeEnum.TAG);
             param.setUrl(msg.getUrl());
             JpushUtil.gSendPush(param);*/
        }
    }

    @Override
    @Transactional
    public void sendMsg(TDMsgOnsDTO od) {

        Account account = accountDao.getAccountByMobile(od.getPhone());

        if (account != null) {

            Msg msg = new Msg();
            // TODO 发送者设置为0了
            msg.setSenderId(0l);
            msg.setContent(od.getMessage());
            msg.setCreateAt(new Date());
            msg.setMsgType(Long.valueOf(MsgTypeEnum.TXT.getCode()));
            // 获得学校的cluster
            msg.setCluId(0l);
            msg.setUrl(od.getImgUrl());
            msgDao.insert(msg);

            // 插入msg_acc表
            MsgAcc ma = new MsgAcc();
            ma.setAccId(account.getId());
            ma.setCreateAt(new Date());
            ma.setMsgId(msg.getId());
            ma.setCluId(0L);
            // ma.setReaded(MsgStatusEnum.UNREAD.getCode());
            ma.setUseYn(true);
            msgAccDao.insert(ma);

/*            // 极光推送
            PushParam param = new PushParam();
            param.setAlias("u" + account.getId());

            // TODO 把title 换成 content,极光推送的长度限制
            param.setMid(msg.getId());
            param.setType(MsgTypeEnum.TXT.getCode());
            param.setTypeEnum(PushTypeEnum.ALIAS);
            param.setUrl(msg.getUrl());
            JpushUtil.SendPush(param, account.getVersion());*/

        } else {
            // TODO 发送短信
        }
    }

    @Override
    public ResResult tagChange(MsgTagChangeForm form) {

        // 取得用户
        Account account = accountDao.selectByKey(form.getUid());
        Set<String> tagsToAdd = new HashSet<String>();
        // Set<String> tagsToRemove = new HashSet<String>();

        // //请求恢复推送
        // if(form.getStatus() == 0) {
        //
        // List<ClusterUser> culist =
        // clusterUserDao.getAllByUid(account.getId());
        // for(ClusterUser cu : culist) {
        // tagsToAdd.add(CommonUtil.buildGtag(cu.getCluId()));
        // }
        //
        // JpushUtil.updateDeviceTagAlias(account.getRegid(), null, tagsToAdd,
        // null, account.getVersion());
        //
        // //请求解除推送
        // }else if(form.getStatus() == 1){
        //
        // }else{
        // return new ResResult(StatusConst.FAILURE,"请求不明",null);
        // }

        clusterUserDao.updateMsgFlg(form);

        JpushUtil.updateDeviceTagAlias(account.getRegid(), false, true);

        List<ClusterUser> culist = clusterUserDao.getAllByUid(account.getId());
        for (ClusterUser cu : culist) {
            tagsToAdd.add(CommonUtil.buildGtag(cu.getCluId()));
        }
        JpushUtil.updateDeviceTagAlias(account.getRegid(), null, tagsToAdd,
                null, account.getVersion());

        return new ResResult(StatusConst.SUCCESS, StatusConst.STRSUCCESS, null);

    }

    @Override
    @Transactional
    public ResResult msgAction(MsgActionForm form) {

        MsgAcc record = new MsgAcc();
        record.setAccId(form.getUid());
        record.setCluId(form.getGid());
        record.setMsgId(form.getMid());
        record.setSelected(form.getSelected());

        msgAccDao.updateByExample(record);
        
        OptionLog re = new OptionLog();
        re.setDataId(form.getMid());
        re.setOptionType("U");
        re.setDataAfter(record.toString());
        re.setCreateAt(new Date());
        optionLogDao.insert(re);

        // 找出该群组的所有用户
        List<ClusterUser> userlist = clusterUserDao.selectByGid(form.getGid());

        // 插入msg_acc表
        for (ClusterUser cu : userlist) {
            // 插入msg_acc表
            MsgAcc ma = new MsgAcc();
            ma.setAccId(cu.getAccId());
            ma.setMsgId(form.getMid());
            ma.setVersion(re.getId());
            ma.setCluId(form.getGid());
            msgAccDao.updateByExample(ma);
        }

        
        return new ResResult(null);

    }
}

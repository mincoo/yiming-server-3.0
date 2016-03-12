/**
 * MsgServiceImpl.java
 */
package com.uxiaoxi.ym.appserver.biz.msg.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.glassfish.jersey.client.JerseyWebTarget;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.notnoop.apns.APNS;
import com.notnoop.apns.ApnsService;
import com.uxiaoxi.ym.aliyun.bean.TDMsgOnsDTO;
import com.uxiaoxi.ym.aliyun.producer.MsgProducer;
import com.uxiaoxi.ym.aliyun.producer.TDMsgProducer;
import com.uxiaoxi.ym.appserver.biz.cluster.impl.ClusterServiceImpl;
import com.uxiaoxi.ym.appserver.biz.msg.IMsgService;
import com.uxiaoxi.ym.appserver.db.account.dao.IAccountDao;
import com.uxiaoxi.ym.appserver.db.account.dto.Account;
import com.uxiaoxi.ym.appserver.db.cluster.dao.IClusterDao;
import com.uxiaoxi.ym.appserver.db.cluster.dao.IClusterUserDao;
import com.uxiaoxi.ym.appserver.db.cluster.dto.Cluster;
import com.uxiaoxi.ym.appserver.db.cluster.dto.ClusterUser;
import com.uxiaoxi.ym.appserver.db.msg.dao.IMsgAccDao;
import com.uxiaoxi.ym.appserver.db.msg.dao.IMsgDao;
import com.uxiaoxi.ym.appserver.db.msg.dao.IOfficialAccUserDao;
import com.uxiaoxi.ym.appserver.db.msg.dao.IOfficialAccountsDao;
import com.uxiaoxi.ym.appserver.db.msg.dao.IOptionLogDao;
import com.uxiaoxi.ym.appserver.db.msg.dto.Msg;
import com.uxiaoxi.ym.appserver.db.msg.dto.MsgAcc;
import com.uxiaoxi.ym.appserver.db.msg.dto.OfficialAccUser;
import com.uxiaoxi.ym.appserver.db.msg.dto.OfficialAccounts;
import com.uxiaoxi.ym.appserver.db.msg.dto.OptionLog;
import com.uxiaoxi.ym.appserver.framework.util.CommonUtil;
import com.uxiaoxi.ym.appserver.framework.util.StringUtil;
import com.uxiaoxi.ym.appserver.web.common.vo.ListResult;
import com.uxiaoxi.ym.appserver.web.common.vo.ResResult;
import com.uxiaoxi.ym.appserver.web.common.vo.ResultBean;
import com.uxiaoxi.ym.appserver.web.common.vo.StatusConst;
import com.uxiaoxi.ym.appserver.web.msg.form.MsgActionForm;
import com.uxiaoxi.ym.appserver.web.msg.form.MsgDataForm;
import com.uxiaoxi.ym.appserver.web.msg.form.MsgGSendForm;
import com.uxiaoxi.ym.appserver.web.msg.form.MsgListForm;
import com.uxiaoxi.ym.appserver.web.msg.form.MsgOADataForm;
import com.uxiaoxi.ym.appserver.web.msg.form.MsgOaTagChangeForm;
import com.uxiaoxi.ym.appserver.web.msg.form.MsgSendForm;
import com.uxiaoxi.ym.appserver.web.msg.form.MsgTagChangeForm;
import com.uxiaoxi.ym.appserver.web.msg.form.MsgUpdatePushSumForm;
import com.uxiaoxi.ym.appserver.web.msg.vo.MsgDataPatInfo;
import com.uxiaoxi.ym.appserver.web.msg.vo.MsgExplainInfo;
import com.uxiaoxi.ym.appserver.web.msg.vo.MsgGetListResult;
import com.uxiaoxi.ym.appserver.web.msg.vo.MsgListVO;
import com.uxiaoxi.ym.appserver.web.msg.vo.MsgOAListVO;
import com.uxiaoxi.ym.appserver.web.msg.vo.MsgTypeEnum;
import com.uxiaoxi.ym.appserver.web.msg.vo.MsgVO;
import com.uxiaoxi.ym.easemob.comm.Constants;
import com.uxiaoxi.ym.easemob.comm.HTTPMethod;
import com.uxiaoxi.ym.easemob.comm.Roles;
import com.uxiaoxi.ym.easemob.utils.JerseyUtils;
import com.uxiaoxi.ym.easemob.vo.ClientSecretCredential;
import com.uxiaoxi.ym.easemob.vo.Credential;
import com.uxiaoxi.ym.easemob.vo.EndPoints;
import com.uxiaoxi.ym.jpush.JpushUtil;

/**
 * @author renhao
 *
 *         2015年2月28日
 */
@Service
public class MsgServiceImpl implements IMsgService {

    private static final Logger log = LoggerFactory
            .getLogger(ClusterServiceImpl.class);
    
    private static final JsonNodeFactory factory = new JsonNodeFactory(false);
    private static final String APPKEY = Constants.APPKEY;

    // 通过app的client_id和client_secret来获取app管理员token
    private static Credential credential = new ClientSecretCredential(
            Constants.APP_CLIENT_ID, Constants.APP_CLIENT_SECRET,
            Roles.USER_ROLE_APPADMIN);
    
    @Value("${p12}")
    private String p12;

    @Autowired
    private IMsgDao msgDao;

    @Autowired
    private IMsgAccDao msgAccDao;

    @Autowired
    private IClusterUserDao clusterUserDao;
    
    @Autowired
    private IClusterDao clusterDao;

    @Autowired
    private IAccountDao accountDao;

    @Autowired
    private IOptionLogDao optionLogDao;

    @Autowired
    private MsgProducer producer;
    
    @Autowired
    private TDMsgProducer producer1;
    
    @Autowired
    private IOfficialAccUserDao officialAccUserDao;
    
    @Autowired
    private IOfficialAccountsDao officialAccountsDao;

    @Override
    public ResResult getlist(MsgListForm form) {
        
        List<MsgListVO> list = msgAccDao.getlist(form);

        if (list == null) {
            list = new ArrayList<MsgListVO>();
        }

        List<MsgListVO> l = new ArrayList<MsgListVO>();

        for (MsgListVO md : list) {
            // 计算sum1、sum2、sum0
            Long sum1 = msgAccDao.getSum(md.getMid(), Long.valueOf(StatusConst.SELECT1));
            Long sum2 = msgAccDao.getSum(md.getMid(), Long.valueOf(StatusConst.SELECT2));
            Long sum0 = msgAccDao.getSum(md.getMid(), Long.valueOf(StatusConst.NOSELECT));

            md.setSum1(sum1);
            md.setSum2(sum2);
            md.setSum0(sum0);
            l.add(md);
            
            //更新已读标识received
            MsgAcc record = new MsgAcc();
            record.setMsgId(md.getMid());
            record.setAccId(form.getUid());
            record.setReceived(Long.valueOf(StatusConst.RECEIVED));
            msgAccDao.updateByExample(record);
            
        }

        MsgGetListResult sr = new MsgGetListResult();
        
        sr.setList(list);
        sr.setSize(Long.valueOf(list.size()));
        sr.setVersion(msgAccDao.getLastVer(form.getUid()));
        
        return new ResResult(sr);
    }

    @Override
    public ResResult getdata(MsgDataForm form) {

        // 取详细数据
        MsgVO vo = msgAccDao.getdata(form);

        List<MsgDataPatInfo> list = msgAccDao.getDataAcc(form.getMid());

        if(list==null || list.size()==0){
            return new ResResult(vo);
        }
        
        int sum1 = 0;
        int sum2 = 0;
        // 计算sum1、sum2
        for (MsgDataPatInfo md : list) {
            if (md.getSelected().intValue() == StatusConst.SELECT1) {
                sum1 ++;
            } else if (md.getSelected().intValue() == StatusConst.SELECT2) {
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
    public ResResult getOAList(Long uid) {
        
        List<MsgOAListVO> list = msgDao.getoalist(uid);
        
        List<MsgOAListVO> retList = new ArrayList<MsgOAListVO>();

        if (list == null) {
            list = new ArrayList<MsgOAListVO>();
        }

        for(MsgOAListVO vo : list){
            //取最后一条信息详情
            MsgOAListVO lastMsg = msgDao.getnewdata(vo.getOaid());
            if(lastMsg!=null){
                vo.setMid(lastMsg.getMid());
                vo.setContent(lastMsg.getContent());
                vo.setStime(lastMsg.getStime());
                vo.setType(lastMsg.getType());
                vo.setUrl(lastMsg.getUrl());
            }
            
            //取公众号说明图片信息
            List<MsgExplainInfo> explainList = msgDao.getexplain(vo.getOaid());
            vo.setSsize(Long.valueOf(explainList.size()));;
            vo.setSlist(explainList);
            
            retList.add(vo);
        }
        
        ListResult<MsgOAListVO> sr = new ListResult<MsgOAListVO>();
        
        sr.setSize(Long.valueOf(list.size()));
        sr.setList(retList);

        return new ResResult(sr);

    }
    
    @Override
    public ResResult getOAData(MsgOADataForm form) {
        
        // 分页获取某公众号信息List
        List<MsgOAListVO> list = msgDao.getoadata(form);

        if(list==null || list.size()==0){
            list = new ArrayList<MsgOAListVO>();
        }
        
        ListResult<MsgOAListVO> sr = new ListResult<MsgOAListVO>();
        
        //设置分页last
        if(list.size() > 0) {
            sr.setLast(list.get(list.size()-1).getMid());
        } else {
            sr.setLast(form.getStart());
        }
        
        sr.setList(list);

        return new ResResult(sr);
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
        
        
//        OptionLog re = new OptionLog();
//        re.setDataId(form.getMid());
//        re.setOptionType("D");
//        re.setDataAfter(record.toString());
//        re.setCreateAt(new Date());
//        optionLogDao.insert(re);
        
//        // 找出该群组的所有用户
//        List<ClusterUser> userlist = clusterUserDao.selectByGid(form.getGid());
//
//        // 插入msg_acc表
//        for (ClusterUser cu : userlist) {
//            // 插入msg_acc表
//            MsgAcc ma = new MsgAcc();
//            ma.setAccId(cu.getAccId());
//            ma.setMsgId(form.getMid());
//            ma.setVersion(re.getId());
//            ma.setCluId(form.getGid());
//            msgAccDao.updateByExample(ma);
//        }
//        
//        //发送透传消息
//        sendMsgTraGroup(String.valueOf(form.getGid()));

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
            msg.setContentType(new Long(StatusConst.CONTENT_TYPE_CLUSTER)); //班级消息
            msg.setCreateAt(new Date());
            msg.setMsgType(Long.valueOf(form.getMsgType()));
            msg.setStype(form.getRetype());
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
                ma.setSelected(StatusConst.NOSELECT);//未选择状态
                ma.setReceived(Long.valueOf(StatusConst.NORECEIVED));//设置通知读取状态为未读
                ma.setUseYn(true);
                msgAccDao.insert(ma);
                
                //ios推送处理
                iosPush(cu.getAccId(),Long.valueOf(gidList[i]),true);
            }
            
            //发送透传消息
            sendMsgTraGroup(gids,StatusConst.MSG_TYPE_CLUSTER);
    
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
    public void sendMsg(TDMsgOnsDTO od, BindingResult errors) {

//        // 表单验证出错则返回登录页面
//        if (errors != null && errors.hasErrors()) {
//            return new ResResult(StatusConst.FAILURE, "输入信息格式错误",
//                    errors.getAllErrors());
//        }

        // 通过阿里云ons服务发送消息和推送
//        producer1.sendTDMsg(od);

    }

    @Override
    @Transactional
    public void sendMsg(TDMsgOnsDTO od) {

        Account account = accountDao.getAccountByMobile(od.getPhone());

        if (account != null) {

            Msg msg = new Msg();
            // TODO 发送者设置为0了
            //msg.setSenderId(0l);
            msg.setContent(od.getMessage());
            msg.setContentType(new Long(StatusConst.CONTENT_TYPE_SAFE)); //校安消息
            msg.setCreateAt(new Date());
            msg.setMsgType(Long.valueOf(MsgTypeEnum.TXT.getCode()));
            // 获得学校的cluster
            //msg.setCluId(0l);
            
            //暂时用Select1来存储校安消息对象的uid
            msg.setSelect1(String.valueOf(account.getId()));
            msg.setUrl(od.getImgUrl());
            msgDao.insert(msg);

            // 插入msg_acc表
            MsgAcc ma = new MsgAcc();
            ma.setAccId(account.getId());
            ma.setCreateAt(new Date());
            ma.setMsgId(msg.getId());
            //ma.setCluId(0L);
            ma.setUseYn(true);
            msgAccDao.insert(ma);
            
            
            
          //发送透传消息
            sendMsgTra("u"+account.getId(),StatusConst.MSG_TYPE_OPEN,String.valueOf(StatusConst.CONTENT_TYPE_SAFE));
            
          //ios推送处理
            iosPush(account.getId(),new Long(StatusConst.CONTENT_TYPE_SAFE),false);

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

//        // 取得用户
//        Account account = accountDao.selectByKey(form.getUid());
//        Set<String> tagsToAdd = new HashSet<String>();

        //更新用户的推送设置
        clusterUserDao.updateMsgFlg(form);

//        //注销jpush推送
//        JpushUtil.updateDeviceTagAlias(account.getRegid(), false, true);
//
//        //重新设置jpush推送
//        //取得需要推送的所有用户
//        List<ClusterUser> culist = clusterUserDao.getAllByUid(account.getId());
//        for (ClusterUser cu : culist) {
//            tagsToAdd.add(CommonUtil.buildGtag(cu.getCluId()));
//        }
//        JpushUtil.updateDeviceTagAlias(account.getRegid(), null, tagsToAdd,
//                null, account.getVersion());

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
        
        //OptionLog中记录
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
        
      //发送透传消息 TODO暂时不做透传
       // sendMsgTraGroup(String.valueOf(form.getGid()));

        return new ResResult(null);

    }
    
    @Override
    public ResResult oatagChange(MsgOaTagChangeForm form) {

//        // 取得用户
//        Account account = accountDao.selectByKey(form.getUid());
//        Set<String> tagsToAdd = new HashSet<String>();

        //更新用户的推送设置
        officialAccUserDao.updateMsgOaFlg(form);
        
//        //注销jpush推送
//        JpushUtil.updateDeviceTagAlias(account.getRegid(), false, true);
//
//        //重新设置jpush推送
//        //取得需要推送的所有用户
//        List<ClusterUser> culist = clusterUserDao.getAllByUid(account.getId());
//        for (ClusterUser cu : culist) {
//            tagsToAdd.add(CommonUtil.buildGtag(cu.getCluId()));
//        }
//        JpushUtil.updateDeviceTagAlias(account.getRegid(), null, tagsToAdd,
//                null, account.getVersion());

        return new ResResult(StatusConst.SUCCESS, StatusConst.STRSUCCESS, null);

    }
    
    
    @Override
    public ResResult updatePushSum(MsgUpdatePushSumForm form) {
        
        Account account = accountDao.selectByKey(form.getUid());
        
        Account record = account;
        
        int sum = account.getIosPushSum()- form.getNum();
        
        if (sum < 0) {
            sum = 0;
        }
        record.setIosPushSum(sum);
        
        ResultBean rt = accountDao.updateByPrimaryKey(record);
        if(rt != null && rt.getCode() == 1) {
            return new ResResult(null);
        } else {
            return new ResResult(StatusConst.FAILURE, "更新失败",null);
        }

    }
    
    /**
     * 发送消息
     * 
     * @param targetType
     *            消息投递者类型：users 用户, chatgroups 群组
     * @param target
     *            接收者ID 必须是数组,数组元素为用户ID或者群组ID
     * @param msg
     *            消息内容
     * @param from
     *            发送者
     * @param ext
     *            扩展字段
     * 
     * @return 请求响应
     */
    public static ObjectNode sendMessages(String targetType, ArrayNode target, ObjectNode msg,
            ObjectNode ext) {

        ObjectNode objectNode = factory.objectNode();

        ObjectNode dataNode = factory.objectNode();

        // check appKey format
        if (!JerseyUtils.match("^(?!-)[0-9a-zA-Z\\-]+#[0-9a-zA-Z]+", APPKEY)) {
            log.error("Bad format of Appkey: " + APPKEY);

            objectNode.put("message", "Bad format of Appkey");

            return objectNode;
        }

        // check properties that must be provided
        if (!("users".equals(targetType) || "chatgroups".equals(targetType))) {
            log.error("TargetType must be users or chatgroups .");

            objectNode.put("message", "TargetType must be users or chatgroups .");

            return objectNode;
        }

        try {
            // 构造消息体
            dataNode.put("target_type", targetType);
            dataNode.put("target", target);
            dataNode.put("msg", msg);
//            dataNode.put("from", from);
            dataNode.put("ext", ext);

            JerseyWebTarget webTarget = EndPoints.MESSAGES_TARGET.resolveTemplate("org_name", APPKEY.split("#")[0]).resolveTemplate(
                    "app_name", APPKEY.split("#")[1]);

            objectNode = JerseyUtils.sendRequest(webTarget, dataNode, credential, HTTPMethod.METHOD_POST, null);

            objectNode = (ObjectNode) objectNode.get("data");
            for (int i = 0; i < target.size(); i++) {
                String resultStr = objectNode.path(target.path(i).asText()).asText();
                if ("success".equals(resultStr)) {
                    log.error(String.format("Message has been send to user[%s] successfully .", target.path(i).asText()));
                } else if (!"success".equals(resultStr)) {
                    log.error(String.format("Message has been send to user[%s] failed .", target.path(i).asText()));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return objectNode;
    }
    
    /**
     * 
     * 发送群组透传
     * 
     * @param gids
     * @param action
     */
    private void sendMsgTraGroup(String gids,String action){
        
        String targetTypeus = "chatgroups";
        ObjectNode ext = factory.objectNode();
        ArrayNode targetusers = factory.arrayNode();
        
        String[] gidList = gids.split(",");
        for (int i = 0; i < gidList.length; i++) {
            String gid = ClusterServiceImpl.getGroupId(Long.valueOf(gidList[i]));
            targetusers.add(gid);
        }
     // 给群组发一条透传消息
        ObjectNode cmdmsg = factory.objectNode();
        //cmdmsg.put("vertion", String.valueOf(vertion));
        cmdmsg.put("type","cmd");
        cmdmsg.put("action",action);
        sendMessages(targetTypeus, targetusers, cmdmsg, ext);
    }
    
    /**
     * 
     * 发送个人用户透传
     * 
     * @param gids
     * @param action
     */
    private void sendMsgTra(String uid,String action,String attr){
        
        String targetTypeus = "users";
        ObjectNode ext = factory.objectNode();
        ArrayNode targetusers = factory.arrayNode();
        
    //TODO 暂时不对应多人的   ，待用户基数上去的时候处理
//        for (int i = 0; i < uids.length; i++) {
//            String gid = ClusterServiceImpl.getGroupId(Long.valueOf(uids[i]));
//            targetusers.add(gid);
//        }
        targetusers.add(uid);
        ext.put("attr", attr);
        
     // 给个人发一条透传消息
        ObjectNode cmdmsg = factory.objectNode();
        //cmdmsg.put("vertion", String.valueOf(vertion));
        cmdmsg.put("type","cmd");
        cmdmsg.put("action",action);
        sendMessages(targetTypeus, targetusers, cmdmsg, ext);
    }
    
    
    /**
     * 
     * ios推送处理
     * 
     * @param uid
     * @param gid
     * @param isCluMsg
     */
    private void iosPush(Long uid, Long id, boolean isCluMsg) {
        
        Account account = accountDao.selectByKey(uid);
        
        String toName = "";
        String pushFieldKey = "";
        
        //android的设备时不推送。android的regid小于64
        if(account.getRegid().length()<=64){
            return;
        }
        
        //班级消息
        if(isCluMsg){
            //免打扰时不推送。
            ClusterUser clusterUser =clusterUserDao.searchByGidAndUid(id,uid);
            
            if((account.getMsgSwitch()!=null&&account.getMsgSwitch()==1)||(clusterUser!=null&&clusterUser.getMsgFlg()!=null&&clusterUser.getMsgFlg()==1)){
                return;
            }
            
            Cluster cluster = clusterDao.selectByKey(id);
            pushFieldKey = "gid";
            toName = cluster.getTitle();
            
        //公众号消息    
        }else{
            
            
          //免打扰时不推送。
            OfficialAccUser officialAccUser =officialAccUserDao.searchByOaidAndUid(id,uid);
            
            if((account.getMsgSwitch()!=null&&account.getMsgSwitch()==1)||(officialAccUser!=null&&officialAccUser.getMsgFlg()!=null&&officialAccUser.getMsgFlg()==1)){
                return;
            }
            
            OfficialAccounts officialAccount = officialAccountsDao.selectByKey(id);
            
            pushFieldKey = "oaid";
            toName = officialAccount.getName();
        }
        
        
        int sum = 1;
        if(account.getIosPushSum()!=null){
            sum= account.getIosPushSum()+1;
        }
        
        //更新数据库
        account.setIosPushSum(sum);
        accountDao.updateByPrimaryKeySelective(account);
        
        ApnsService service =
                APNS.newService()
                .withCert(StringUtil.getRootPath(p12), "123")
                .withSandboxDestination()
                .build();
        
        
//        //Production证书用于正式发布版
//        ApnsService service =
//                APNS.newService()
//                .withCert(StringUtil.getRootPath("com.uxiaoxi.mp_production.p12"), "123")
//                .withProductionDestination()
//                .build();
       
        
        String payload = APNS.newPayload()
                .badge(sum)
                .customField(pushFieldKey,id)
                .localizedKey("收到来自"+toName+"的一条通知。")
                .sound("default").build();
        
        String regid = account.getRegid();
        service.push(regid, payload);
    }
    
}

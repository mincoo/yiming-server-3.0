/**
 * AccountServiceImpl.java
 */
package com.uxiaoxi.ym.appserver.biz.account.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.glassfish.jersey.client.JerseyWebTarget;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.uxiaoxi.ym.appserver.biz.account.IAccountService;
import com.uxiaoxi.ym.appserver.db.account.dao.IAccountDao;
import com.uxiaoxi.ym.appserver.db.account.dao.IFeedbackDao;
import com.uxiaoxi.ym.appserver.db.account.dto.Account;
import com.uxiaoxi.ym.appserver.db.account.dto.Feedback;
import com.uxiaoxi.ym.appserver.db.cluster.dao.IClusterUserDao;
import com.uxiaoxi.ym.appserver.db.cluster.dto.ClusterUser;
import com.uxiaoxi.ym.appserver.db.verification.dao.IVerificationCodeDao;
import com.uxiaoxi.ym.appserver.framework.util.CommonUtil;
import com.uxiaoxi.ym.appserver.framework.util.StringUtil;
import com.uxiaoxi.ym.appserver.web.account.form.ChangePWDForm;
import com.uxiaoxi.ym.appserver.web.account.form.FeedbackForm;
import com.uxiaoxi.ym.appserver.web.account.form.LoginForm;
import com.uxiaoxi.ym.appserver.web.account.form.MsgSwitchForm;
import com.uxiaoxi.ym.appserver.web.account.form.RegisterForm;
import com.uxiaoxi.ym.appserver.web.account.form.ResetPWDForm;
import com.uxiaoxi.ym.appserver.web.account.vo.AccountUpdateVO;
import com.uxiaoxi.ym.appserver.web.account.vo.AccountVO;
import com.uxiaoxi.ym.appserver.web.common.vo.ListResult;
import com.uxiaoxi.ym.appserver.web.common.vo.ResResult;
import com.uxiaoxi.ym.appserver.web.common.vo.ResultBean;
import com.uxiaoxi.ym.appserver.web.common.vo.StatusConst;
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
 * 2015-1-28
 */
@Service
public class AccountServiceImpl implements IAccountService {
    
    private static final Logger log = LoggerFactory.getLogger(AccountServiceImpl.class);
    
    private static final JsonNodeFactory factory = new JsonNodeFactory(false);
    private static final String APPKEY = Constants.APPKEY;

    // 通过app的client_id和client_secret来获取app管理员token
    private static Credential credential = new ClientSecretCredential(
            Constants.APP_CLIENT_ID, Constants.APP_CLIENT_SECRET,
            Roles.USER_ROLE_APPADMIN);
    
    
    @Autowired
    private IAccountDao accountDao;
    
    @Autowired
    private IFeedbackDao feedbackDao;
    
    @Autowired
    private IClusterUserDao cluserUserDao;
    
    @Autowired
    private IVerificationCodeDao verificationCodeDao;
    
    @Override
    public Account getAccountByMobile(String mobile) {
        return accountDao.getAccountByMobile(mobile);
    }
    
    @Override
    public Account getAccountById(Long userId) {
        // TODO 做缓存策略
        return accountDao.selectByKey(userId);
    }
    
    @Override
    public ResResult getAccountByNId(String nids) {
        
        List<AccountVO> re = new ArrayList<AccountVO>();
        
        String[] nidList = nids.split(",");
        
        for(int i=0;i<nidList.length;i++){
            Account account = accountDao.selectByKey(Long.valueOf(nidList[i]));
            if (account != null) {
                AccountVO vo = new AccountVO(account);
                vo.setToken("");
                re.add(vo);
            }
        }
        
        ListResult<AccountVO> sr = new ListResult<AccountVO>();
        sr.setList(re);
        sr.setSize(Long.valueOf(re.size()));

        return new ResResult(sr);
        
    }

    @Override
    public ResResult changePassword(ChangePWDForm form) {
        
        ResResult rs = new ResResult();
        rs.setMsg(StatusConst.STRFAILURE);
        rs.setStatus(StatusConst.FAILURE);
        
        rs = this.checkPassword(form.getUid(), form.getOldpwd());
        // 旧密码验证成功
        if(rs.getStatus() == StatusConst.SUCCESS) {
            Account record = new Account();
            record.setId(form.getUid());
            record.setPassword(CommonUtil.password(form.getNewpwd()));
            
            ResultBean rt = accountDao.updateByPrimaryKeySelective(record);
            if(rt != null && rt.getCode() == 1) {
                rs.setMsg(StatusConst.STRSUCCESS);
                rs.setStatus(StatusConst.SUCCESS);
                return rs;
            } else {
                rs.setMsg("密码修改失败");
                return rs;
            }
            
        } else {
            rs.setMsg("旧密码错误");
            return rs;
        }
       

    }
    
    
    @Override
    @Transactional
    public ResResult register(RegisterForm registerForm){
        
        
        ResResult rs = new ResResult();
        rs.setMsg(StatusConst.STRFAILURE);
        rs.setStatus(StatusConst.FAILURE);
        
        
        // 验证帐号是否存在
         
        Account account = accountDao.getAccountByMobile(registerForm.getPhone());
        if(account != null ) {
            
            rs.setMsg("手机号已注册");
            
            return rs;
            
        } else {
            
            // 验证码有效性验证
            boolean rt = verificationCodeDao.checkCode(registerForm.getVcode(), registerForm.getPhone());
            
            if(rt) {
                
                // 注册帐号
                Account newAccount = new Account();
                newAccount.setPhone(registerForm.getPhone());
                newAccount.setName(registerForm.getName());
                newAccount.setPassword(CommonUtil.password(registerForm.getPasswd()));
                newAccount.setType(registerForm.getType());
                newAccount.setCreateDt(new Date());
                newAccount.setSex(registerForm.getSex());
                ResultBean rb = accountDao.insert(newAccount);
                
                if(rb.getCode()==1){
                    rs.setMsg(StatusConst.STRSUCCESS);
                    rs.setStatus(StatusConst.SUCCESS);
                    
                    //环信注册IM用户[单个]
                    ObjectNode datanode = JsonNodeFactory.instance.objectNode();
                    datanode.put("username","u"+newAccount.getId());
                    datanode.put("password", StringUtil.md5(Constants.DEFAULT_PASSWORD+String.valueOf(newAccount.getId())));
                    createNewIMUserSingle(datanode);
                }
//                rs.setRo(newAccount);
                
                // TODO 自动登录
//                LoginForm loginForm = new LoginForm();
//                loginForm.set
//                this.lgoin(loginForm, null);
                
                return rs;
                
            } else {
                 // 验证码错误
                rs.setMsg("验证码无效");
                return rs;
            }
        }

    }

    @Override
    public ResResult changeMobile(Long userid, String mobile, String code) {
        ResResult rs = new ResResult();
        rs.setMsg(StatusConst.STRFAILURE);
        rs.setStatus(StatusConst.FAILURE);
        
        boolean rt = verificationCodeDao.checkCode(Integer.valueOf(code), mobile);
        
        if(rt) {
            Account record = new Account();
            record.setId(userid);
            record.setPhone(mobile);
            
            accountDao.updateByPrimaryKeySelective(record);
            
            rs.setMsg("更换绑定手机成功");
            rs.setStatus(StatusConst.SUCCESS);
            
            return rs;
        } else {
            // 验证码错误
            rs.setMsg("验证码无效");
            return rs;
        }
        
    }

    @Override
    @Transactional
    public ResResult login(LoginForm loginForm){
        
        ResResult rs = new ResResult();
        rs.setMsg("登录失败");
        rs.setStatus(StatusConst.FAILURE);
        
        try {
            // 取得用户
            Account account = accountDao.getAccountByMobile(loginForm.getPhone());

            if (account == null) {
                // 返回用户不存在提示
                rs.setMsg("帐号不存在");
                rs.setStatus(StatusConst.FAILURE);
                
                return rs;
            }

            // 验证密码
            if (account.getPassword().equals(
                    CommonUtil.password(loginForm.getPasswd()))) {
                
                // 生成token
                String token = CommonUtil.password(String.valueOf(System.currentTimeMillis()));
                // 设置token
                account.setToken(token);
                
                if((StringUtils.isNotBlank(loginForm.getRegid()) && !loginForm.getRegid().equals(account.getRegid())) || !loginForm.getVersion().equals(account.getVersion())) {
                    account.setRegid(loginForm.getRegid());
                    
                    // 设置极光tag
                    if(StringUtils.isNotBlank(loginForm.getRegid())){
                        Set<String> tagsToAdd = new HashSet<String>();
                        
                        List<ClusterUser>  culist = cluserUserDao.getAllByUid(account.getId());
                        for(ClusterUser cu : culist) {
                            tagsToAdd.add(CommonUtil.buildGtag(cu.getCluId()));
                        }
                  
                        JpushUtil.updateDeviceTagAlias(loginForm.getRegid(), null, tagsToAdd, null, loginForm.getVersion());
                    }
                    
                }
                account.setVersion(loginForm.getVersion());
                
                // 更新数据库
                accountDao.updateByPrimaryKeySelective(account);
                
                AccountVO avo = new AccountVO(account);
                rs.setMsg(StatusConst.STRSUCCESS);
                rs.setStatus(StatusConst.SUCCESS);
                rs.setData(avo);
                
            } else {
                // 返回密码错误提示 
                rs.setMsg("密码错误，请重试");
                rs.setStatus(StatusConst.FAILURE);
                
                return rs;
            }

        } catch (Exception e) {
            e.printStackTrace();
            log.error("登录异常：" + e.getMessage());
        }
        
        return rs;
    }

    @Override
    public ResResult updateInfo(AccountUpdateVO vo, String vcode) {
        ResResult rs = new ResResult();
        rs.setMsg("更新失败");
        rs.setStatus(StatusConst.FAILURE);
        boolean rt = true;
        if(StringUtils.isNotBlank(vcode) || StringUtils.isNotBlank(vo.getPhone())) {
            int code = StringUtils.isNotBlank(vcode)?Integer.valueOf(vcode):0;
            rt = verificationCodeDao.checkCode(code, vo.getPhone());
        }
        // 验证短信验证码
         
        if(rt) {
            Account account = vo.toAccount();
            accountDao.updateByPrimaryKeySelective(account);
            
            rs.setStatus(StatusConst.SUCCESS);
            rs.setMsg(StatusConst.STRSUCCESS);
            rs.setData(null);
            
            return rs;
            
        } else {
            // 验证码错误
            rs.setMsg("验证码无效");
            return rs;
        }
        
    }

    @Override
    public ResResult checkPassword(Long uid, String pwd) {

        ResResult rs = new ResResult();
        rs.setMsg("验证失败");
        rs.setStatus(StatusConst.FAILURE);

        // 表单验证出错
        if (uid == null || StringUtils.isBlank(pwd)) {

            rs.setMsg("帐号或密码不能为空");
            rs.setStatus(StatusConst.FAILURE);

            return rs;
        }

        // 取得用户
        Account account = accountDao.selectByKey(uid);

        if (account == null) {
            // 返回用户不存在提示
            rs.setMsg("帐号不存在");
            rs.setStatus(StatusConst.FAILURE);

            return rs;
        }

        // 验证密码
        if (account.getPassword().equals(CommonUtil.password(pwd))) {
            rs.setMsg(StatusConst.STRSUCCESS);
            rs.setStatus(StatusConst.SUCCESS);
            return rs;

        } else {
            // 返回密码错误提示
            rs.setMsg("密码错误，请重试");
            rs.setStatus(StatusConst.FAILURE);
            return rs;
        }
    }

    @Override
    public ResResult resetPassword(ResetPWDForm form) {
        
        ResResult rs = new ResResult();
        rs.setMsg(StatusConst.STRFAILURE);
        rs.setStatus(StatusConst.FAILURE);

        // 验证验证码
        // 验证码有效性验证
        boolean rt = verificationCodeDao.checkCode(form.getVcode(), form.getPhone());
        
        if(rt) {
            Account record = accountDao.getAccountByMobile(form.getPhone());
            record.setPassword(CommonUtil.password(form.getPasswd()));
            
            ResultBean rb = accountDao.updateByPrimaryKeySelective(record);
            if(rb != null && rb.getCode() == 1) {
                rs.setMsg(StatusConst.STRSUCCESS);
                rs.setStatus(StatusConst.SUCCESS);
                return rs;
            } else {
                rs.setMsg("重置密码失败");
                return rs;
            }
        } else {
         // 验证码错误
            rs.setMsg("验证码无效");
            return rs;
        }
    }
    
    @Override
    public ResResult feedback(FeedbackForm form) {
        
        Feedback record = new Feedback();
        record.setAccId(form.getUid());
        record.setContent(form.getContent());
        record.setCreateDt(new Date());
        
        feedbackDao.insert(record);
        
        return new ResResult(null);
    }
    
    @Override
    public ResResult msgSwitch(MsgSwitchForm form) {
        
        Account record = new Account();
        record.setId(form.getUid());
        record.setMsgSwitch(form.getStatus());;
        
        accountDao.updateByPrimaryKeySelective(record);
        
        
        // 取得用户
        Account account = accountDao.selectByKey(form.getUid());
        Set<String> tagsToAdd = new HashSet<String>();
        
        //Jpush推送
        if(form.getStatus()==1){
            JpushUtil.updateDeviceTagAlias(account.getRegid(), false, true);
        }else{

            List<ClusterUser> culist = cluserUserDao.getAllByUid(account.getId());
            for (ClusterUser cu : culist) {
                tagsToAdd.add(CommonUtil.buildGtag(cu.getCluId()));
            }
            JpushUtil.updateDeviceTagAlias(account.getRegid(), null, tagsToAdd,
                    null, account.getVersion());
        }
        return new ResResult(null);
    }
    
    /**
     * 注册IM用户[单个]
     * 
     * 给指定AppKey创建一个新的用户
     * 
     * @param dataNode
     * @return
     */
    public static ObjectNode createNewIMUserSingle(ObjectNode dataNode) {
        
        ObjectNode objectNode = factory.objectNode();

        // check appKey format
        if (!JerseyUtils.match("^(?!-)[0-9a-zA-Z\\-]+#[0-9a-zA-Z]+", APPKEY)) {
            log.error("Bad format of Appkey: " + APPKEY);

            objectNode.put("message", "Bad format of Appkey");

            return objectNode;
        }

        objectNode.removeAll();

        // check properties that must be provided
        if (null != dataNode && !dataNode.has("username")) {
            log.error("Property that named username must be provided .");

            objectNode.put("message",
                    "Property that named username must be provided .");

            return objectNode;
        }
        if (null != dataNode && !dataNode.has("password")) {
            log.error("Property that named password must be provided .");

            objectNode.put("message",
                    "Property that named password must be provided .");

            return objectNode;
        }

        try {
            JerseyWebTarget webTarget = EndPoints.USERS_TARGET.resolveTemplate("org_name",
                    APPKEY.split("#")[0]).resolveTemplate("app_name",
                    APPKEY.split("#")[1]);

            objectNode = JerseyUtils.sendRequest(webTarget, dataNode, credential, HTTPMethod.METHOD_POST, null);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return objectNode;
    }
    
}

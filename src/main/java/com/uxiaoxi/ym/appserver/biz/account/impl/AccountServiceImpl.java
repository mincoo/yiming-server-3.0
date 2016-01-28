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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import com.uxiaoxi.ym.appserver.biz.account.IAccountService;
import com.uxiaoxi.ym.appserver.db.account.dao.IAccountDao;
import com.uxiaoxi.ym.appserver.db.account.dao.IFeedbackDao;
import com.uxiaoxi.ym.appserver.db.account.dto.Account;
import com.uxiaoxi.ym.appserver.db.account.dto.Feedback;
import com.uxiaoxi.ym.appserver.db.cluster.dao.IClusterUserDao;
import com.uxiaoxi.ym.appserver.db.cluster.dto.ClusterUser;
import com.uxiaoxi.ym.appserver.db.verification.dao.IVerificationCodeDao;
import com.uxiaoxi.ym.appserver.framework.util.CommonUtil;
import com.uxiaoxi.ym.appserver.web.account.form.ChangePWDForm;
import com.uxiaoxi.ym.appserver.web.account.form.FeedbackForm;
import com.uxiaoxi.ym.appserver.web.account.form.LoginForm;
import com.uxiaoxi.ym.appserver.web.account.form.RegisterForm;
import com.uxiaoxi.ym.appserver.web.account.form.ResetPWDForm;
import com.uxiaoxi.ym.appserver.web.account.form.SearchByPhoneForm;
import com.uxiaoxi.ym.appserver.web.account.form.SearchForm;
import com.uxiaoxi.ym.appserver.web.account.vo.AccountUpdateVO;
import com.uxiaoxi.ym.appserver.web.account.vo.AccountVO;
import com.uxiaoxi.ym.appserver.web.account.vo.SearchUserResultVO;
import com.uxiaoxi.ym.appserver.web.cluster.vo.ClusterBySnVO;
import com.uxiaoxi.ym.appserver.web.common.vo.ListResult;
import com.uxiaoxi.ym.appserver.web.common.vo.ResResult;
import com.uxiaoxi.ym.appserver.web.common.vo.ResultBean;
import com.uxiaoxi.ym.appserver.web.common.vo.StatusConst;
import com.uxiaoxi.ym.jpush.JpushUtil;

/**
 * @author renhao
 *
 * 2015-1-28
 */
@Service
public class AccountServiceImpl implements IAccountService {
    
    private static final Logger log = LoggerFactory.getLogger(AccountServiceImpl.class);
    
    
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
                accountDao.insert(newAccount);
                
                rs.setMsg(StatusConst.STRSUCCESS);
                rs.setStatus(StatusConst.SUCCESS);
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
    
}

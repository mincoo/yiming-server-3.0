/**
 * IAccountService.java
 */
package com.uxiaoxi.ym.appserver.biz.account;

import com.uxiaoxi.ym.appserver.db.account.dto.Account;
import com.uxiaoxi.ym.appserver.web.account.form.ChangePWDForm;
import com.uxiaoxi.ym.appserver.web.account.form.FeedbackForm;
import com.uxiaoxi.ym.appserver.web.account.form.LoginForm;
import com.uxiaoxi.ym.appserver.web.account.form.MsgSwitchForm;
import com.uxiaoxi.ym.appserver.web.account.form.RegisterForm;
import com.uxiaoxi.ym.appserver.web.account.form.ResetPWDForm;
import com.uxiaoxi.ym.appserver.web.account.vo.AccountUpdateVO;
import com.uxiaoxi.ym.appserver.web.common.vo.ResResult;

/**
 * @author renhao
 *
 * 2015-1-28
 */
public interface IAccountService {

    /**
     * @return Account
     */
    public Account getAccountByMobile(String mobile);

    /**
     * 帐号注册
     * 
     * @param loginForm 登录表单
     * @param code 验证码
     * @return 注册结果
     */
    public ResResult register(RegisterForm registerForm);

    /**
     * 通过主键查询用户
     * 
     * @param userId 
     * @return Account
     */
    public Account getAccountById(Long userId);

    /**
     * 
     * 修改密码
     * 
     * @param Account record
     * @return ResResult
     */
    public ResResult changePassword(ChangePWDForm form);

    /**
     * 更换绑定手机
     * 
     * @param mobile
     * @param code
     * @return
     */
    public ResResult changeMobile(Long userid,String mobile, String code);
    
    
    /**
     * 用户登录
     * 
     * @param loginForm
     * @param errors
     * @return
     */
    public ResResult login(LoginForm loginForm);
    
    /**
     * 更新账户信息
     * 
     * @param vo
     * @param vcode
     * @return
     */
    public ResResult updateInfo(AccountUpdateVO vo,String vcode);

    /**
     * 验证密码是否正确
     * 
     * @param uid
     * @param pwd
     * @return
     */
    public ResResult checkPassword(Long uid, String pwd);

    /**
     * 重置密码
     * 
     * @param form
     * @return
     */
    public ResResult resetPassword(ResetPWDForm form);
    
    /**
     * 提交反馈信息
     * 
     * @param form
     * @return
     */
    public ResResult feedback(FeedbackForm form);
    
    /**
     * 免打扰开关切换
     * 
     * @param form
     * @return
     */
    public ResResult msgSwitch(MsgSwitchForm form);
    
    

}

/**
 * RegisterController.java
 */
package com.uxiaoxi.ym.appserver.web.account.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uxiaoxi.ym.appserver.biz.account.IAccountService;
import com.uxiaoxi.ym.appserver.biz.verification.IVerificationCodeService;
import com.uxiaoxi.ym.appserver.db.account.dto.Account;
import com.uxiaoxi.ym.appserver.framework.sms.Sms;
import com.uxiaoxi.ym.appserver.framework.util.StringUtil;
import com.uxiaoxi.ym.appserver.web.account.form.RegisterForm;
import com.uxiaoxi.ym.appserver.web.common.vo.ResResult;
import com.uxiaoxi.ym.appserver.web.common.vo.ResultBean;
import com.uxiaoxi.ym.appserver.web.common.vo.StatusConst;


/**
 * @author renhao
 *
 * 2015-1-30
 */
@Controller
@RequestMapping("/user")
public class RegisterController {
    // loger
    private static final Logger log = LoggerFactory.getLogger(RegisterController.class);
    
    @Autowired
    private IAccountService accountService;
    
    @Autowired
    private IVerificationCodeService verificationCodeService;
    
    
    @ResponseBody
    @RequestMapping(value="/vcode")
    public ResResult sendCodeJosn(String phone,int type){
        ResResult rs = new ResResult();
        rs.setMsg("验证码发送失败，请重试");
        rs.setStatus(StatusConst.FAILURE);
        
        if (null==phone) {
            rs.setMsg("请输入手机号");
            return rs;
        }
        
        // 如果type=1时，手机号已经注册时不发短信
        if(type == 1) {
            Account account = accountService.getAccountByMobile(phone);
            if(account != null) {
                rs.setMsg("手机号已注册");
                return rs;
            }
        }
        
        // 生成code
        String code = StringUtil.getRandStr(6);

        // 把code存入数据库
        ResultBean rb = verificationCodeService.add(code, phone,type);
        
        // 发送短信
        if(rb.getCode() == 1){
            
            String tplValue = null;
            Long tpid = null;
            // 使用模版发短信
            
            switch (type) {
            case 1:
                tplValue = "#company#=易明校信&#app#=易明校信&#code#=" + code;
                tpid = Sms.REGISTER_TPLID;
                break;
            case 2:
                tplValue = "#company#=易明校信&#code#=" + code;
                tpid = Sms.FINDPWD_TPLID;
                break;
            case 3:
                tplValue = "#company#=易明校信&#code#=" + code;
                tpid = Sms.CHANGEPHONE_TPLID;
                break;
            }
            
            try {
                Sms.tplSendSms(tpid, tplValue, phone);
                
                rs.setMsg(StatusConst.STRSUCCESS);
                rs.setStatus(StatusConst.SUCCESS);
                
            } catch (IOException e) {
                e.printStackTrace();
                log.error("验证码发送失败:"+e.getMessage());
            }
        }

        return rs;
    }
    
    
    @ResponseBody
    @RequestMapping(value="/regist")
    public ResResult registJosn(@Valid RegisterForm registerForm,BindingResult errors){
        
        // 表单验证出错
        if (errors != null && errors.hasErrors()) {

            return new ResResult(StatusConst.FAILURE, "输入信息格式错误",
                    errors.getAllErrors());
        }

        return accountService.register(registerForm);
    }

    @ResponseBody
    @RequestMapping(value="/checkmobile")
    public ResResult checkMobileJosn(String mobile){
        ResResult rt = new ResResult();
        
        Account account = accountService.getAccountByMobile(mobile);
        
        if(account != null ){
            rt.setMsg("手机号已注册");
            rt.setStatus(StatusConst.FAILURE);
            return rt;
        } else {
            rt.setMsg("手机号未注册");
            rt.setStatus(StatusConst.SUCCESS);
            return rt;
        }
    }
    
}

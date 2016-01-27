/**
 * LoginController.java
 */
package com.uxiaoxi.ym.appserver.web.account.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uxiaoxi.ym.appserver.biz.account.IAccountService;
import com.uxiaoxi.ym.appserver.web.account.form.LoginForm;
import com.uxiaoxi.ym.appserver.web.common.vo.ResResult;
import com.uxiaoxi.ym.appserver.web.common.vo.StatusConst;

/**
 * 
 * @author renhao
 * 
 * 2015-1-28
 */
@Controller
@RequestMapping("/user/login")
public class LoginController {
    
    // loger
    // private static final Logger log = LoggerFactory.getLogger(LoginController.class);
    
    @Autowired
    private IAccountService accountService;

    @ResponseBody
    @RequestMapping
    public ResResult jsonLogin(@Valid LoginForm loginForm,BindingResult errors) {
        
        // 表单验证出错则返回登录页面
        if (errors != null && errors.hasErrors()) {

            return new ResResult(StatusConst.FAILURE, "输入信息格式错误",
                    errors.getAllErrors());
        }

        return accountService.login(loginForm);
    }

}

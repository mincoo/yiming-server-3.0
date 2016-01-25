/**
 * AccountLoginController.java
 */
package com.uxiaoxi.ym.appserver.web.account.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uxiaoxi.ym.appserver.biz.account.IAccountService;
import com.uxiaoxi.ym.appserver.web.account.vo.LoginForm;
import com.uxiaoxi.ym.appserver.web.common.vo.ResResult;

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
        return this.lgoin(loginForm, errors);
    }

    @RequestMapping(params="callback")
    public ResResult jsonpLogin(@Valid LoginForm loginForm,BindingResult errors) {
        return this.lgoin(loginForm, errors);
    }

    private ResResult lgoin(LoginForm loginForm,BindingResult errors){
        return accountService.login(loginForm, errors);
    }

}

/**
 * LogoutController.java
 */
package com.uxiaoxi.ym.appserver.web.account.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

/**
 * @author renh
 *
 * 2013-4-24
 */
@Controller
@RequestMapping("/v3/logout")
public class LogoutController {
    @RequestMapping
    public String logout(SessionStatus status,HttpSession session){
        status.setComplete();
        session.invalidate();
        return "redirect:/";
    }
}

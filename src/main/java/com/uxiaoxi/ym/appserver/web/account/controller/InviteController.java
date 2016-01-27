/**
 * InviteController.java
 */
package com.uxiaoxi.ym.appserver.web.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uxiaoxi.ym.appserver.biz.account.IInviteService;
import com.uxiaoxi.ym.appserver.web.common.vo.ResResult;

/**
 * @author renhao
 *
 * 2015年2月25日
 */
@Controller
@RequestMapping("/invite")
public class InviteController {

    @Autowired
    private IInviteService inviteService;
    
    @ResponseBody
    @RequestMapping
    public ResResult inviteJson(Long userid, String mobile, Long cluid) {
        return inviteService.invite(userid,mobile,cluid);
    }
}

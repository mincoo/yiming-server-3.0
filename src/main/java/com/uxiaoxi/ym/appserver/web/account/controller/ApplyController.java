/**
 * ApplyController.java
 */
package com.uxiaoxi.ym.appserver.web.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uxiaoxi.ym.appserver.biz.account.IApplyService;
import com.uxiaoxi.ym.appserver.web.common.vo.ResResult;

/**
 * @author renhao
 *
 * 2015年2月25日
 */
@Controller
@RequestMapping("/apply")
public class ApplyController {

    @Autowired
    private IApplyService applyService;
    
    @ResponseBody
    @RequestMapping
    public ResResult applyJson(Long userid,Long cluid) {
        return this.apply(userid,cluid);
    }

    @RequestMapping(params = "callback")
    public ResResult applyJsonp(Long userid,Long cluid) {
        return this.apply(userid,cluid);
    }
    
    private ResResult apply(Long userid,Long cluid){
        return applyService.apply(userid,cluid);
    }
    
    
}

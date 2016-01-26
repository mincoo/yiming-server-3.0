/**
 * VersionMngController.java
 */
package com.uxiaoxi.ym.appserver.web.version.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uxiaoxi.ym.appserver.biz.version.IVersionMngService;
import com.uxiaoxi.ym.appserver.web.common.vo.ResResult;
import com.uxiaoxi.ym.appserver.web.version.vo.VersionMngForm;

/**
 * @author renhao
 *
 * 2015年3月27日
 */
@Controller
@RequestMapping("/version")
public class VersionMngController {
    
    
    @Autowired
    private IVersionMngService versionMngService;
    
    @ResponseBody
    @RequestMapping
    public ResResult getdataJson(VersionMngForm form) {
    	return versionMngService.getVersion(form);
    }
}

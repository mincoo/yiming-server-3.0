/**
 * TestServer.java
 */
package com.uxiaoxi.ym.appserver.web.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author renhao
 *
 * 2015年11月30日
 */
@Controller
public class TestServer {
	
    @ResponseBody
    @RequestMapping("/test")
    public String test() {
        return "success";
    }
	
}

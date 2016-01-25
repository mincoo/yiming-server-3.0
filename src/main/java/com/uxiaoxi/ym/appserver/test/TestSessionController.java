/**
 * TestController.java
 */
package com.uxiaoxi.ym.appserver.test;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uxiaoxi.ym.appserver.web.common.vo.ResResult;
import com.uxiaoxi.ym.appserver.web.common.vo.StatusConst;

/**
 * @author renhao
 *
 * 2015年2月13日
 */
//@Controller
//@RequestMapping("/test")
public class TestSessionController {

    @ResponseBody
    @RequestMapping("/set")
    public ResResult setSession(HttpSession session) {
        ResResult rs = new ResResult();
        session.setAttribute("test_session", "11111");
        
        rs.setMsg("test session set method. sessionId = " + session.getId());
        rs.setStatus(StatusConst.SUCCESS);
        return rs;
    }

    @ResponseBody
    @RequestMapping("/get")
    public ResResult getSession(HttpSession session) {
        ResResult rs = new ResResult();
        Object sessionvalue = session.getAttribute("test_session");
        
        rs.setMsg("test session get method. sessionId = " + session.getId());
        rs.setStatus(StatusConst.SUCCESS);
        rs.setData(sessionvalue);
        
        return rs;
    }
}

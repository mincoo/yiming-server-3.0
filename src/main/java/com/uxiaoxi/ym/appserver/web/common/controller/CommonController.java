/**
 * CommonController.java
 */
package com.uxiaoxi.ym.appserver.web.common.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author renhao
 *
 * 2015年2月5日
 */
@Controller
public class CommonController {
//    
//    @Autowired
//    private ILocalDao localDao;

    @RequestMapping("/error")
    public String error(HttpServletRequest request,ModelMap map){
        
        Object rs = request.getAttribute("rs");
        map.put("rs", rs);
        return "common/error";
    }
    
//    @RequestMapping("/test/search")
//    public String search(){ 
//        return "test/search";
//    }
    
//    @ResponseBody
//    @RequestMapping("/test/java")
//    public String test(String lat,String lng,String imei) {
//        Local l = new Local();
//        l.setLat(lat);
//        l.setLng(lng);
//        l.setImei(imei);
//        l.setTimestamp(new Date());
//        localDao.insert(l);
//        
//        return "success";
//    }
}

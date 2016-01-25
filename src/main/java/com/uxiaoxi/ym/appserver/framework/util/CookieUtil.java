/**
 * CookieUtilImpl.java
 */
package com.uxiaoxi.ym.appserver.framework.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author zhaocm
 * 
 *         2013-3-27
 */
public class CookieUtil {

//    private Logger log = LoggerFactory.getLogger(CookieUtil.class);
    
    private static String path = "/mindoa";
    private static int maxAge = 24 * 3600;

    /**
     * 添加cookie，默认生命周期
     */
    public static void addCookieDefaultAge(String name, String value,
            HttpServletResponse response) {
        Cookie c;
        try {
            c = new Cookie(name, URLEncoder.encode(value, "utf-8"));
            c.setMaxAge(maxAge);
            c.setPath(path);
            response.addCookie(c);
            
        } catch (UnsupportedEncodingException e) {
            
            e.printStackTrace();
        }
    }

    /** 添加cookie，自定义生命周期 */
    public static void addCookie(String name, String value, int age,
            HttpServletResponse response) throws UnsupportedEncodingException {
        Cookie c = new Cookie(name, URLEncoder.encode(value, "utf-8"));
        c.setMaxAge(age);
        c.setPath(path);
        response.addCookie(c);
    }

    /**
     * 删除cookie
     */
    public void deleteCookie(String name, HttpServletResponse response) {
        Cookie c = new Cookie(name, "");
        c.setMaxAge(0);
        c.setPath(path);
        response.addCookie(c);
    }

    /**
     * 依据cookie的名称查找cookie的值， 如果不存在对应的cookie,返回null。
     */

    public static String findCookie(String name, HttpServletRequest request)
            throws UnsupportedEncodingException {
        String value = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                Cookie curr = cookies[i];
                if (curr.getName().equals(name)) {
                    value = URLDecoder.decode(curr.getValue(), "utf-8");
                }
            }
        }
        return value;
    }
}

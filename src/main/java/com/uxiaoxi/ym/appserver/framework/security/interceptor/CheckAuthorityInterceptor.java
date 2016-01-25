/**
 * BuildUserInterceptor.java
 */
package com.uxiaoxi.ym.appserver.framework.security.interceptor;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.uxiaoxi.ym.appserver.biz.account.IAccountService;
import com.uxiaoxi.ym.appserver.db.account.dto.Account;
import com.uxiaoxi.ym.appserver.framework.util.CommonUtil;
import com.uxiaoxi.ym.appserver.web.common.vo.ResResult;
import com.uxiaoxi.ym.appserver.web.common.vo.StatusConst;


/**
 * @author renhao
 *
 * 2015年2月4日
 */
public class CheckAuthorityInterceptor implements HandlerInterceptor {

     private Logger log = LoggerFactory.getLogger(CheckAuthorityInterceptor.class);
     
     @Autowired
     private IAccountService accountService;

    @Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler) throws Exception {
        // 获得请求的uri 
        // 以下几个页面无需验证token 和 sign
        String uri = request.getRequestURI();
        if ("/error".equals(uri) || uri.indexOf("/test") >=0 ) {
            return true;
        }

        Enumeration<String> enu=request.getParameterNames(); 
        List<String> params = new ArrayList<String>();
        
        while(enu.hasMoreElements()){
            String paraName=(String)enu.nextElement();
            if(!"sign".equals(paraName)) {
                String paraValue = request.getParameter(paraName);
                params.add(paraName + "=" + paraValue);
            }
        }
        
        String md5 = CommonUtil.sign(params);
        
        String sign = request.getParameter("sign");
        
        if(StringUtils.isNotBlank(sign) && sign.equals(md5)) {
            
            // 获得token
            String token = request.getParameter("token");
            // 获得uid
            String uid = request.getParameter("uid");

            // 验证token
            if(StringUtils.isNotBlank(token) && StringUtils.isNotBlank(uid)) {
                
                
                if(!StringUtils.isNumeric(uid)){
                    ResResult rs = new ResResult();
                    rs.setStatus(StatusConst.FAILURE);
                    rs.setMsg("uid 不正确");
                    request.setAttribute("rs", rs);
                    request.getRequestDispatcher("/error").forward(request, response);
                    return false;
                };
                
                Account account = accountService.getAccountById(Long.valueOf(uid));
                if(token.equals(account.getToken())) {
                    return true;
                } else {
                    ResResult rs = new ResResult();
                    rs.setStatus(StatusConst.FAILURE);
                    rs.setMsg("您的帐号已在别的设备上登录，请重新登录");
                    request.setAttribute("rs", rs);
                    request.getRequestDispatcher("/error").forward(request, response);
                    return false;
                }
            } else {
                return true;
            }
            
        } else {
            
            ResResult rs = new ResResult();
            rs.setStatus(StatusConst.FAILURE);
            rs.setMsg("参数和签名不匹配");
            rs.setData(request.getParameterMap());
            request.setAttribute("rs", rs);
            request.getRequestDispatcher("/error").forward(request, response);
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        // 生成视图之前执行
        // 获得session
//        HttpSession session = request.getSession();
//        // 从session中获取User对象
//        User user = (User) session.getAttribute(User.SYS_USER_SESSION_KEY);
//
//        if (user instanceof MemberUser) {
//            if (modelAndView != null) {
//                modelAndView.getModel().put("mind_user", user);
//            }
//        }

    }

    
    @Override
    public void afterCompletion(HttpServletRequest request,
            HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        // 最后执行，可用于释放资源

    }

    public static void main(String []args) {
    	
    }
}

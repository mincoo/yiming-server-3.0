/**
 * AccountController.java
 */
package com.uxiaoxi.ym.appserver.web.account.controller;

import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uxiaoxi.ym.appserver.biz.account.IAccountService;
import com.uxiaoxi.ym.appserver.db.account.dto.Account;
import com.uxiaoxi.ym.appserver.web.account.vo.AccountUpdateVO;
import com.uxiaoxi.ym.appserver.web.account.vo.AccountVO;
import com.uxiaoxi.ym.appserver.web.account.vo.ChangePWDForm;
import com.uxiaoxi.ym.appserver.web.account.vo.ResetPWDForm;
import com.uxiaoxi.ym.appserver.web.account.vo.SearchByPhoneForm;
import com.uxiaoxi.ym.appserver.web.account.vo.SearchForm;
import com.uxiaoxi.ym.appserver.web.common.vo.ResResult;
import com.uxiaoxi.ym.appserver.web.common.vo.StatusConst;

/**
 * @author renhao
 *
 *         2015年2月9日
 */
@Controller
@RequestMapping("/user")
public class AccountController {

    @Autowired
    private IAccountService accountService;

    /**
     * 
     * 验证密码
     * 
     * @param userId
     * @param password
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/ckpwd")
    public ResResult checkPasswordJson(Long userId, String password) {
    	return accountService.checkPassword(userId, password);

    }
    /**
     * 
     * 修改密码
     * 
     * @param userId
     * @param newPassword
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/chpwd")
    public ResResult changePasswordJson(@Valid ChangePWDForm form ,BindingResult errors) {
    	 return accountService.changePassword(form,errors);
    }
    
    @ResponseBody
    @RequestMapping(value = "/repwd")
    public ResResult resetPasswordJson(@Valid ResetPWDForm form, BindingResult errors) {
    	  return accountService.resetPassword(form, errors);
    }
    /**
     * 
     * 更改手机号
     * 
     * @param mobile
     * @param code
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/cgmb")
    public ResResult changeMobileJson(Long userid, String mobile, String code) {
    	  ResResult rs = new ResResult();
          rs.setMsg("更换绑定手机失败");
          rs.setStatus(StatusConst.FAILURE);

          // 如果为空则直接失败
          if (StringUtils.isBlank(mobile) || StringUtils.isBlank(code)) {
              return rs;
          } else {
              return accountService.changeMobile(userid,mobile, code);
          }
    }


    @ResponseBody
    @RequestMapping(value = "/getinfo")
    public ResResult getInfoJson(Long uid) {
    	 Account account = accountService.getAccountById(uid);
         if(account != null) {
             AccountVO avo = new AccountVO(account);
             return new ResResult(StatusConst.SUCCESS,StatusConst.STRSUCCESS,avo);
         } else {
             return new ResResult(StatusConst.FAILURE,StatusConst.STRFAILURE,null);
         }
         
    }
    
    @ResponseBody
    @RequestMapping(value = "/update")
    public ResResult updateInfoJson(AccountUpdateVO vo,String vcode) {
    	return accountService.updateInfo(vo, vcode);
    }
    /**
     * 
     * 通过姓名搜索用户
     * 
     * @param form
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/search")
    public ResResult searchByNameJson(SearchForm form) {
    	return accountService.searchByName(form);
    }
    /**
     * 
     * 通过手机号搜索用户
     * 
     * @param form
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/searchbyphone")
    public ResResult searchByPhoneJson(SearchByPhoneForm form) {
    	return accountService.searchByPhone(form);
    }
    
  
   
}

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

    @ResponseBody
    @RequestMapping(value = "/ckpwd")
    public ResResult checkPasswordJson(Long userId, String password) {
        return this.checkPassword(userId, password);

    }

    @RequestMapping(value = "/ckpwd", params = "callback")
    public ResResult checkPasswordJsonp(Long userId, String password) {
        return this.checkPassword(userId, password);
    }

    /**
     * 
     * 验证密码
     * 
     * @param userId
     * @param password
     * @return
     */
    private ResResult checkPassword(Long uid, String pwd) {
        return accountService.checkPassword(uid, pwd);
    }

    @ResponseBody
    @RequestMapping(value = "/chpwd")
    public ResResult changePasswordJson(@Valid ChangePWDForm form ,BindingResult errors) {
        return this.changePassword(form, errors);
    }

    @RequestMapping(value = "/chpwd", params = "callback")
    public ResResult changePasswordJsonp(@Valid ChangePWDForm form ,BindingResult errors) {
        return this.changePassword(form, errors);
    }

    private ResResult changePassword(ChangePWDForm form ,BindingResult errors){
        return accountService.changePassword(form,errors);
    }
    
    @ResponseBody
    @RequestMapping(value = "/repwd")
    public ResResult resetPasswordJson(@Valid ResetPWDForm form, BindingResult errors) {
        return this.resetPassword(form, errors);
    }

    @RequestMapping(value = "/repwd", params = "callback")
    public ResResult resetPasswordJsonp(@Valid ResetPWDForm form ,BindingResult errors) {
        return this.resetPassword(form, errors);
    }
    
    /**
     * 
     * 修改密码
     * 
     * @param userId
     * @param newPassword
     * @return
     */
    private ResResult resetPassword(ResetPWDForm form, BindingResult errors) {
        return accountService.resetPassword(form, errors);
    }

    @ResponseBody
    @RequestMapping(value = "/cgmb")
    public ResResult changeMobileJson(Long userid, String mobile, String code) {
        return this.changeMobile(userid,mobile, code);
    }

    @RequestMapping(value = "/cgmb", params = "callback")
    public ResResult changeMobileJsonp(Long userid, String mobile, String code) {
        return this.changeMobile(userid,mobile, code);
    }

    /**
     * 
     * 更改手机号
     * 
     * @param mobile
     * @param code
     * @return
     */
    private ResResult changeMobile(Long userid, String mobile, String code) {
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
        return this.getInfo(uid);
    }
    
    @RequestMapping(value = "/getinfo", params = "callback")
    public ResResult getInfoJsonp(Long uid) {
        return this.getInfo(uid);
    }
    
    private ResResult getInfo(Long uid) {
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
        return this.updateInfo(vo, vcode);
    }
    
    @RequestMapping(value = "/update", params = "callback")
    public ResResult updateInfoJsonp(AccountUpdateVO vo,String vcode) {
        return this.updateInfo(vo, vcode);
    }
    
    private ResResult updateInfo(AccountUpdateVO vo,String vcode) {
        return accountService.updateInfo(vo, vcode);
    }
    
    @ResponseBody
    @RequestMapping(value = "/search")
    public ResResult searchByNameJson(SearchForm form) {
        return this.searchByName(form);
    }
    
    @RequestMapping(value = "/search", params = "callback")
    public ResResult searchByNameJsonp(SearchForm form) {
        return this.searchByName(form);
    }
    
    /**
     * 
     * 通过姓名搜索用户
     * 
     * @param form
     * @return
     */
    private ResResult searchByName(SearchForm form) {
        return accountService.searchByName(form);
        
    }
    
    
    @ResponseBody
    @RequestMapping(value = "/searchbyphone")
    public ResResult searchByPhoneJson(SearchByPhoneForm form) {
        return this.searchByPhone(form);
    }
    
    @RequestMapping(value = "/searchbyphone", params = "callback")
    public ResResult searchByPhoneJsonp(SearchByPhoneForm form) {
        return this.searchByPhone(form);
    }
    /**
     * 
     * 通过手机号搜索用户
     * 
     * @param form
     * @return
     */
    private ResResult searchByPhone(SearchByPhoneForm form) {
        return accountService.searchByPhone(form);
        
    }
}

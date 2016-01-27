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
     * 修改密码
     * 
     * @param form
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/chpwd")
    public ResResult changePasswordJson(@Valid ChangePWDForm form,
            BindingResult errors) {

        // 表单验证出错则返回登录页面
        if (errors != null && errors.hasErrors()) {

            return new ResResult(StatusConst.FAILURE, "输入信息格式错误",
                    errors.getAllErrors());
        }

        return accountService.changePassword(form);
    }

    /**
     * 
     * 重置密码
     * 
     * @param form
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/repwd")
    public ResResult resetPasswordJson(@Valid ResetPWDForm form,
            BindingResult errors) {

        // 表单验证出错
        if (errors != null && errors.hasErrors()) {

            return new ResResult(StatusConst.FAILURE, "输入信息格式错误",
                    errors.getAllErrors());
        }

        return accountService.resetPassword(form);
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
            return accountService.changeMobile(userid, mobile, code);
        }
    }
    
    /**
     * 
     * 获取用户信息
     * 
     * @param uid
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getinfo")
    public ResResult getInfoJson(Long uid) {
        Account account = accountService.getAccountById(uid);
        if (account != null) {
            AccountVO avo = new AccountVO(account);
            return new ResResult(StatusConst.SUCCESS, StatusConst.STRSUCCESS,
                    avo);
        } else {
            return new ResResult(StatusConst.FAILURE, StatusConst.STRFAILURE,
                    null);
        }

    }
    
    /**
     * 
     * 修改用户信息
     * 
     * @param vo
     * @param vcode
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/update")
    public ResResult updateInfoJson(AccountUpdateVO vo, String vcode) {
        return accountService.updateInfo(vo, vcode);
    }

}

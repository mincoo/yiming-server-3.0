/**
 * LoginForm.java
 */
package com.uxiaoxi.ym.appserver.web.account.vo;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author renh
 *
 * 2013-4-9
 */
public class LoginForm {

    /**
     * 用户名
     */
    @NotBlank(message = "请输入手机号")
    @Pattern(regexp = "^1\\d{10}$", message = "不是有效的手机号") 
    private String phone;
    
    /**
     * 密码
     */
    @NotBlank(message = "请输入密码")
    @Length(min=6, max=20, message="密码长度应在6-20之间")
    private String passwd;
    
//    @NotBlank(message = "regid不能为空")
    private String regid;
    
    private String version;

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the passwd
     */
    public String getPasswd() {
        return passwd;
    }

    /**
     * @param passwd the passwd to set
     */
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    /**
     * @return the regid
     */
    public String getRegid() {
        return regid;
    }

    /**
     * @param regid the regid to set
     */
    public void setRegid(String regid) {
        this.regid = regid;
    }

    /**
     * @return the version
     */
    public String getVersion() {
        return version == null ? "" : version;
    }

    /**
     * @param version the version to set
     */
    public void setVersion(String version) {
        this.version = version;
    }

}

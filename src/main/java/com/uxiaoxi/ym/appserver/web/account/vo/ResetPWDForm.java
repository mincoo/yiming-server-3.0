/**
 * ResetPWDForm.java
 */
package com.uxiaoxi.ym.appserver.web.account.vo;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author renhao
 *
 * 2015年3月9日
 */
public class ResetPWDForm {

    @NotBlank
    private String phone;
    
    @Length(min=6, max=20, message="密码长度必须在6-20之间")
    private String passwd;
    
    @NotNull
    private Integer vcode;

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
     * @return the vcode
     */
    public Integer getVcode() {
        return vcode;
    }

    /**
     * @param vcode the vcode to set
     */
    public void setVcode(Integer vcode) {
        this.vcode = vcode;
    }

}

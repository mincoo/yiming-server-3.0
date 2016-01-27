/**
 * ChangePWDForm.java
 */
package com.uxiaoxi.ym.appserver.web.account.form;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author renhao
 *
 * 2015年3月9日
 */
public class ChangePWDForm {
    
    @NotNull
    private Long uid; 
    
    @NotBlank
    private String oldpwd;
    
    @Length(min=6, max=20, message="密码长度必须在6-20之间")
    private String newpwd;

    /**
     * @return the uid
     */
    public Long getUid() {
        return uid;
    }

    /**
     * @param uid the uid to set
     */
    public void setUid(Long uid) {
        this.uid = uid;
    }

    /**
     * @return the oldpwd
     */
    public String getOldpwd() {
        return oldpwd;
    }

    /**
     * @param oldpwd the oldpwd to set
     */
    public void setOldpwd(String oldpwd) {
        this.oldpwd = oldpwd;
    }

    /**
     * @return the newpwd
     */
    public String getNewpwd() {
        return newpwd;
    }

    /**
     * @param newpwd the newpwd to set
     */
    public void setNewpwd(String newpwd) {
        this.newpwd = newpwd;
    }
}

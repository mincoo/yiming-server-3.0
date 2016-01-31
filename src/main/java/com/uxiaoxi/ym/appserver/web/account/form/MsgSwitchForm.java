/**
 * MsgSwitchForm.java
 */
package com.uxiaoxi.ym.appserver.web.account.form;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @author renh
 *
 * 2013-4-9
 */
public class MsgSwitchForm {

    @NotNull
    private Long uid; 
    
    @NotBlank
    private Integer status;

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
     * @return the status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(Integer status) {
        this.status = status;
    }




}

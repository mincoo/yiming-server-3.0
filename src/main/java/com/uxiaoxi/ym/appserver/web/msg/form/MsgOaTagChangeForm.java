/**
 * MsgOaTagChangeForm.java
 */
package com.uxiaoxi.ym.appserver.web.msg.form;

import javax.validation.constraints.NotNull;

/**
 * @author renhao
 *
 * 2015年3月11日
 */
public class MsgOaTagChangeForm {
    
    @NotNull
    private Long uid;
    
    @NotNull
    private Long oaid;
    
    @NotNull
    private Long status;
    
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
     * @return the oaid
     */
    public Long getOaid() {
        return oaid;
    }

    /**
     * @param oaid
     *            the oaid to set
     */
    public void setOaid(Long oaid) {
        this.oaid = oaid;
    }

    /**
     * @return the status
     */
    public Long getStatus() {
        return status;
    }

    /**
     * @param status
     *            the status to set
     */
    public void setStatus(Long status) {
        this.status = status;
    }

}

/**
 * MsgUpdatePushSumForm.java
 */
package com.uxiaoxi.ym.appserver.web.msg.form;

import javax.validation.constraints.NotNull;

/**
 * @author renhao
 *
 * 2015年3月11日
 */
public class MsgUpdatePushSumForm {
    
    @NotNull
    private Long uid;
    
    @NotNull
    private Long num;
    
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
     * @return the num
     */
    public Long getNum() {
        return num;
    }

    /**
     * @param num the num to set
     */
    public void setNum(Long num) {
        this.num = num;
    }



}

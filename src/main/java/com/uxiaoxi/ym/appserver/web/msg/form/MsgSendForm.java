/**
 * MsgSendForm.java
 */
package com.uxiaoxi.ym.appserver.web.msg.form;

import javax.validation.constraints.NotNull;


/**
 * @author renhao
 *
 * 2015年3月11日
 */
public class MsgSendForm extends MsgGSendForm {

    /**
     * 接收用户ID
     */
    @NotNull
    private Long nid;

    /**
     * @return the nid
     */
    public Long getNid() {
        return nid;
    }

    /**
     * @param nid the nid to set
     */
    public void setNid(Long nid) {
        this.nid = nid;
    }
    
}

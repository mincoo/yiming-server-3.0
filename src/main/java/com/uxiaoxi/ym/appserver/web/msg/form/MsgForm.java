/**
 * MsgListForm.java
 */
package com.uxiaoxi.ym.appserver.web.msg.form;

/**
 * @author renhao
 *
 * 2015年3月11日
 */
public class MsgForm {

    private Long uid;
    
    private Long start;

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
     * @return the start
     */
    public Long getStart() {
        return start;
    }

    /**
     * @param start the start to set
     */
    public void setStart(Long start) {
        this.start = start;
    }
}

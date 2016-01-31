/**
 * MsgDataForm.java
 */
package com.uxiaoxi.ym.appserver.web.msg.form;

/**
 * @author renhao
 *
 * 2015年3月11日
 */
public class MsgDataForm {

    private Long uid;
    
    private Long mid;
    
    private Long gid;

    /**
     * @return the gid
     */
    public Long getGid() {
        return gid;
    }

    /**
     * @param gid the gid to set
     */
    public void setGid(Long gid) {
        this.gid = gid;
    }

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
     * @return the mid
     */
    public Long getMid() {
        return mid;
    }

    /**
     * @param mid the mid to set
     */
    public void setMid(Long mid) {
        this.mid = mid;
    }
}

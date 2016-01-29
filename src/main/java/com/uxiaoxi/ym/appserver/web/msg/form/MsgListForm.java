/**
 * MsgListForm.java
 */
package com.uxiaoxi.ym.appserver.web.msg.form;

/**
 * @author renhao
 *
 * 2015年3月11日
 */
public class MsgListForm {

    private Long uid;
    
    private Long  version;
    
    private Long  gid;

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
     * @return the version
     */
    public Long getVersion() {
        return version;
    }

    /**
     * @param version the version to set
     */
    public void setVersion(Long version) {
        this.version = version;
    }

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

}

/**
 * AddUserForm.java
 */
package com.uxiaoxi.ym.appserver.web.cluster.form;

import javax.validation.constraints.NotNull;

/**
 * @author renhao
 *
 * 2015年3月10日
 */
public class AddDelUserForm {

    @NotNull
    private Long uid;
    
    @NotNull
    private Long gid;
    
    @NotNull
    private Long nid;
    
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

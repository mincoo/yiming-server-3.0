/**
 * ClusterUserListForm.java
 */
package com.uxiaoxi.ym.appserver.web.cluster.form;

import javax.validation.constraints.NotNull;

/**
 * @author renhao
 *
 * 2015年3月10日
 */
public class ClusterUserListForm {
    
    @NotNull
    private Long uid;
    
    @NotNull
    private Long gid;
    
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

}

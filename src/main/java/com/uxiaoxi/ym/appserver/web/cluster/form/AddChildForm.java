/**
 * AddChildForm.java
 */
package com.uxiaoxi.ym.appserver.web.cluster.form;

import javax.validation.constraints.NotNull;

/**
 * @author renhao
 *
 * 2015年3月10日
 */
public class AddChildForm {

    @NotNull
    private Long uid;
    
    @NotNull
    private Long gid;
    
    @NotNull
    private String sid;
    

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
	 * @return the sid
	 */
	public String getSid() {
		return sid;
	}

	/**
	 * @param sid the sid to set
	 */
	public void setSid(String sid) {
		this.sid = sid;
	}
}

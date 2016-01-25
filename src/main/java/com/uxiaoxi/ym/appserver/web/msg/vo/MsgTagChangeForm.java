/**
 * MsgTagChangeForm.java
 */
package com.uxiaoxi.ym.appserver.web.msg.vo;

import javax.validation.constraints.NotNull;

/**
 * @author renhao
 *
 * 2015年3月11日
 */
public class MsgTagChangeForm {
    
    @NotNull
    private Long uid;
    
    @NotNull
    private Long gid;
    
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
	 * @return the status
	 */
	public Long getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Long status) {
		this.status = status;
	}


}

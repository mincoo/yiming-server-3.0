/**
 * AddUserForm.java
 */
package com.uxiaoxi.ym.appserver.web.cluster.vo;

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
    
    private Integer type;

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

	/**
	 * @return the type
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(Integer type) {
		this.type = type;
	}

}

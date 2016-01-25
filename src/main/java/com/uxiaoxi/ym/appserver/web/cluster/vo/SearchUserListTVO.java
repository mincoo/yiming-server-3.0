/**
 * SearchUserListTVO.java
 */
package com.uxiaoxi.ym.appserver.web.cluster.vo;

import java.util.List;

/**
 * @author renhao
 *
 * 2015年3月10日
 */
public class SearchUserListTVO {
	private Long id;
	
    private Long tid;
    
    private String tname;
    
    private String tface;
    
    private String phone;
    
    private Long ssize;
    
    private List<SearchUserListTSub> slist;

	/**
	 * @return the tid
	 */
	public Long getTid() {
		return tid;
	}

	/**
	 * @param tid the tid to set
	 */
	public void setTid(Long tid) {
		this.tid = tid;
	}

	/**
	 * @return the tname
	 */
	public String getTname() {
		return tname;
	}

	/**
	 * @param tname the tname to set
	 */
	public void setTname(String tname) {
		this.tname = tname;
	}

	/**
	 * @return the tface
	 */
	public String getTface() {
		return tface;
	}

	/**
	 * @param tface the tface to set
	 */
	public void setTface(String tface) {
		this.tface = tface;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the ssize
	 */
	public Long getSsize() {
		return ssize;
	}

	/**
	 * @param ssize the ssize to set
	 */
	public void setSsize(Long ssize) {
		this.ssize = ssize;
	}

	/**
	 * @return the slist
	 */
	public List<SearchUserListTSub> getSlist() {
		return slist;
	}

	/**
	 * @param slist the slist to set
	 */
	public void setSlist(List<SearchUserListTSub> slist) {
		this.slist = slist;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

}

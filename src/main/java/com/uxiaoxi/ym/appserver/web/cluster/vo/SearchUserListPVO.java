/**
 * SearchUserListPVO.java
 */
package com.uxiaoxi.ym.appserver.web.cluster.vo;

import java.util.List;

/**
 * @author renhao
 *
 * 2015年3月10日
 */
public class SearchUserListPVO {
	private Long id;

    private Long pid;
    
    private String pname;
    
    private String pface;
    
    private String phone;
    
    private Long ssize;
    
    private List<SearchUserListPSub> slist;

	/**
	 * @return the pid
	 */
	public Long getPid() {
		return pid;
	}

	/**
	 * @param pid the pid to set
	 */
	public void setPid(Long pid) {
		this.pid = pid;
	}

	/**
	 * @return the pname
	 */
	public String getPname() {
		return pname;
	}

	/**
	 * @param pname the pname to set
	 */
	public void setPname(String pname) {
		this.pname = pname;
	}

	/**
	 * @return the pface
	 */
	public String getPface() {
		return pface;
	}

	/**
	 * @param pface the pface to set
	 */
	public void setPface(String pface) {
		this.pface = pface;
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
	public List<SearchUserListPSub> getSlist() {
		return slist;
	}

	/**
	 * @param slist the slist to set
	 */
	public void setSlist(List<SearchUserListPSub> slist) {
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

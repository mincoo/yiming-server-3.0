/**
 * SearchUserListSVO.java
 */
package com.uxiaoxi.ym.appserver.web.cluster.vo;

import java.util.List;

/**
 * @author renhao
 *
 * 2015年3月10日
 */
public class SearchUserListSVO {
	private Long sid;
    
    private String sname;
    
    private String sface;
    
    private String num;
    
    private Long psize;
    
    private List<SearchUserListSSub> plist;

	/**
	 * @return the sid
	 */
	public Long getSid() {
		return sid;
	}

	/**
	 * @param sid the sid to set
	 */
	public void setSid(Long sid) {
		this.sid = sid;
	}

	/**
	 * @return the sname
	 */
	public String getSname() {
		return sname;
	}

	/**
	 * @param sname the sname to set
	 */
	public void setSname(String sname) {
		this.sname = sname;
	}

	/**
	 * @return the sface
	 */
	public String getSface() {
		return sface;
	}

	/**
	 * @param sface the sface to set
	 */
	public void setSface(String sface) {
		this.sface = sface;
	}

	/**
	 * @return the num
	 */
	public String getNum() {
		return num;
	}

	/**
	 * @param num the num to set
	 */
	public void setNum(String num) {
		this.num = num;
	}

	/**
	 * @return the psize
	 */
	public Long getPsize() {
		return psize;
	}

	/**
	 * @param psize the psize to set
	 */
	public void setPsize(Long psize) {
		this.psize = psize;
	}

	/**
	 * @return the plist
	 */
	public List<SearchUserListSSub> getPlist() {
		return plist;
	}

	/**
	 * @param plist the plist to set
	 */
	public void setPlist(List<SearchUserListSSub> plist) {
		this.plist = plist;
	}

}

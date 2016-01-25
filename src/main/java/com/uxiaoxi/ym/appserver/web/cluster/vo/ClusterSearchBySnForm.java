/**
 * ClusterSearchForm.java
 */
package com.uxiaoxi.ym.appserver.web.cluster.vo;

/**
 * @author zoujy
 *
 * 2015年8月27日
 */
public class ClusterSearchBySnForm {

    private String sn;
    
    private Long start;

    /**
     * @return the start
     */
    public Long getStart() {
        return start;
    }

    /**
     * @param start the start to set
     */
    public void setStart(Long start) {
        this.start = start;
    }

	/**
	 * @return the sn
	 */
	public String getSn() {
		return sn;
	}

	/**
	 * @param sn the sn to set
	 */
	public void setSn(String sn) {
		this.sn = sn;
	}

}

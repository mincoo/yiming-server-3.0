/**
 * ClusterSearchForm.java
 */
package com.uxiaoxi.ym.appserver.web.cluster.form;

/**
 * @author renhao
 *
 * 2015年3月10日
 */
public class ClusterSearchForm {

    //private String name;
    
    private Long gid;
    
    private Long start;

//    /**
//     * @return the name
//     */
//    public String getName() {
//        return name;
//    }
//
//    /**
//     * @param name the name to set
//     */
//    public void setName(String name) {
//        this.name = name;
//    }

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

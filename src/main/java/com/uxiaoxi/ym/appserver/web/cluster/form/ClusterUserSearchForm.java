/**
 * ClusterUserSearchForm.java
 */
package com.uxiaoxi.ym.appserver.web.cluster.form;

import javax.validation.constraints.NotNull;

/**
 * @author renhao
 *
 * 2015年3月10日
 */
public class ClusterUserSearchForm {

    @NotNull
    private Long uid;
    
    private Long start;

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

}

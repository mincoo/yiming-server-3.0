/**
 * ClusterSearchBySnForm.java
 */
package com.uxiaoxi.ym.appserver.web.cluster.form;

import javax.validation.constraints.NotNull;

/**
 * @author zoujy
 *
 * 2015年8月27日
 */
public class ClusterSearchBySnForm {

    @NotNull
    private String sn;
    
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

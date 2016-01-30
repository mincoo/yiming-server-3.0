/**
 * SearchCNameVO.java
 */
package com.uxiaoxi.ym.appserver.web.cluster.vo;

import java.io.Serializable;

/**
 * @author renhao
 *
 * 2015年3月10日
 */
public class SearchCNameVO  implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 7811382518527994772L;
    private Long uid;
    
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
     * @return the cname
     */
    public String getCname() {
        return cname;
    }

    /**
     * @param cname the cname to set
     */
    public void setCname(String cname) {
        this.cname = cname;
    }

    private String cname;
    
    public SearchCNameVO(){
        
    }
}

/**
 * SearchCNameVO.java
 */
package com.uxiaoxi.ym.appserver.web.cluster.vo;

/**
 * @author renhao
 *
 * 2015年3月10日
 */
public class SearchCNameVO {

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

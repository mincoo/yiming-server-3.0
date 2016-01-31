/**
 * SearchResultVO.java
 */
package com.uxiaoxi.ym.appserver.web.cluster.vo;

import java.io.Serializable;


/**
 * @author renhao
 *
 * 2015年3月10日
 */
public class ClusterUserSearchResultVO extends ClusterUserSearchResult implements Serializable{
    

    /**
     * 
     */
    private static final long serialVersionUID = 3983184983612380269L;
    private Long id;

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
    
    public ClusterUserSearchResult toClusterUserSearchResult(){
        ClusterUserSearchResult c = new ClusterUserSearchResult();
        c.setGid(this.getGid());
        c.setName(this.getName());
        c.setUid(this.getUid());
        c.setSn(this.getSn());
        c.setSchool(this.getSchool());
        c.setProvince(this.getProvince());
        c.setCity(this.getCity());
        c.setDistrict(this.getDistrict());
        c.setFace(this.getFace());
        c.setMsgflg(this.getMsgflg());
        return c;
    }

}

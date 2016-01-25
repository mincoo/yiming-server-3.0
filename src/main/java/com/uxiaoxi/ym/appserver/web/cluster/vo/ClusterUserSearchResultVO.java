/**
 * SearchResultVO.java
 */
package com.uxiaoxi.ym.appserver.web.cluster.vo;


/**
 * @author renhao
 *
 * 2015年3月10日
 */
public class ClusterUserSearchResultVO extends ClusterUserSearchResult{
    
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
        c.setPnum(this.getPnum());
        c.setTnum(this.getTnum());
        c.setSnum(this.getSnum());
        c.setJpushflg(this.getJpushflg());
        return c;
    }

}

/**
 * ClusterUserListVO.java
 */
package com.uxiaoxi.ym.appserver.web.cluster.vo;

import com.uxiaoxi.ym.appserver.web.account.vo.SearchUserResultVO;

/**
 * @author renhao
 *
 * 2015年3月11日
 */
public class ClusterUserListVO extends SearchUserResultVO{
    
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
    
    public SearchUserResultVO toSearchUserResultVO(){
        SearchUserResultVO vo = new SearchUserResultVO();
        vo.setUid(this.getUid());
        vo.setType(this.getType());
        vo.setFace(this.getFace());
        vo.setName(this.getName());
        return vo;
    }

}

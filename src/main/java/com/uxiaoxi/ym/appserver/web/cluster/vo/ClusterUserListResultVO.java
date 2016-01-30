/**
 * ClusterUserListResultVO.java
 */
package com.uxiaoxi.ym.appserver.web.cluster.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @author renhao
 *
 * 2015年3月11日
 */
public class ClusterUserListResultVO<T> implements Serializable{
    
    /**
     * 
     */
    private static final long serialVersionUID = 1749412888949370339L;

    /**
     * 老师列表大小
     */
    private Long tsize;
    
    /**
     * 老师列表
     */
    private List<T> tlist;
    
    /**
     * 家长列表大小
     */
    private Long psize;
    
    /**
     * 家长列表
     */
    private List<T> plist;

    /**
     * @return the tsize
     */
    public Long getTsize() {
        return tsize;
    }

    /**
     * @param tsize the tsize to set
     */
    public void setTsize(Long tsize) {
        this.tsize = tsize;
    }

    /**
     * @return the psize
     */
    public Long getPsize() {
        return psize;
    }

    /**
     * @return the tlist
     */
    public List<T> getTlist() {
        return tlist;
    }

    /**
     * @param tlist the tlist to set
     */
    public void setTlist(List<T> tlist) {
        this.tlist = tlist;
    }

    /**
     * @return the plist
     */
    public List<T> getPlist() {
        return plist;
    }

    /**
     * @param plist the plist to set
     */
    public void setPlist(List<T> plist) {
        this.plist = plist;
    }

    /**
     * @param psize the psize to set
     */
    public void setPsize(Long psize) {
        this.psize = psize;
    }


}

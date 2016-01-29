/**
 * MsgReadStateForm.java
 */
package com.uxiaoxi.ym.appserver.web.msg.form;

/**
 * @author renhao
 *
 * 2015年5月30日
 */
public class MsgActionForm {

    private Long uid;
    
    private Long mid;
    
    private Long retype;
    
    private Integer selected;

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
     * @return the mid
     */
    public Long getMid() {
        return mid;
    }

    /**
     * @param mid the mid to set
     */
    public void setMid(Long mid) {
        this.mid = mid;
    }

    /**
     * @return the retype
     */
    public Long getRetype() {
        return retype;
    }

    /**
     * @param retype the retype to set
     */
    public void setRetype(Long retype) {
        this.retype = retype;
    }

    /**
     * @return the selected
     */
    public Integer getSelected() {
        return selected;
    }

    /**
     * @param selected the selected to set
     */
    public void setSelected(Integer selected) {
        this.selected = selected;
    }

}

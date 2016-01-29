/**
 * MsgListVO.java
 */
package com.uxiaoxi.ym.appserver.web.msg.vo;

/**
 * @author renhao
 *
 *         2015年3月11日
 */
public class MsgDataPatInfo {

    private Long sid;
    
    private String sname;

    private Integer selected;

    /**
     * @return the sid
     */
    public Long getSid() {
        return sid;
    }

    /**
     * @param sid the sid to set
     */
    public void setSid(Long sid) {
        this.sid = sid;
    }

    /**
     * @return the sname
     */
    public String getSname() {
        return sname;
    }

    /**
     * @param sname the sname to set
     */
    public void setSname(String sname) {
        this.sname = sname;
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

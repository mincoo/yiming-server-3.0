/**
 * MsgOAListVO.java
 */
package com.uxiaoxi.ym.appserver.web.msg.vo;

/**
 * @author renhao
 *
 *         2015年3月11日
 */
public class MsgOAListVO {

    private Long mid;

    private Long oaid;

    private Long uid;

    private Integer type;

    private String url;
    
    private String content;

    private String name;

    private String stime;

    private String face;

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
     * @return the oaid
     */
    public Long getOaid() {
        return oaid;
    }

    /**
     * @param oaid the oaid to set
     */
    public void setOaid(Long oaid) {
        this.oaid = oaid;
    }

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
     * @return the type
     */
    public Integer getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the stime
     */
    public String getStime() {
        return stime;
    }

    /**
     * @param stime the stime to set
     */
    public void setStime(String stime) {
        this.stime = stime;
    }

    /**
     * @return the face
     */
    public String getFace() {
        return face;
    }

    /**
     * @param face the face to set
     */
    public void setFace(String face) {
        this.face = face;
    }


}

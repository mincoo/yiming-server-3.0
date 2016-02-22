/**
 * MsgOAListVO.java
 */
package com.uxiaoxi.ym.appserver.web.msg.vo;

import java.util.List;

/**
 * @author renhao
 *
 *         2015年3月11日
 */
public class MsgOAListVO {

    private Long mid;

    private Long oaid;

    private Integer type;

    private String url;
    
    private String content;

    private String name;
    
    private String wechat;
    
    private String phone;
    
    private String province;
    
    private String city;
    
    private String district;

    private String stime;

    private String face;
    
    private Long ssize;
    
    private List<MsgExplainInfo> slist;

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

    /**
     * @return the wechat
     */
    public String getWechat() {
        return wechat;
    }

    /**
     * @param wechat the wechat to set
     */
    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the province
     */
    public String getProvince() {
        return province;
    }

    /**
     * @param province the province to set
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the district
     */
    public String getDistrict() {
        return district;
    }

    /**
     * @param district the district to set
     */
    public void setDistrict(String district) {
        this.district = district;
    }

    /**
     * @return the ssize
     */
    public Long getSsize() {
        return ssize;
    }

    /**
     * @param ssize the ssize to set
     */
    public void setSsize(Long ssize) {
        this.ssize = ssize;
    }

    /**
     * @return the slist
     */
    public List<MsgExplainInfo> getSlist() {
        return slist;
    }

    /**
     * @param slist the slist to set
     */
    public void setSlist(List<MsgExplainInfo> slist) {
        this.slist = slist;
    }


}

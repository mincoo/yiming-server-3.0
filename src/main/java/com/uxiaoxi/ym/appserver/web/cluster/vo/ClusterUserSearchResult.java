/**
 * ClusterUserSearchResult.java
 */
package com.uxiaoxi.ym.appserver.web.cluster.vo;

import java.io.Serializable;

/**
 * @author renhao
 *
 *         2015年3月10日
 */
public class ClusterUserSearchResult implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 845803572794457257L;

    private Long gid;

    private Long uid;
    
    private Long utype;

    private String sn;

    private String name;

    private String province;

    private String city;

    private String district;

    private String school;

    private String face;

    private Long msgflg;

    /**
     * @return the gid
     */
    public Long getGid() {
        return gid;
    }

    /**
     * @param gid
     *            the gid to set
     */
    public void setGid(Long gid) {
        this.gid = gid;
    }

    /**
     * @return the uid
     */
    public Long getUid() {
        return uid;
    }

    /**
     * @param uid
     *            the uid to set
     */
    public void setUid(Long uid) {
        this.uid = uid;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the school
     */
    public String getSchool() {
        return school;
    }

    /**
     * @param school
     *            the school to set
     */
    public void setSchool(String school) {
        this.school = school;
    }

    /**
     * @return the province
     */
    public String getProvince() {
        return province;
    }

    /**
     * @param province
     *            the province to set
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
     * @param city
     *            the city to set
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
     * @param district
     *            the district to set
     */
    public void setDistrict(String district) {
        this.district = district;
    }

    /**
     * @return the face
     */
    public String getFace() {
        return face;
    }

    /**
     * @param face
     *            the face to set
     */
    public void setFace(String face) {
        this.face = face;
    }

    /**
     * @return the sn
     */
    public String getSn() {
        return sn;
    }

    /**
     * @param sn
     *            the sn to set
     */
    public void setSn(String sn) {
        this.sn = sn;
    }

    /**
     * @return the msgflg
     */
    public Long getMsgflg() {
        return msgflg;
    }

    /**
     * @param msgflg
     *            the msgflg to set
     */
    public void setMsgflg(Long msgflg) {
        this.msgflg = msgflg;
    }

    /**
     * @return the utype
     */
    public Long getUtype() {
        return utype;
    }

    /**
     * @param utype the utype to set
     */
    public void setUtype(Long utype) {
        this.utype = utype;
    }

}

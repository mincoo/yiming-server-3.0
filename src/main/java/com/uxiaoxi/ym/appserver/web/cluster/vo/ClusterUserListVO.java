/**
 * ClusterUserListVO.java
 */
package com.uxiaoxi.ym.appserver.web.cluster.vo;

/**
 * @author renhao
 *
 * 2015年3月11日
 */
public class ClusterUserListVO {
    
    private Long id;
    
    private Long uid;
    
    private Integer type;
    
    private String name;
    
    private String face;
    
    private Integer sex;
    
    private String phone;
    
    private String remark;
    
    private String childname;

    /**
     * @return the remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark the remark to set
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * @return the childname
     */
    public String getChildname() {
        return childname;
    }

    /**
     * @param childname the childname to set
     */
    public void setChildname(String childname) {
        this.childname = childname;
    }

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
     * @return the sex
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * @param sex the sex to set
     */
    public void setSex(Integer sex) {
        this.sex = sex;
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
}

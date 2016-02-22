package com.uxiaoxi.ym.appserver.db.msg.dto;

import java.io.Serializable;
import java.util.Date;

public class OfficialAccounts implements Serializable {

    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column official_accounts.id
     * @mbggenerated  Mon Feb 22 16:30:28 CST 2016
     */
    private Long id;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column official_accounts.name
     * @mbggenerated  Mon Feb 22 16:30:28 CST 2016
     */
    private String name;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column official_accounts.face
     * @mbggenerated  Mon Feb 22 16:30:28 CST 2016
     */
    private String face;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column official_accounts.we_chat
     * @mbggenerated  Mon Feb 22 16:30:28 CST 2016
     */
    private String weChat;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column official_accounts.phone
     * @mbggenerated  Mon Feb 22 16:30:28 CST 2016
     */
    private String phone;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column official_accounts.province
     * @mbggenerated  Mon Feb 22 16:30:28 CST 2016
     */
    private String province;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column official_accounts.city
     * @mbggenerated  Mon Feb 22 16:30:28 CST 2016
     */
    private String city;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column official_accounts.district
     * @mbggenerated  Mon Feb 22 16:30:28 CST 2016
     */
    private String district;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column official_accounts.create_at
     * @mbggenerated  Mon Feb 22 16:30:28 CST 2016
     */
    private Date createAt;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database table official_accounts
     * @mbggenerated  Mon Feb 22 16:30:28 CST 2016
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column official_accounts.id
     * @return  the value of official_accounts.id
     * @mbggenerated  Mon Feb 22 16:30:28 CST 2016
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column official_accounts.id
     * @param id  the value for official_accounts.id
     * @mbggenerated  Mon Feb 22 16:30:28 CST 2016
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column official_accounts.name
     * @return  the value of official_accounts.name
     * @mbggenerated  Mon Feb 22 16:30:28 CST 2016
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column official_accounts.name
     * @param name  the value for official_accounts.name
     * @mbggenerated  Mon Feb 22 16:30:28 CST 2016
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column official_accounts.face
     * @return  the value of official_accounts.face
     * @mbggenerated  Mon Feb 22 16:30:28 CST 2016
     */
    public String getFace() {
        return face;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column official_accounts.face
     * @param face  the value for official_accounts.face
     * @mbggenerated  Mon Feb 22 16:30:28 CST 2016
     */
    public void setFace(String face) {
        this.face = face == null ? null : face.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column official_accounts.we_chat
     * @return  the value of official_accounts.we_chat
     * @mbggenerated  Mon Feb 22 16:30:28 CST 2016
     */
    public String getWeChat() {
        return weChat;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column official_accounts.we_chat
     * @param weChat  the value for official_accounts.we_chat
     * @mbggenerated  Mon Feb 22 16:30:28 CST 2016
     */
    public void setWeChat(String weChat) {
        this.weChat = weChat == null ? null : weChat.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column official_accounts.phone
     * @return  the value of official_accounts.phone
     * @mbggenerated  Mon Feb 22 16:30:28 CST 2016
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column official_accounts.phone
     * @param phone  the value for official_accounts.phone
     * @mbggenerated  Mon Feb 22 16:30:28 CST 2016
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column official_accounts.province
     * @return  the value of official_accounts.province
     * @mbggenerated  Mon Feb 22 16:30:28 CST 2016
     */
    public String getProvince() {
        return province;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column official_accounts.province
     * @param province  the value for official_accounts.province
     * @mbggenerated  Mon Feb 22 16:30:28 CST 2016
     */
    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column official_accounts.city
     * @return  the value of official_accounts.city
     * @mbggenerated  Mon Feb 22 16:30:28 CST 2016
     */
    public String getCity() {
        return city;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column official_accounts.city
     * @param city  the value for official_accounts.city
     * @mbggenerated  Mon Feb 22 16:30:28 CST 2016
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column official_accounts.district
     * @return  the value of official_accounts.district
     * @mbggenerated  Mon Feb 22 16:30:28 CST 2016
     */
    public String getDistrict() {
        return district;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column official_accounts.district
     * @param district  the value for official_accounts.district
     * @mbggenerated  Mon Feb 22 16:30:28 CST 2016
     */
    public void setDistrict(String district) {
        this.district = district == null ? null : district.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column official_accounts.create_at
     * @return  the value of official_accounts.create_at
     * @mbggenerated  Mon Feb 22 16:30:28 CST 2016
     */
    public Date getCreateAt() {
        return createAt;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column official_accounts.create_at
     * @param createAt  the value for official_accounts.create_at
     * @mbggenerated  Mon Feb 22 16:30:28 CST 2016
     */
    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table official_accounts
     * @mbggenerated  Mon Feb 22 16:30:28 CST 2016
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        OfficialAccounts other = (OfficialAccounts) that;
        return (this.getId() == null ? other.getId() == null : this.getId()
                .equals(other.getId()))
                && (this.getName() == null ? other.getName() == null : this
                        .getName().equals(other.getName()))
                && (this.getFace() == null ? other.getFace() == null : this
                        .getFace().equals(other.getFace()))
                && (this.getWeChat() == null ? other.getWeChat() == null : this
                        .getWeChat().equals(other.getWeChat()))
                && (this.getPhone() == null ? other.getPhone() == null : this
                        .getPhone().equals(other.getPhone()))
                && (this.getProvince() == null ? other.getProvince() == null
                        : this.getProvince().equals(other.getProvince()))
                && (this.getCity() == null ? other.getCity() == null : this
                        .getCity().equals(other.getCity()))
                && (this.getDistrict() == null ? other.getDistrict() == null
                        : this.getDistrict().equals(other.getDistrict()))
                && (this.getCreateAt() == null ? other.getCreateAt() == null
                        : this.getCreateAt().equals(other.getCreateAt()));
    }

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table official_accounts
     * @mbggenerated  Mon Feb 22 16:30:28 CST 2016
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result
                + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result
                + ((getFace() == null) ? 0 : getFace().hashCode());
        result = prime * result
                + ((getWeChat() == null) ? 0 : getWeChat().hashCode());
        result = prime * result
                + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result
                + ((getProvince() == null) ? 0 : getProvince().hashCode());
        result = prime * result
                + ((getCity() == null) ? 0 : getCity().hashCode());
        result = prime * result
                + ((getDistrict() == null) ? 0 : getDistrict().hashCode());
        result = prime * result
                + ((getCreateAt() == null) ? 0 : getCreateAt().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table official_accounts
     * @mbggenerated  Mon Feb 22 16:30:28 CST 2016
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", face=").append(face);
        sb.append(", weChat=").append(weChat);
        sb.append(", phone=").append(phone);
        sb.append(", province=").append(province);
        sb.append(", city=").append(city);
        sb.append(", district=").append(district);
        sb.append(", createAt=").append(createAt);
        sb.append("]");
        return sb.toString();
    }
}
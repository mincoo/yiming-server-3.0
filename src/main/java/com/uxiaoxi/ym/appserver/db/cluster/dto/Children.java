package com.uxiaoxi.ym.appserver.db.cluster.dto;

import java.io.Serializable;
import java.util.Date;

public class Children implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column children.id
     *
     * @mbggenerated Wed Jan 27 10:11:11 CST 2016
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column children.name
     *
     * @mbggenerated Wed Jan 27 10:11:11 CST 2016
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column children.acc_id
     *
     * @mbggenerated Wed Jan 27 10:11:11 CST 2016
     */
    private Long accId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column children.clu_id
     *
     * @mbggenerated Wed Jan 27 10:11:11 CST 2016
     */
    private Long cluId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column children.create_dt
     *
     * @mbggenerated Wed Jan 27 10:11:11 CST 2016
     */
    private Date createDt;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table children
     *
     * @mbggenerated Wed Jan 27 10:11:11 CST 2016
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column children.id
     *
     * @return the value of children.id
     *
     * @mbggenerated Wed Jan 27 10:11:11 CST 2016
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column children.id
     *
     * @param id the value for children.id
     *
     * @mbggenerated Wed Jan 27 10:11:11 CST 2016
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column children.name
     *
     * @return the value of children.name
     *
     * @mbggenerated Wed Jan 27 10:11:11 CST 2016
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column children.name
     *
     * @param name the value for children.name
     *
     * @mbggenerated Wed Jan 27 10:11:11 CST 2016
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column children.acc_id
     *
     * @return the value of children.acc_id
     *
     * @mbggenerated Wed Jan 27 10:11:11 CST 2016
     */
    public Long getAccId() {
        return accId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column children.acc_id
     *
     * @param accId the value for children.acc_id
     *
     * @mbggenerated Wed Jan 27 10:11:11 CST 2016
     */
    public void setAccId(Long accId) {
        this.accId = accId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column children.clu_id
     *
     * @return the value of children.clu_id
     *
     * @mbggenerated Wed Jan 27 10:11:11 CST 2016
     */
    public Long getCluId() {
        return cluId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column children.clu_id
     *
     * @param cluId the value for children.clu_id
     *
     * @mbggenerated Wed Jan 27 10:11:11 CST 2016
     */
    public void setCluId(Long cluId) {
        this.cluId = cluId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column children.create_dt
     *
     * @return the value of children.create_dt
     *
     * @mbggenerated Wed Jan 27 10:11:11 CST 2016
     */
    public Date getCreateDt() {
        return createDt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column children.create_dt
     *
     * @param createDt the value for children.create_dt
     *
     * @mbggenerated Wed Jan 27 10:11:11 CST 2016
     */
    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table children
     *
     * @mbggenerated Wed Jan 27 10:11:11 CST 2016
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
        Children other = (Children) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getAccId() == null ? other.getAccId() == null : this.getAccId().equals(other.getAccId()))
            && (this.getCluId() == null ? other.getCluId() == null : this.getCluId().equals(other.getCluId()))
            && (this.getCreateDt() == null ? other.getCreateDt() == null : this.getCreateDt().equals(other.getCreateDt()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table children
     *
     * @mbggenerated Wed Jan 27 10:11:11 CST 2016
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getAccId() == null) ? 0 : getAccId().hashCode());
        result = prime * result + ((getCluId() == null) ? 0 : getCluId().hashCode());
        result = prime * result + ((getCreateDt() == null) ? 0 : getCreateDt().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table children
     *
     * @mbggenerated Wed Jan 27 10:11:11 CST 2016
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", accId=").append(accId);
        sb.append(", cluId=").append(cluId);
        sb.append(", createDt=").append(createDt);
        sb.append("]");
        return sb.toString();
    }
}
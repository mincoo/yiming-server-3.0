package com.uxiaoxi.ym.appserver.db.msg.dto;

import java.io.Serializable;
import java.util.Date;

public class OfficialAccUser implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column official_acc_user.id
     *
     * @mbggenerated Wed Feb 17 19:19:26 CST 2016
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column official_acc_user.acc_id
     *
     * @mbggenerated Wed Feb 17 19:19:26 CST 2016
     */
    private Long accId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column official_acc_user.off_acc_id
     *
     * @mbggenerated Wed Feb 17 19:19:26 CST 2016
     */
    private Long offAccId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column official_acc_user.create_at
     *
     * @mbggenerated Wed Feb 17 19:19:26 CST 2016
     */
    private Date createAt;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table official_acc_user
     *
     * @mbggenerated Wed Feb 17 19:19:26 CST 2016
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column official_acc_user.id
     *
     * @return the value of official_acc_user.id
     *
     * @mbggenerated Wed Feb 17 19:19:26 CST 2016
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column official_acc_user.id
     *
     * @param id the value for official_acc_user.id
     *
     * @mbggenerated Wed Feb 17 19:19:26 CST 2016
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column official_acc_user.acc_id
     *
     * @return the value of official_acc_user.acc_id
     *
     * @mbggenerated Wed Feb 17 19:19:26 CST 2016
     */
    public Long getAccId() {
        return accId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column official_acc_user.acc_id
     *
     * @param accId the value for official_acc_user.acc_id
     *
     * @mbggenerated Wed Feb 17 19:19:26 CST 2016
     */
    public void setAccId(Long accId) {
        this.accId = accId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column official_acc_user.off_acc_id
     *
     * @return the value of official_acc_user.off_acc_id
     *
     * @mbggenerated Wed Feb 17 19:19:26 CST 2016
     */
    public Long getOffAccId() {
        return offAccId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column official_acc_user.off_acc_id
     *
     * @param offAccId the value for official_acc_user.off_acc_id
     *
     * @mbggenerated Wed Feb 17 19:19:26 CST 2016
     */
    public void setOffAccId(Long offAccId) {
        this.offAccId = offAccId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column official_acc_user.create_at
     *
     * @return the value of official_acc_user.create_at
     *
     * @mbggenerated Wed Feb 17 19:19:26 CST 2016
     */
    public Date getCreateAt() {
        return createAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column official_acc_user.create_at
     *
     * @param createAt the value for official_acc_user.create_at
     *
     * @mbggenerated Wed Feb 17 19:19:26 CST 2016
     */
    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table official_acc_user
     *
     * @mbggenerated Wed Feb 17 19:19:26 CST 2016
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
        OfficialAccUser other = (OfficialAccUser) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAccId() == null ? other.getAccId() == null : this.getAccId().equals(other.getAccId()))
            && (this.getOffAccId() == null ? other.getOffAccId() == null : this.getOffAccId().equals(other.getOffAccId()))
            && (this.getCreateAt() == null ? other.getCreateAt() == null : this.getCreateAt().equals(other.getCreateAt()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table official_acc_user
     *
     * @mbggenerated Wed Feb 17 19:19:26 CST 2016
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAccId() == null) ? 0 : getAccId().hashCode());
        result = prime * result + ((getOffAccId() == null) ? 0 : getOffAccId().hashCode());
        result = prime * result + ((getCreateAt() == null) ? 0 : getCreateAt().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table official_acc_user
     *
     * @mbggenerated Wed Feb 17 19:19:26 CST 2016
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", accId=").append(accId);
        sb.append(", offAccId=").append(offAccId);
        sb.append(", createAt=").append(createAt);
        sb.append("]");
        return sb.toString();
    }
}
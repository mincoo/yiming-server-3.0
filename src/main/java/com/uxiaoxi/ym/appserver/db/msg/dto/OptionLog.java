package com.uxiaoxi.ym.appserver.db.msg.dto;

import java.io.Serializable;
import java.util.Date;

public class OptionLog implements Serializable {
    private Long id;

    private String optionType;

    private Long dataId;

    private Date createAt;

    private String dataAfter;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOptionType() {
        return optionType;
    }

    public void setOptionType(String optionType) {
        this.optionType = optionType == null ? null : optionType.trim();
    }

    public Long getDataId() {
        return dataId;
    }

    public void setDataId(Long dataId) {
        this.dataId = dataId;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public String getDataAfter() {
        return dataAfter;
    }

    public void setDataAfter(String dataAfter) {
        this.dataAfter = dataAfter == null ? null : dataAfter.trim();
    }

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
        OptionLog other = (OptionLog) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOptionType() == null ? other.getOptionType() == null : this.getOptionType().equals(other.getOptionType()))
            && (this.getDataId() == null ? other.getDataId() == null : this.getDataId().equals(other.getDataId()))
            && (this.getCreateAt() == null ? other.getCreateAt() == null : this.getCreateAt().equals(other.getCreateAt()))
            && (this.getDataAfter() == null ? other.getDataAfter() == null : this.getDataAfter().equals(other.getDataAfter()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOptionType() == null) ? 0 : getOptionType().hashCode());
        result = prime * result + ((getDataId() == null) ? 0 : getDataId().hashCode());
        result = prime * result + ((getCreateAt() == null) ? 0 : getCreateAt().hashCode());
        result = prime * result + ((getDataAfter() == null) ? 0 : getDataAfter().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", optionType=").append(optionType);
        sb.append(", dataId=").append(dataId);
        sb.append(", createAt=").append(createAt);
        sb.append(", dataAfter=").append(dataAfter);
        sb.append("]");
        return sb.toString();
    }
}
package com.uxiaoxi.ym.appserver.db.group.dto;

import java.util.Date;

public class GroupCluster {
    private Long id;

    private Long groupId;

    private Long cluId;

    private String cluName;

    private Date createDt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Long getCluId() {
        return cluId;
    }

    public void setCluId(Long cluId) {
        this.cluId = cluId;
    }

    public String getCluName() {
        return cluName;
    }

    public void setCluName(String cluName) {
        this.cluName = cluName == null ? null : cluName.trim();
    }

    public Date getCreateDt() {
        return createDt;
    }

    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }
}
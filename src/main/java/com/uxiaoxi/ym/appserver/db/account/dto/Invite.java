package com.uxiaoxi.ym.appserver.db.account.dto;

import java.util.Date;

public class Invite {
    private Long id;

    private Long accId;

    private Long cluId;

    private String invitedMobile;

    private Date createDt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccId() {
        return accId;
    }

    public void setAccId(Long accId) {
        this.accId = accId;
    }

    public Long getCluId() {
        return cluId;
    }

    public void setCluId(Long cluId) {
        this.cluId = cluId;
    }

    public String getInvitedMobile() {
        return invitedMobile;
    }

    public void setInvitedMobile(String invitedMobile) {
        this.invitedMobile = invitedMobile == null ? null : invitedMobile.trim();
    }

    public Date getCreateDt() {
        return createDt;
    }

    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }
}
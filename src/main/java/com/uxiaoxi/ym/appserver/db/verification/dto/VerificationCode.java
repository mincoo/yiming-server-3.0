package com.uxiaoxi.ym.appserver.db.verification.dto;

import java.util.Date;

public class VerificationCode {
    private Long id;

    private Integer vCode;

    private String vContent;

    private Integer vType;

    private Date createDt;

    private Boolean used;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getvCode() {
        return vCode;
    }

    public void setvCode(Integer vCode) {
        this.vCode = vCode;
    }

    public String getvContent() {
        return vContent;
    }

    public void setvContent(String vContent) {
        this.vContent = vContent == null ? null : vContent.trim();
    }

    public Integer getvType() {
        return vType;
    }

    public void setvType(Integer vType) {
        this.vType = vType;
    }

    public Date getCreateDt() {
        return createDt;
    }

    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }

    public Boolean getUsed() {
        return used;
    }

    public void setUsed(Boolean used) {
        this.used = used;
    }
}
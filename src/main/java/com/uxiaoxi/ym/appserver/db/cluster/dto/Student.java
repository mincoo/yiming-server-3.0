package com.uxiaoxi.ym.appserver.db.cluster.dto;

import java.util.Date;

public class Student {
    private Long id;

    private String num;

    private String name;

    private String face;

    private Long cluId;

    private Date createDt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num == null ? null : num.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face == null ? null : face.trim();
    }

    public Long getCluId() {
        return cluId;
    }

    public void setCluId(Long cluId) {
        this.cluId = cluId;
    }

    public Date getCreateDt() {
        return createDt;
    }

    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }
}
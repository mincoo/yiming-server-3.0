package com.uxiaoxi.ym.appserver.db.account.dto;

public class AccType {
    private Integer type;

    private String title;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }
}
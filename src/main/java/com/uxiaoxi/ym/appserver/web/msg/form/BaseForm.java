package com.uxiaoxi.ym.appserver.web.msg.form;

public class BaseForm {

    
    /**
     * 微信的openid
     */
    private String toUser;
    
    /**
     * url
     */
    private String url;

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    
    
}

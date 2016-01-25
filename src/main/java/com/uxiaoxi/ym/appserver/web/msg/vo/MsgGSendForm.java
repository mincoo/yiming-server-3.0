/**
 * MsgGSendForm.java
 */
package com.uxiaoxi.ym.appserver.web.msg.vo;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @author renhao
 *
 * 2015年3月11日
 */
// TODO 对象结构更改，通过继承方式提取公共部分
public class MsgGSendForm {
    
    @NotNull
    private Long uid;
    
    @NotNull
    private Long gid;
    
//    @NotBlank
    private String title;
    
    @NotBlank
    private String content;
    
    private String url;
    
    private Integer msgType;
    
    public MsgGSendForm(){
        this.msgType = MsgTypeEnum.TXT.getCode();
        this.url = "";
    }

    /**
     * @return the uid
     */
    public Long getUid() {
        return uid;
    }

    /**
     * @param uid the uid to set
     */
    public void setUid(Long uid) {
        this.uid = uid;
    }

    /**
     * @return the gid
     */
    public Long getGid() {
        return gid;
    }

    /**
     * @param gid the gid to set
     */
    public void setGid(Long gid) {
        this.gid = gid;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return the msgType
     */
    public Integer getMsgType() {
        return msgType;
    }

    /**
     * @param msgType the msgType to set
     */
    public void setMsgType(Integer msgType) {
        this.msgType = msgType;
    }

}

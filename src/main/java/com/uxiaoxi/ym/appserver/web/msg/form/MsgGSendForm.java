/**
 * MsgGSendForm.java
 */
package com.uxiaoxi.ym.appserver.web.msg.form;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.uxiaoxi.ym.appserver.web.msg.vo.MsgTypeEnum;

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
    
    private Integer retype;
    
    private String select1;
    
    private String select2;
    
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

    /**
     * @return the retype
     */
    public Integer getRetype() {
        return retype;
    }

    /**
     * @param retype the retype to set
     */
    public void setRetype(Integer retype) {
        this.retype = retype;
    }

    /**
     * @return the select1
     */
    public String getSelect1() {
        return select1;
    }

    /**
     * @param select1 the select1 to set
     */
    public void setSelect1(String select1) {
        this.select1 = select1;
    }

    /**
     * @return the select2
     */
    public String getSelect2() {
        return select2;
    }

    /**
     * @param select2 the select2 to set
     */
    public void setSelect2(String select2) {
        this.select2 = select2;
    }

}

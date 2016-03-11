package com.uxiaoxi.ym.appserver.web.msg.form;


/**
 * 
 * 班级通知
 * 
 * @author renhao
 *
 */
public class ClassNoticeForm extends BaseForm {

    /**
     * 发送者
     */
    private String name;
    
    /**
     * 发送时间
     */
    private String stime;
    
    /**
     * 标题
     */
    private String title;
    
    /**
     * 内容
     */
    private String content;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStime() {
        return stime;
    }

    public void setStime(String stime) {
        this.stime = stime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
}

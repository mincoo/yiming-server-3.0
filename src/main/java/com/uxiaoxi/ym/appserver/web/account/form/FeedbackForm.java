/**
 * FeedbackForm.java
 */
package com.uxiaoxi.ym.appserver.web.account.form;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @author renh
 *
 * 2013-4-9
 */
public class FeedbackForm {

    @NotNull
    private Long uid; 
    
    @NotBlank
    private String content;

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


}

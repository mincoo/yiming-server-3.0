/**
 * OnsDTO.java
 */
package com.uxiaoxi.ym.aliyun.bean;

import java.util.Date;

import com.alibaba.fastjson.JSON;

/**
 * @author renhao
 *
 *         2015年3月24日
 */
public class OnsDTO {

    /**
     * 消息内容
     */
    String form;

    /**
     * 发送ons的时间
     */
    Date sendTime;

    
    public OnsDTO(){
        this.sendTime = new Date();
    }

    public OnsDTO(Object form) {

        this.form = JSON.toJSONString(form);
        this.sendTime = new Date();
    }

    /**
     * @param sendTime
     *            the sendTime to set
     */
    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }


    /**
     * @return the sendTime
     */
    public Date getSendTime() {
        return sendTime;
    }

    /**
     * @return the form
     */
    public String getForm() {
        return form;
    }

    /**
     * @param form
     *            the form to set
     */
    public void setForm(String form) {
        this.form = form;
    }

}

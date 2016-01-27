/**
 * OnsDTO.java
 */
package com.uxiaoxi.ym.aliyun.bean;

import java.util.Date;

import com.alibaba.fastjson.JSON;
import com.uxiaoxi.ym.appserver.web.msg.form.MsgSendForm;
import com.uxiaoxi.ym.appserver.web.msg.vo.MsgSendTypeEnum;

/**
 * @author renhao
 *
 *         2015年3月24日
 */
public class MsgOnsDTO {

    /**
     * 消息内容
     */
    String form;

    /**
     * 时间
     */
    Date sendTime;

    /**
     * 发送类型
     */
    MsgSendTypeEnum sendType;
    
    public MsgOnsDTO(){
        
    }

    public MsgOnsDTO(Object form) {

        this.form = JSON.toJSONString(form);
        this.sendTime = new Date();
        if(form instanceof MsgSendForm) {
            this.sendType = MsgSendTypeEnum.SINGLE;
        } else {
            this.sendType = MsgSendTypeEnum.GROUP;
        }
    }

    /**
     * @param sendTime
     *            the sendTime to set
     */
    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    /**
     * @return the sendType
     */
    public MsgSendTypeEnum getSendType() {
        return sendType;
    }

    /**
     * @param sendType
     *            the sendType to set
     */
    public void setSendType(MsgSendTypeEnum sendType) {
        this.sendType = sendType;
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

/**
 * MsgListener.java
 */
package com.uxiaoxi.ym.appserver.biz.msg.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.aliyun.openservices.ons.api.Action;
import com.aliyun.openservices.ons.api.ConsumeContext;
import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.MessageListener;
import com.uxiaoxi.ym.aliyun.bean.MsgOnsDTO;
import com.uxiaoxi.ym.appserver.biz.msg.IMsgService;
import com.uxiaoxi.ym.appserver.db.msg.dao.IMsgDao;
import com.uxiaoxi.ym.appserver.web.msg.form.MsgGSendForm;
import com.uxiaoxi.ym.appserver.web.msg.form.MsgSendForm;
import com.uxiaoxi.ym.appserver.web.msg.vo.MsgSendTypeEnum;

/**
 * @author renhao
 *
 * 2015年3月26日
 */
@Service("ym_msgListener")
public class MsgListener implements MessageListener{

    private Logger LOG = LoggerFactory.getLogger(MsgListener.class);
    
    @Autowired
    private IMsgDao msgDao;
    
    @Autowired
    private IMsgService msgService;

    @Override
    @Transactional
    public Action consume(Message message, ConsumeContext context) {

        LOG.debug(" message body = " + new String(message.getBody()));
        
        // 转为 对象
        MsgOnsDTO od = JSON.parseObject(message.getBody(), MsgOnsDTO.class);
        
//        if(od.getSendType().equals(MsgSendTypeEnum.GROUP)) {
//            MsgGSendForm form = JSON.parseObject(od.getForm(),MsgGSendForm.class);
//            msgService.gsendMsg(form);
//        } 
//        else {
//            MsgSendForm form = JSON.parseObject(od.getForm(),MsgSendForm.class);
//            msgService.sendMsg((MsgSendForm)form);
//        }
        MsgGSendForm form = JSON.parseObject(od.getForm(),MsgGSendForm.class);
        msgService.gsendMsg(form);

        return Action.CommitMessage;
    }

}

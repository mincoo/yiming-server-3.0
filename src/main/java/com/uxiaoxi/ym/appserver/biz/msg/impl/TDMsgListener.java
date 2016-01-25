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
import com.uxiaoxi.ym.aliyun.bean.TDMsgOnsDTO;
import com.uxiaoxi.ym.appserver.biz.msg.IMsgService;

/**
 * @author renhao
 *
 * 2015年3月26日
 */
@Service("td_msgListener")
public class TDMsgListener implements MessageListener{

    private Logger LOG = LoggerFactory.getLogger(TDMsgListener.class);
    
    @Autowired
    private IMsgService msgService;

    @Override
    @Transactional
    public Action consume(Message message, ConsumeContext context) {
        
        LOG.debug(" message body = " + new String(message.getBody()));
        
        // 转为 对象
        TDMsgOnsDTO od = JSON.parseObject(message.getBody(), TDMsgOnsDTO.class);
        
        msgService.sendMsg(od);

        return Action.CommitMessage;
    }

}

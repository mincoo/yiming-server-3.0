/**
 * Producer.java
 */
package com.uxiaoxi.ym.aliyun.producer;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.ONSFactory;
import com.aliyun.openservices.ons.api.Producer;
import com.aliyun.openservices.ons.api.PropertyKeyConst;
import com.aliyun.openservices.ons.api.SendResult;
import com.uxiaoxi.ym.aliyun.bean.AliyunConfig;
import com.uxiaoxi.ym.aliyun.bean.MsgOnsDTO;
import com.uxiaoxi.ym.appserver.web.msg.form.MsgGSendForm;

/**
 * @author renhao
 *
 * 2015年3月24日
 */
public class MsgProducer {
 // log
    private Logger LOG = LoggerFactory.getLogger(MsgProducer.class);
    
    private static Producer producer ;
    
    @Autowired
    private AliyunConfig aliyunConfig;
    
    public void init(){
        Properties properties = new Properties();
        properties.put(PropertyKeyConst.ProducerId, aliyunConfig.getProducerId());
        properties.put(PropertyKeyConst.AccessKey,aliyunConfig.getAccessKey());
        properties.put(PropertyKeyConst.SecretKey, aliyunConfig.getSecretKey());
        
        producer = ONSFactory.createProducer(properties);
        
        // 在发送消息前，必须调用start方法来启动Producer，只需调用一次即可。
        producer.start();
    }
    
    public SendResult sendMsg(MsgGSendForm form) {
        
        MsgOnsDTO od = new MsgOnsDTO(form);
        // 消息体
        String jsonString = JSON.toJSONString(od);
        // 标签
        String tag = "g"+form.getGid();
        // 消息对象
        Message msg;
        try {
            msg = new Message(aliyunConfig.getTopic(),tag,jsonString.getBytes("UTF-8"));
            // 构造一个msgkey
            StringBuilder msgkey = new StringBuilder();
            msgkey.append("u");
            msgkey.append(form.getUid());
            msgkey.append("t");
            msgkey.append(System.currentTimeMillis());
            LOG.debug("msgkye="+msgkey.toString()+"&msg="+jsonString);
            
            msg.setKey(msgkey.toString());
            
            if(producer == null) {
                init();
           }
           
           // 发送消息，只要不抛异常就是成功
           SendResult sendResult = producer.send(msg);
           LOG.debug("msgId=" + sendResult.getMessageId());
           
           return sendResult;
           
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void shutdown() {
        if(producer != null) {
            producer.shutdown();
        }
    }
}

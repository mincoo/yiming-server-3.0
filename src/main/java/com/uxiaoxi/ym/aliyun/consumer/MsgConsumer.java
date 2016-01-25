/**
 * MsgConsumer.java
 */
package com.uxiaoxi.ym.aliyun.consumer;

import java.util.Properties;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import com.aliyun.openservices.ons.api.Consumer;
import com.aliyun.openservices.ons.api.MessageListener;
import com.aliyun.openservices.ons.api.ONSFactory;
import com.aliyun.openservices.ons.api.PropertyKeyConst;
import com.uxiaoxi.ym.aliyun.bean.AliyunConfig;

/**
 * @author renhao
 *
 * 2015年3月24日
 */
public class MsgConsumer {
    
    @Resource(name="ym_msgListener")
    MessageListener listener;
    
    @Autowired
    private AliyunConfig aliyunConfig;
    
    private static Consumer consumer;

    public void init() {
        Properties properties = new Properties();
        properties.put(PropertyKeyConst.ConsumerId, aliyunConfig.getConsumerId());
        properties.put(PropertyKeyConst.AccessKey, aliyunConfig.getAccessKey());
        properties.put(PropertyKeyConst.SecretKey, aliyunConfig.getSecretKey());
        
        consumer = ONSFactory.createConsumer(properties);
        consumer.subscribe(aliyunConfig.getTopic(), "*", listener);
        consumer.start();
    }
    
    public void shutDown() {
        if(consumer != null) {
            consumer.shutdown();
        }
    }
}

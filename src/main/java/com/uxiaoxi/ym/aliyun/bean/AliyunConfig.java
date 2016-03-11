/**
 * AliyunConst.java
 */
package com.uxiaoxi.ym.aliyun.bean;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author renhao
 *
 * 2015年4月9日
 */
public class AliyunConfig {
    
    @Value("${topic}")
    private String Topic;
    
    @Value("${producer_id}")
    private String ProducerId;
    
    @Value("${consumer_id}")
    private String ConsumerId;
    
    @Value("${access_key}")
    private String AccessKey;
    
    @Value("${secret_key}")
    private String SecretKey;
    
    @Value("${td_topic}")
    private String TDTopic;
    
    @Value("${td_consumer_id}")
    private String TDConsumerId;
    
    @Value("${open_topic}")
    private String OPENTopic;
    
    @Value("${open_consumer_id}")
    private String OPENConsumerId;
    

    /**
     * @return the topic
     */
    public String getTopic() {
        return Topic;
    }

    /**
     * @param topic the topic to set
     */
    public void setTopic(String topic) {
        Topic = topic;
    }

    /**
     * @return the producerId
     */
    public String getProducerId() {
        return ProducerId;
    }

    /**
     * @param producerId the producerId to set
     */
    public void setProducerId(String producerId) {
        ProducerId = producerId;
    }

    /**
     * @return the consumerId
     */
    public String getConsumerId() {
        return ConsumerId;
    }

    /**
     * @param consumerId the consumerId to set
     */
    public void setConsumerId(String consumerId) {
        ConsumerId = consumerId;
    }

    /**
     * @return the accessKey
     */
    public String getAccessKey() {
        return AccessKey;
    }

    /**
     * @param accessKey the accessKey to set
     */
    public void setAccessKey(String accessKey) {
        AccessKey = accessKey;
    }

    /**
     * @return the secretKey
     */
    public String getSecretKey() {
        return SecretKey;
    }

    /**
     * @param secretKey the secretKey to set
     */
    public void setSecretKey(String secretKey) {
        SecretKey = secretKey;
    }

    /**
     * @return the tDTopic
     */
    public String getTDTopic() {
        return TDTopic;
    }

    /**
     * @param tDTopic the tDTopic to set
     */
    public void setTDTopic(String tDTopic) {
        TDTopic = tDTopic;
    }

    /**
     * @return the tDConsumerId
     */
    public String getTDConsumerId() {
        return TDConsumerId;
    }

    /**
     * @param tDConsumerId the tDConsumerId to set
     */
    public void setTDConsumerId(String tDConsumerId) {
        TDConsumerId = tDConsumerId;
    }

    /**
     * @return the oPENTopic
     */
    public String getOPENTopic() {
        return OPENTopic;
    }

    /**
     * @param oPENTopic the oPENTopic to set
     */
    public void setOPENTopic(String oPENTopic) {
        OPENTopic = oPENTopic;
    }

    /**
     * @return the oPENConsumerId
     */
    public String getOPENConsumerId() {
        return OPENConsumerId;
    }

    /**
     * @param oPENConsumerId the oPENConsumerId to set
     */
    public void setOPENConsumerId(String oPENConsumerId) {
        OPENConsumerId = oPENConsumerId;
    }
    
    
}

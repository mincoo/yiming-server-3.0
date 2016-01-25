/**
 * JpushUtil.java
 */
package com.uxiaoxi.ym.jpush;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.jpush.api.JPushClient;
import cn.jpush.api.common.resp.APIConnectionException;
import cn.jpush.api.common.resp.APIRequestException;
import cn.jpush.api.common.resp.DefaultResult;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;

/**
 * @author renhao
 *
 * 2015年3月12日
 */
public class JpushUtil {
    protected static final Logger LOG = LoggerFactory.getLogger(JpushUtil.class);
    
    private static final String appKey ="fc37eeb6f689d1e95c4f328f";
    private static final String masterSecret = "38a585334cfc487ebcba01de";
    private static JPushClient jpushClient = new JPushClient(masterSecret, appKey);
    
    
//    private static final String mp_version = "com.uxiaoxi.mp_2.0.1";
    // private static final String mp_version = "com.uxiaoxi.mp_1.0.2";
    
    
    
    
//    private static final String appKey_mp ="7802a1c787d79798c193d4ed";
//    private static final String masterSecret_mp = "e84b55cf2d3a2a13d6de3872";
//    private static JPushClient jpushClient_mp = new JPushClient(masterSecret_mp, appKey_mp);

    
    public static void SendPush(PushParam param, String version) {
        
        PushPayload payload = null;
        if(param.getTypeEnum().equals(PushTypeEnum.TAG)) {
            payload = buildTagPushObject(param);
        } else if(param.getTypeEnum().equals(PushTypeEnum.ALIAS)){
            payload = buildAliasPushObject(param);
        }
        
        try {
//            PushResult result = jc.sendPush(payload);
            PushResult result = jpushClient.sendPush(payload);
            LOG.info("Got result - " + result );
            
        } catch (APIConnectionException e) {
            LOG.error("Connection error. Should retry later. ", e);
            
        } catch (APIRequestException e) {
            LOG.error("Error response from JPush server. Should review and fix it. ", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Code: " + e.getErrorCode());
            LOG.info("Error Message: " + e.getErrorMessage());
            LOG.info("Msg ID: " + e.getMsgId());
        }
        
        
//        try {
//          PushResult result_mp = jpushClient_mp.sendPush(payload);
//          
//          
//          LOG.info("Got result_mp - " + result_mp);
//          
//      } catch (APIConnectionException e) {
//          LOG.error("Connection error. Should retry later. ", e);
//          
//      } catch (APIRequestException e) {
//          LOG.error("Error response from JPush server. Should review and fix it. ", e);
//          LOG.info("HTTP Status: " + e.getStatus());
//          LOG.info("Error Code: " + e.getErrorCode());
//          LOG.info("Error Message: " + e.getErrorMessage());
//          LOG.info("Msg ID: " + e.getMsgId());
//      }
    }
    
    
public static void gSendPush(PushParam param) {
        
        
        PushPayload payload = null;
        payload = buildTagPushObject(param);
        
        try {
            PushResult result = jpushClient.sendPush(payload);
            
            LOG.info("Got result - " + result );
            
        } catch (APIConnectionException e) {
            LOG.error("Connection error. Should retry later. ", e);
            
        } catch (APIRequestException e) {
            LOG.error("Error response from JPush server. Should review and fix it. ", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Code: " + e.getErrorCode());
            LOG.info("Error Message: " + e.getErrorMessage());
            LOG.info("Msg ID: " + e.getMsgId());
        }
        
        
        
//        try {
//            PushResult result_mp = jpushClient_mp.sendPush(payload);
//            LOG.info("Got result_mp - " + result_mp);
//            
//        } catch (APIConnectionException e) {
//            LOG.error("Connection error. Should retry later. ", e);
//            
//        } catch (APIRequestException e) {
//            LOG.error("Error response from JPush server. Should review and fix it. ", e);
//            LOG.info("HTTP Status: " + e.getStatus());
//            LOG.info("Error Code: " + e.getErrorCode());
//            LOG.info("Error Message: " + e.getErrorMessage());
//            LOG.info("Msg ID: " + e.getMsgId());
//        }
        
        
    }


    private static PushPayload buildTagPushObject(PushParam param) {
        return PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.tag(param.getTag()))
                .setNotification(Notification.newBuilder()
                        .setAlert(param.getContent())
                        .addPlatformNotification(AndroidNotification.newBuilder()
                                .addExtra("mid", param.getMid())
                                .addExtra("type", param.getType())
                                .addExtra("url", param.getUrl())
                                .build())
                        .addPlatformNotification(IosNotification.newBuilder()
                                .addExtra("mid", param.getMid())
                                .addExtra("type", param.getType())
                                .addExtra("url", param.getUrl())
                                .setSound("default")
                                .build())
//                        .addPlatformNotification(WinphoneNotification.newBuilder()
//                                .addExtra("mid", param.getMid())
//                                .addExtra("type", param.getType())
//                                .addExtra("url", param.getUrl())
//                                .build()
//                                )
                        .build())
                .setOptions(Options.newBuilder()
                        .setApnsProduction(true)
                        .build())
                .build();
    }
    
    private static PushPayload buildAliasPushObject(PushParam param) {
        return PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.alias(param.getAlias()))
                .setNotification(Notification.newBuilder()
                        .setAlert(param.getContent())
                        .addPlatformNotification(AndroidNotification.newBuilder()
                                .addExtra("mid", param.getMid())
                                .addExtra("type", param.getType())
                                .addExtra("url", param.getUrl())
                                .build())
                        .addPlatformNotification(IosNotification.newBuilder()
                                .addExtra("mid", param.getMid())
                                .addExtra("type", param.getType())
                                .addExtra("url", param.getUrl())
                                .setSound("default")
                                .build())
//                        .addPlatformNotification(WinphoneNotification.newBuilder()
//                                .addExtra("mid", param.getMid())
//                                .addExtra("type", param.getType())
//                                .addExtra("url", param.getUrl())
//                                .build()
//                                )
                        .build())
                .setOptions(Options.newBuilder()
                            .setApnsProduction(true)
                            .build())
                .build();
    }
    
    public static void updateDeviceTagAlias(String registrationId, String alias,  
            Set<String> tagsToAdd, Set<String> tagsToRemove, String version) {
    	
        try {
            
            DefaultResult result = jpushClient.updateDeviceTagAlias(registrationId, alias, tagsToAdd, tagsToRemove);
            
            LOG.info(result.toString() );
            
        } catch (APIConnectionException e) {
            LOG.error("Connection error. Should retry later. ", e);
            
        } catch (APIRequestException e) {
            LOG.error("Error response from JPush server. Should review and fix it. ", e);
            LOG.error("HTTP Status: " + e.getStatus());
            LOG.error("Error Code: " + e.getErrorCode());
            LOG.error("Error Message: " + e.getErrorMessage());
        }
        
        
//        try {
//            
//            DefaultResult result_mp = jpushClient_mp.updateDeviceTagAlias(registrationId, alias, tagsToAdd, tagsToRemove);
//            
//            LOG.info(result_mp.toString());
//            
//        } catch (APIConnectionException e) {
//            LOG.error("Connection error. Should retry later. ", e);
//            
//        } catch (APIRequestException e) {
//            LOG.error("Error response from JPush server. Should review and fix it. ", e);
//            LOG.error("HTTP Status: " + e.getStatus());
//            LOG.error("Error Code: " + e.getErrorCode());
//            LOG.error("Error Message: " + e.getErrorMessage());
//        }
    }
    
    public static void updateDeviceTagAlias(String registrationId, boolean clearAlias,  
            boolean clearTag) {
        try {
            
            DefaultResult result = jpushClient.updateDeviceTagAlias(registrationId, clearAlias, clearTag);
            
            LOG.info(result.toString());
            
        } catch (APIConnectionException e) {
            LOG.error("Connection error. Should retry later. ", e);
            
        } catch (APIRequestException e) {
            LOG.error("Error response from JPush server. Should review and fix it. ", e);
            LOG.error("HTTP Status: " + e.getStatus());
            LOG.error("Error Code: " + e.getErrorCode());
            LOG.error("Error Message: " + e.getErrorMessage());
        }
        
//        try {
//            
//            DefaultResult result_mp = jpushClient_mp.updateDeviceTagAlias(registrationId, clearAlias, clearTag);
//            
//            LOG.info(result_mp.toString());
//            
//        } catch (APIConnectionException e) {
//            LOG.error("Connection error. Should retry later. ", e);
//            
//        } catch (APIRequestException e) {
//            LOG.error("Error response from JPush server. Should review and fix it. ", e);
//            LOG.error("HTTP Status: " + e.getStatus());
//            LOG.error("Error Code: " + e.getErrorCode());
//            LOG.error("Error Message: " + e.getErrorMessage());
//        }
    }
    
//    private static JPushClient getJPushClientInstance(String version){
//        JPushClient jc = null;
//        
//        if(StringUtils.isBlank(version)) {
//            version = "";
//        }
//        
//        switch(version) {
//            case mp_version :
//                jc = jpushClient_mp;
//                break;
//            default :
//                jc =  jpushClient;
//                break;
//        }
//        
//        return jc;
//    }
}

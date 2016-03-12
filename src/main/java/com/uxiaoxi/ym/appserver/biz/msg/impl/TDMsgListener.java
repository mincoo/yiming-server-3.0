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
import com.uxiaoxi.ym.aliyun.producer.OpenMsgProducer;
import com.uxiaoxi.ym.appserver.biz.msg.IMsgService;
import com.uxiaoxi.ym.appserver.db.account.dao.IAccountDao;
import com.uxiaoxi.ym.appserver.db.account.dto.Account;
import com.uxiaoxi.ym.appserver.web.msg.form.SchoolCheckForm;

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
    
    @Autowired
    private OpenMsgProducer producer;
    
    @Autowired
    private IAccountDao accountDao;

    @Override
    @Transactional
    public Action consume(Message message, ConsumeContext context) {
        
        LOG.debug(" message body = " + new String(message.getBody()));
        
        // 转为 对象
        TDMsgOnsDTO od = JSON.parseObject(message.getBody(), TDMsgOnsDTO.class);
        
        msgService.sendMsg(od);
        
        //发送对象是否关注了微信
        Account account = accountDao.getAccountByMobile(od.getPhone());
        if(account!=null&&account.getOpenid()!=null){
            
            SchoolCheckForm form = new SchoolCheckForm();
            
            form.setName("您的孩子");
            form.setSchoolName("学校");
            form.setDirection(true);
            form.setStime("2016-02-19 18:56:55");
            form.setToUser(account.getOpenid());
            form.setUrl(od.getImgUrl());
            
            // 通过阿里云ons服务发送微信公众号推送
            producer.sendOpenMsg(form,account.getId());
        }
        
        return Action.CommitMessage;
    }

}

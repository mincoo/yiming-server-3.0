/**
 * MsgController.java
 */
package com.uxiaoxi.ym.appserver.web.msg.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uxiaoxi.ym.appserver.biz.msg.IMsgService;
import com.uxiaoxi.ym.appserver.web.common.vo.ResResult;
import com.uxiaoxi.ym.appserver.web.msg.vo.MsgDataForm;
import com.uxiaoxi.ym.appserver.web.msg.vo.MsgForm;
import com.uxiaoxi.ym.appserver.web.msg.vo.MsgGSendForm;
import com.uxiaoxi.ym.appserver.web.msg.vo.MsgReadStateForm;
import com.uxiaoxi.ym.appserver.web.msg.vo.MsgSendForm;
import com.uxiaoxi.ym.appserver.web.msg.vo.MsgTagChangeForm;

/**
 * @author renhao
 *
 * 2015年2月28日
 */
@Controller
@RequestMapping("/msg")
public class MsgController {
    
    @Autowired
    private IMsgService msgService;
    
    @ResponseBody
    @RequestMapping(value= "/getlist")
    public ResResult getlistJson(MsgForm form) {
        return this.getlist(form);
    }

    @RequestMapping(value = "/getlist", params = "callback")
    public ResResult  getlistJsonp(MsgForm form) {
        return this.getlist(form);
    }
    
    private ResResult getlist(MsgForm form){
        return msgService.getlist(form);
    }
    
    @ResponseBody
    @RequestMapping(value= "/getdata")
    public ResResult getdataJson(MsgDataForm form) {
        return this.getdata(form);
    }

    @RequestMapping(value = "/getdata", params = "callback")
    public ResResult  getdataJsonp(MsgDataForm form) {
        return this.getdata(form);
    }
    
    private ResResult getdata(MsgDataForm form) {
        return msgService.getdata(form);
    }
    
    @ResponseBody
    @RequestMapping(value= "/delete")
    public ResResult delMsgJson(MsgDataForm form) {
        return this.delMsg(form);
    }

    @RequestMapping(value = "/delete", params = "callback")
    public ResResult  delMsgJsonp(MsgDataForm form) {
        return this.delMsg(form);
    }
    
    private ResResult delMsg(MsgDataForm form){
        return msgService.delMsg(form);
    }
    
    @ResponseBody
    @RequestMapping(value= "/send")
    public ResResult msgSendJson(@Valid MsgSendForm form, BindingResult errors) {
        return this.msgSend(form,errors);
    }

    @RequestMapping(value = "/send", params = "callback")
    public ResResult  msgSendJsonp(@Valid MsgSendForm form,BindingResult errors) {
        return this.msgSend(form,errors);
    }
    
    
    private ResResult msgSend(MsgSendForm form,BindingResult errors){
        return msgService.sendMsg(form,errors);
    }
    
    @ResponseBody
    @RequestMapping(value= "/gsend")
    public ResResult msgGsendJson(@Valid MsgGSendForm form , BindingResult errors) {
        return this.msgGsend(form,errors);
    }

    @RequestMapping(value = "/gsend", params = "callback")
    public ResResult  msgGsendJsonp(MsgGSendForm form, BindingResult errors) {
        return this.msgGsend(form,errors);
    }
    
    private ResResult msgGsend(MsgGSendForm form,BindingResult errors) {
        return msgService.gsendMsg(form,errors);
    }
    
    @ResponseBody
    @RequestMapping(value= "/tagchange")
    public ResResult msgTagChangeJson(@Valid MsgTagChangeForm form) {
        return this.tagChange(form);
    }

    @RequestMapping(value = "/tagchange", params = "callback")
    public ResResult  msgTagChangeJsonp(MsgTagChangeForm form) {
        return this.tagChange(form);
    }
    
    private ResResult tagChange(MsgTagChangeForm form) {
        return msgService.tagChange(form);
    }
    
    @ResponseBody
    @RequestMapping(value= "/readstate")
    public ResResult getReadState(MsgReadStateForm form){
        return msgService.getReadState(form);
    }
}

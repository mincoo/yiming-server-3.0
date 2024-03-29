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

import com.uxiaoxi.ym.aliyun.bean.TDMsgOnsDTO;
import com.uxiaoxi.ym.appserver.biz.msg.IMsgService;
import com.uxiaoxi.ym.appserver.web.common.vo.ResResult;
import com.uxiaoxi.ym.appserver.web.msg.form.MsgDataForm;
import com.uxiaoxi.ym.appserver.web.msg.form.MsgListForm;
import com.uxiaoxi.ym.appserver.web.msg.form.MsgGSendForm;
import com.uxiaoxi.ym.appserver.web.msg.form.MsgActionForm;
import com.uxiaoxi.ym.appserver.web.msg.form.MsgOADataForm;
import com.uxiaoxi.ym.appserver.web.msg.form.MsgOaTagChangeForm;
import com.uxiaoxi.ym.appserver.web.msg.form.MsgTagChangeForm;
import com.uxiaoxi.ym.appserver.web.msg.form.MsgUpdatePushSumForm;

/**
 * @author renhao
 *
 *         2015年2月28日
 */
@Controller
@RequestMapping("/v3/msg")
public class MsgController {

    @Autowired
    private IMsgService msgService;

    @ResponseBody
    @RequestMapping(value = "/getlist")
    public ResResult getlistJson(MsgListForm form) {
        return msgService.getlist(form);
    }

    @ResponseBody
    @RequestMapping(value = "/getdata")
    public ResResult getdataJson(MsgDataForm form) {
        return msgService.getdata(form);
    }

    @ResponseBody
    @RequestMapping(value = "/delete")
    public ResResult delMsgJson(MsgDataForm form) {
        return msgService.delMsg(form);
    }

    @ResponseBody
    @RequestMapping(value = "/gsend")
    public ResResult msgGsendJson(@Valid MsgGSendForm form, BindingResult errors) {
        return msgService.gsendMsg(form, errors);
    }

    @ResponseBody
    @RequestMapping(value = "/tagchange")
    public ResResult msgTagChangeJson(@Valid MsgTagChangeForm form) {
        return msgService.tagChange(form);
    }

    @ResponseBody
    @RequestMapping(value = "/action")
    public ResResult getReadState(MsgActionForm form) {
        return msgService.msgAction(form);
    }
    
    @ResponseBody
    @RequestMapping(value = "/getoalist")
    public ResResult getOAListJson(Long uid) {
        return msgService.getOAList(uid);
    }
    
    @ResponseBody
    @RequestMapping(value = "/getoadata")
    public ResResult getOADataJson(MsgOADataForm form) {
        return msgService.getOAData(form);
    }
    
    @ResponseBody
    @RequestMapping(value = "/oatagchange")
    public ResResult msgOaTagChangeJson(@Valid MsgOaTagChangeForm form) {
        return msgService.oatagChange(form);
    }
    
    @ResponseBody
    @RequestMapping(value = "/updatepushsum")
    public ResResult msgUpdatePushSum(@Valid MsgUpdatePushSumForm form) {
        return msgService.updatePushSum(form);
    }
    
//    @ResponseBody
//    @RequestMapping(value = "/tdsend")
//    public void msgTDSendJson(TDMsgOnsDTO form ,BindingResult errors) {
//        msgService.sendMsg(form, errors);
//    }
    
    @ResponseBody
    @RequestMapping(value = "/tdsend")
    public void msgTDSendJson(TDMsgOnsDTO form ,BindingResult errors) {
        msgService.sendMsg(form);
    }
}

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
import com.uxiaoxi.ym.appserver.web.msg.form.MsgDataForm;
import com.uxiaoxi.ym.appserver.web.msg.form.MsgForm;
import com.uxiaoxi.ym.appserver.web.msg.form.MsgGSendForm;
import com.uxiaoxi.ym.appserver.web.msg.form.MsgReadStateForm;
import com.uxiaoxi.ym.appserver.web.msg.form.MsgTagChangeForm;

/**
 * @author renhao
 *
 *         2015年2月28日
 */
@Controller
@RequestMapping("/msg")
public class MsgController {

    @Autowired
    private IMsgService msgService;

    @ResponseBody
    @RequestMapping(value = "/getlist")
    public ResResult getlistJson(MsgForm form) {
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
    @RequestMapping(value = "/readstate")
    public ResResult getReadState(MsgReadStateForm form) {
        return msgService.getReadState(form);
    }
}

/**
 * IMsgService.java
 */
package com.uxiaoxi.ym.appserver.biz.msg;

import org.springframework.validation.BindingResult;

import com.uxiaoxi.ym.aliyun.bean.TDMsgOnsDTO;
import com.uxiaoxi.ym.appserver.web.common.vo.ResResult;
import com.uxiaoxi.ym.appserver.web.msg.form.MsgDataForm;
import com.uxiaoxi.ym.appserver.web.msg.form.MsgForm;
import com.uxiaoxi.ym.appserver.web.msg.form.MsgGSendForm;
import com.uxiaoxi.ym.appserver.web.msg.form.MsgActionForm;
import com.uxiaoxi.ym.appserver.web.msg.form.MsgSendForm;
import com.uxiaoxi.ym.appserver.web.msg.form.MsgTagChangeForm;

/**
 * @author renhao
 *
 * 2015年2月28日
 */
public interface IMsgService {
    
    /**
     * @param form
     * @return
     */
    public ResResult getlist(MsgForm form);

    /**
     * @param form
     * @return
     */
    public ResResult getdata(MsgDataForm form);

    /**
     * @param form
     * @return
     */
    public ResResult delMsg(MsgDataForm form);

    /**
     * @param form
     * @return
     */
    public ResResult sendMsg(MsgSendForm form, BindingResult errors);

    /**
     * @param form
     * @return
     */
    public ResResult gsendMsg(MsgGSendForm form, BindingResult errors);

    /**
     * @param form
     * @return
     */
    public ResResult msgAction(MsgActionForm form);

    /**
     * @param form
     */
    public void gsendMsg(MsgGSendForm form);

//    /**
//     * @param form
//     */
//    public void sendMsg(MsgSendForm form);

    /**
     * @param od
     */
    public void sendMsg(TDMsgOnsDTO od);
    
    /**
     * @param form
     */
    public ResResult tagChange(MsgTagChangeForm form);
}

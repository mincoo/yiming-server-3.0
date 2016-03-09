/**
 * IMsgService.java
 */
package com.uxiaoxi.ym.appserver.biz.msg;

import org.springframework.validation.BindingResult;

import com.uxiaoxi.ym.aliyun.bean.TDMsgOnsDTO;
import com.uxiaoxi.ym.appserver.web.common.vo.ResResult;
import com.uxiaoxi.ym.appserver.web.msg.form.MsgDataForm;
import com.uxiaoxi.ym.appserver.web.msg.form.MsgListForm;
import com.uxiaoxi.ym.appserver.web.msg.form.MsgGSendForm;
import com.uxiaoxi.ym.appserver.web.msg.form.MsgActionForm;
import com.uxiaoxi.ym.appserver.web.msg.form.MsgOADataForm;
import com.uxiaoxi.ym.appserver.web.msg.form.MsgOaTagChangeForm;
import com.uxiaoxi.ym.appserver.web.msg.form.MsgSendForm;
import com.uxiaoxi.ym.appserver.web.msg.form.MsgTagChangeForm;
import com.uxiaoxi.ym.appserver.web.msg.form.MsgUpdatePushSumForm;

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
    public ResResult getlist(MsgListForm form);

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
    
    /**
     * @param form
     */
    public ResResult updatePushSum(MsgUpdatePushSumForm form);
    
    /**
     * @param uid
     * @return
     */
    public ResResult getOAList(Long uid);
    
    /**
     * @param form
     * @return
     */
    public ResResult getOAData(MsgOADataForm form);
    
    /**
     * @param form
     */
    public ResResult oatagChange(MsgOaTagChangeForm form);
}

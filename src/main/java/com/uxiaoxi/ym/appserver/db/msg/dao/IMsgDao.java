/**
 * IMsgDao.java
 */
package com.uxiaoxi.ym.appserver.db.msg.dao;

import java.util.List;

import com.uxiaoxi.ym.appserver.db.msg.dto.Msg;
import com.uxiaoxi.ym.appserver.framework.db.IBaseSupport;
import com.uxiaoxi.ym.appserver.web.msg.form.MsgOADataForm;
import com.uxiaoxi.ym.appserver.web.msg.vo.MsgOAListVO;

/**
 * @author renhao
 *
 * 2015年2月26日
 */
public interface IMsgDao  extends IBaseSupport<Msg> {
    /**
     * @param uid
     * @return
     */
    public List<MsgOAListVO> getoalist(Long uid);
    
    /**
     * @param uid
     * @return
     */
    public MsgOAListVO getnewdata(Long uid);
    
    /**
     * @param form
     * @return
     */
    public List<MsgOAListVO> getoadata(MsgOADataForm form);
    
    
}

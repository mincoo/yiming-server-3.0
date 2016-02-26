/**
 * IOfficialAccUserDao.java
 */
package com.uxiaoxi.ym.appserver.db.msg.dao;

import com.uxiaoxi.ym.appserver.db.msg.dto.OfficialAccUser;
import com.uxiaoxi.ym.appserver.framework.db.IBaseSupport;
import com.uxiaoxi.ym.appserver.web.msg.form.MsgOaTagChangeForm;

/**
 * @author renhao
 *
 * 2015年2月26日
 */
public interface IOfficialAccUserDao  extends IBaseSupport<OfficialAccUser> {
    
    /**
     * @param from
     * @return
     */
    public int updateMsgOaFlg(MsgOaTagChangeForm from);
}

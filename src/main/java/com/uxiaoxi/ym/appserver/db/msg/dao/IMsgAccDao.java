/**
 * IMsgAccDao.java
 */
package com.uxiaoxi.ym.appserver.db.msg.dao;

import java.util.List;

import com.uxiaoxi.ym.appserver.db.msg.dto.MsgAcc;
import com.uxiaoxi.ym.appserver.framework.db.IBaseSupport;
import com.uxiaoxi.ym.appserver.web.msg.form.MsgDataForm;
import com.uxiaoxi.ym.appserver.web.msg.form.MsgListForm;
import com.uxiaoxi.ym.appserver.web.msg.vo.MsgDataPatInfo;
import com.uxiaoxi.ym.appserver.web.msg.vo.MsgListVO;
import com.uxiaoxi.ym.appserver.web.msg.vo.MsgVO;

/**
 * @author renhao
 *
 * 2015年2月28日
 */
public interface IMsgAccDao extends IBaseSupport<MsgAcc>{


    /**
     * @param form
     * @return
     */
    public List<MsgListVO> getlist(MsgListForm form);

    /**
     * @param form
     * @return
     */
    public MsgVO getdata(MsgDataForm form);

    /**
     * @param record
     */
    public int updateByExample(MsgAcc record);

    /**
     * @param record
     */
    public int updateReaded(MsgAcc record);
    
    /**
     * @param mid
     */
    public List<MsgDataPatInfo> getDataAcc(Long mid);
    
    /**
     * @param mid
     * @param type
     */
    public Long getSum(Long mid,Long type);
    
    /**
     * @param uid
     */
    public Long getLastVer(Long uid);
    
}

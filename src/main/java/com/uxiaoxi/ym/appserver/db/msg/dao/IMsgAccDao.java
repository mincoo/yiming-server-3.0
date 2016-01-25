/**
 * IMsgAccDao.java
 */
package com.uxiaoxi.ym.appserver.db.msg.dao;

import java.util.List;

import com.uxiaoxi.ym.appserver.db.msg.dto.MsgAcc;
import com.uxiaoxi.ym.appserver.framework.db.IBaseSupport;
import com.uxiaoxi.ym.appserver.web.msg.vo.MsgDataForm;
import com.uxiaoxi.ym.appserver.web.msg.vo.MsgForm;
import com.uxiaoxi.ym.appserver.web.msg.vo.MsgReadStateForm;
import com.uxiaoxi.ym.appserver.web.msg.vo.MsgReadStateVO;
import com.uxiaoxi.ym.appserver.web.msg.vo.MsgVO;
import com.uxiaoxi.ym.appserver.web.msg.vo.MsgWithContentVO;

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
    public List<MsgVO> getlist(MsgForm form);

    /**
     * @param form
     * @return
     */
    public MsgWithContentVO getdata(MsgDataForm form);

    /**
     * @param record
     */
    public int updateByExample(MsgAcc record);

    /**
     * @param record
     */
    public int updateReaded(MsgAcc record);

    /**
     * @param form
     * @return
     */
    public List<MsgReadStateVO> getReadState(MsgReadStateForm form);

}

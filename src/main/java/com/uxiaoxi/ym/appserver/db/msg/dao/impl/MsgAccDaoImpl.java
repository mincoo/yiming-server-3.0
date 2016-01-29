/**
 * MsgAccDaoImpl.java
 */
package com.uxiaoxi.ym.appserver.db.msg.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uxiaoxi.ym.appserver.db.msg.dao.IMsgAccDao;
import com.uxiaoxi.ym.appserver.db.msg.dto.MsgAcc;
import com.uxiaoxi.ym.appserver.db.msg.dto.MsgAccExample;
import com.uxiaoxi.ym.appserver.db.msg.mapper.MsgAccMapper;
import com.uxiaoxi.ym.appserver.framework.db.impl.BaseSupport;
import com.uxiaoxi.ym.appserver.web.msg.form.MsgDataForm;
import com.uxiaoxi.ym.appserver.web.msg.form.MsgForm;
import com.uxiaoxi.ym.appserver.web.msg.vo.MsgDataPatInfo;
import com.uxiaoxi.ym.appserver.web.msg.vo.MsgVO;

/**
 * @author renhao
 *
 * 2015年2月28日
 */
@Repository
public class MsgAccDaoImpl extends BaseSupport<MsgAcc, MsgAccMapper> implements IMsgAccDao{

    @Override
    public List<MsgVO> getlist(MsgForm form) {
        MsgAccMapper mapper = this.getSqlSession().getMapper(MsgAccMapper.class);
        return mapper.getlist(form);
    }

    @Override
    public MsgVO getdata(MsgDataForm form) {
        MsgAccMapper mapper = this.getSqlSession().getMapper(MsgAccMapper.class);
        return mapper.getdata(form);
    }

    @Override
    public int updateByExample(MsgAcc record) {
        MsgAccMapper mapper = this.getSqlSession().getMapper(MsgAccMapper.class);
        MsgAccExample example = new MsgAccExample();
        example.createCriteria().andMsgIdEqualTo(record.getMsgId()).andAccIdEqualTo(record.getAccId());
        return mapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateReaded(MsgAcc record) {
        MsgAccMapper mapper = this.getSqlSession().getMapper(MsgAccMapper.class);
        MsgAccExample example = new MsgAccExample();
        example.createCriteria().andAccIdEqualTo(record.getAccId()).andMsgIdEqualTo(record.getMsgId());
        return mapper.updateByExampleSelective(record, example);
    }
    
    @Override
    public List<MsgDataPatInfo> getDataAcc(Long mid){
        MsgAccMapper mapper = this.getSqlSession().getMapper(MsgAccMapper.class);
        return mapper.getDataAcc(mid);
    };
    
}

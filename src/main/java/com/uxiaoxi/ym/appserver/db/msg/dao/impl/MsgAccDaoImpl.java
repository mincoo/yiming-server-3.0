/**
 * MsgAccDaoImpl.java
 */
package com.uxiaoxi.ym.appserver.db.msg.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.uxiaoxi.ym.appserver.db.msg.dao.IMsgAccDao;
import com.uxiaoxi.ym.appserver.db.msg.dto.MsgAcc;
import com.uxiaoxi.ym.appserver.db.msg.dto.MsgAccExample;
import com.uxiaoxi.ym.appserver.db.msg.mapper.MsgAccMapper;
import com.uxiaoxi.ym.appserver.framework.db.impl.BaseSupport;
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
@Repository
public class MsgAccDaoImpl extends BaseSupport<MsgAcc, MsgAccMapper> implements IMsgAccDao{

    @Override
    public List<MsgListVO> getlist(MsgListForm form) {
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
    
    @Override
    public Long getSum(Long mid,Long selected){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("mid", mid);
        map.put("selected", selected);
        MsgAccMapper mapper = this.getSqlSession().getMapper(MsgAccMapper.class);
        return mapper.getSum(map);
    };
    
    @Override
    public Long getLastVer(Long uid){
        MsgAccMapper mapper = this.getSqlSession().getMapper(MsgAccMapper.class);
        return mapper.getLastVer(uid);
    };
    
}

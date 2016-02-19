/**
 * MsgDaoImpl.java
 */
package com.uxiaoxi.ym.appserver.db.msg.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uxiaoxi.ym.appserver.db.msg.dao.IMsgDao;
import com.uxiaoxi.ym.appserver.db.msg.dto.Msg;
import com.uxiaoxi.ym.appserver.db.msg.mapper.MsgAccMapper;
import com.uxiaoxi.ym.appserver.db.msg.mapper.MsgMapper;
import com.uxiaoxi.ym.appserver.framework.db.impl.BaseSupport;
import com.uxiaoxi.ym.appserver.web.msg.vo.MsgOAListVO;

/**
 * @author renhao
 *
 *         2015年2月26日
 */
@Repository
public class MsgDaoImpl extends BaseSupport<Msg, MsgMapper> implements IMsgDao {

    @Override
    public List<MsgOAListVO> getoalist(Long uid) {
        MsgMapper mapper = this.getSqlSession().getMapper(MsgMapper.class);
        return mapper.getoalist(uid);
    }

    @Override
    public List<MsgOAListVO> getnewdata(Long uid) {
        MsgMapper mapper = this.getSqlSession().getMapper(MsgMapper.class);
        return mapper.getnewdata(uid);
    }
}

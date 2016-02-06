/**
 * OptionLogDaoImpl.java
 */
package com.uxiaoxi.ym.appserver.db.msg.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.uxiaoxi.ym.appserver.db.msg.dao.IOptionLogDao;
import com.uxiaoxi.ym.appserver.db.msg.dto.OptionLog;
import com.uxiaoxi.ym.appserver.db.msg.mapper.MsgAccMapper;
import com.uxiaoxi.ym.appserver.db.msg.mapper.OptionLogMapper;
import com.uxiaoxi.ym.appserver.framework.db.impl.BaseSupport;

/**
 * @author renhao
 *
 *         2015年2月26日
 */
@Repository
public class OptionLogDaoImpl extends BaseSupport<OptionLog, OptionLogMapper> implements IOptionLogDao {

    @Override
    public Long getMsgVertion(){
        OptionLogMapper mapper = this.getSqlSession().getMapper(OptionLogMapper.class);
        return mapper.getMsgVertion();
    };


}

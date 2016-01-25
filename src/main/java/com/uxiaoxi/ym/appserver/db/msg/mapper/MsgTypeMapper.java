package com.uxiaoxi.ym.appserver.db.msg.mapper;

import com.uxiaoxi.ym.appserver.db.msg.dto.MsgType;
import com.uxiaoxi.ym.appserver.db.msg.dto.MsgTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MsgTypeMapper {
    int countByExample(MsgTypeExample example);

    int deleteByExample(MsgTypeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MsgType record);

    int insertSelective(MsgType record);

    List<MsgType> selectByExample(MsgTypeExample example);

    MsgType selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MsgType record, @Param("example") MsgTypeExample example);

    int updateByExample(@Param("record") MsgType record, @Param("example") MsgTypeExample example);

    int updateByPrimaryKeySelective(MsgType record);

    int updateByPrimaryKey(MsgType record);
}
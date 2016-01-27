package com.uxiaoxi.ym.appserver.db.msg.mapper;

import com.uxiaoxi.ym.appserver.db.msg.dto.VsChange;
import com.uxiaoxi.ym.appserver.db.msg.dto.VsChangeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VsChangeMapper {
    int countByExample(VsChangeExample example);

    int deleteByExample(VsChangeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(VsChange record);

    int insertSelective(VsChange record);

    List<VsChange> selectByExample(VsChangeExample example);

    VsChange selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") VsChange record, @Param("example") VsChangeExample example);

    int updateByExample(@Param("record") VsChange record, @Param("example") VsChangeExample example);

    int updateByPrimaryKeySelective(VsChange record);

    int updateByPrimaryKey(VsChange record);
}
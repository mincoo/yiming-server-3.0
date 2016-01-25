package com.uxiaoxi.ym.appserver.db.version.mapper;

import com.uxiaoxi.ym.appserver.db.version.dto.VersionMng;
import com.uxiaoxi.ym.appserver.db.version.dto.VersionMngExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VersionMngMapper {
    int countByExample(VersionMngExample example);

    int deleteByExample(VersionMngExample example);

    int deleteByPrimaryKey(Long id);

    int insert(VersionMng record);

    int insertSelective(VersionMng record);

    List<VersionMng> selectByExample(VersionMngExample example);

    VersionMng selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") VersionMng record, @Param("example") VersionMngExample example);

    int updateByExample(@Param("record") VersionMng record, @Param("example") VersionMngExample example);

    int updateByPrimaryKeySelective(VersionMng record);

    int updateByPrimaryKey(VersionMng record);
}
package com.uxiaoxi.ym.appserver.db.test.mapper;

import com.uxiaoxi.ym.appserver.db.test.dto.Local;
import com.uxiaoxi.ym.appserver.db.test.dto.LocalExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LocalMapper {
    int countByExample(LocalExample example);

    int deleteByExample(LocalExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Local record);

    int insertSelective(Local record);

    List<Local> selectByExample(LocalExample example);

    Local selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Local record, @Param("example") LocalExample example);

    int updateByExample(@Param("record") Local record, @Param("example") LocalExample example);

    int updateByPrimaryKeySelective(Local record);

    int updateByPrimaryKey(Local record);
}
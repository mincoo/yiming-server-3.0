package com.uxiaoxi.ym.appserver.db.msg.mapper;

import com.uxiaoxi.ym.appserver.db.msg.dto.OptionLog;
import com.uxiaoxi.ym.appserver.db.msg.dto.OptionLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OptionLogMapper {
    int countByExample(OptionLogExample example);

    int deleteByExample(OptionLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OptionLog record);

    int insertSelective(OptionLog record);

    List<OptionLog> selectByExampleWithBLOBs(OptionLogExample example);

    List<OptionLog> selectByExample(OptionLogExample example);

    OptionLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OptionLog record, @Param("example") OptionLogExample example);

    int updateByExampleWithBLOBs(@Param("record") OptionLog record, @Param("example") OptionLogExample example);

    int updateByExample(@Param("record") OptionLog record, @Param("example") OptionLogExample example);

    int updateByPrimaryKeySelective(OptionLog record);

    int updateByPrimaryKeyWithBLOBs(OptionLog record);

    int updateByPrimaryKey(OptionLog record);
}
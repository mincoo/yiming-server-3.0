package com.uxiaoxi.ym.appserver.db.account.mapper;

import com.uxiaoxi.ym.appserver.db.account.dto.AccType;
import com.uxiaoxi.ym.appserver.db.account.dto.AccTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AccTypeMapper {
    int countByExample(AccTypeExample example);

    int deleteByExample(AccTypeExample example);

    int deleteByPrimaryKey(Integer type);

    int insert(AccType record);

    int insertSelective(AccType record);

    List<AccType> selectByExample(AccTypeExample example);

    AccType selectByPrimaryKey(Integer type);

    int updateByExampleSelective(@Param("record") AccType record, @Param("example") AccTypeExample example);

    int updateByExample(@Param("record") AccType record, @Param("example") AccTypeExample example);

    int updateByPrimaryKeySelective(AccType record);

    int updateByPrimaryKey(AccType record);
}
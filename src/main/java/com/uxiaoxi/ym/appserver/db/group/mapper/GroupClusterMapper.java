package com.uxiaoxi.ym.appserver.db.group.mapper;

import com.uxiaoxi.ym.appserver.db.group.dto.GroupCluster;
import com.uxiaoxi.ym.appserver.db.group.dto.GroupClusterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GroupClusterMapper {
    int countByExample(GroupClusterExample example);

    int deleteByExample(GroupClusterExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GroupCluster record);

    int insertSelective(GroupCluster record);

    List<GroupCluster> selectByExample(GroupClusterExample example);

    GroupCluster selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GroupCluster record, @Param("example") GroupClusterExample example);

    int updateByExample(@Param("record") GroupCluster record, @Param("example") GroupClusterExample example);

    int updateByPrimaryKeySelective(GroupCluster record);

    int updateByPrimaryKey(GroupCluster record);
}
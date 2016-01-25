package com.uxiaoxi.ym.appserver.db.cluster.mapper;

import com.uxiaoxi.ym.appserver.db.cluster.dto.StudentFollow;
import com.uxiaoxi.ym.appserver.db.cluster.dto.StudentFollowExample;
import com.uxiaoxi.ym.appserver.web.cluster.vo.ClusterUserListForm;
import com.uxiaoxi.ym.appserver.web.cluster.vo.SearchUserListPSub;
import com.uxiaoxi.ym.appserver.web.cluster.vo.SearchUserListSSub;
import com.uxiaoxi.ym.appserver.web.cluster.vo.SearchUserListSVO;
import com.uxiaoxi.ym.appserver.web.cluster.vo.SearchUserListTSub;
import com.uxiaoxi.ym.appserver.web.cluster.vo.SearchUserListTVO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface StudentFollowMapper {
    int countByExample(StudentFollowExample example);

    int deleteByExample(StudentFollowExample example);

    int deleteByPrimaryKey(Long id);

    int insert(StudentFollow record);

    int insertSelective(StudentFollow record);

    List<StudentFollow> selectByExample(StudentFollowExample example);

    StudentFollow selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") StudentFollow record, @Param("example") StudentFollowExample example);

    int updateByExample(@Param("record") StudentFollow record, @Param("example") StudentFollowExample example);

    int updateByPrimaryKeySelective(StudentFollow record);

    int updateByPrimaryKey(StudentFollow record);
    
    List<SearchUserListTSub> searchInfoTSub(Map<String,Object> map);
    
    List<SearchUserListPSub> searchInfoPSub(Map<String,Object> map);
    
    List<SearchUserListSSub> searchInfoSSub(Map<String,Object> map);
    
    List<SearchUserListSVO> searchByGidS(ClusterUserListForm form);
}
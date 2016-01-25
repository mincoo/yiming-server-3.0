package com.uxiaoxi.ym.appserver.db.cluster.mapper;

import com.uxiaoxi.ym.appserver.db.cluster.dto.ClusterUser;
import com.uxiaoxi.ym.appserver.db.cluster.dto.ClusterUserExample;
import com.uxiaoxi.ym.appserver.web.account.vo.SearchUserResultVO;
import com.uxiaoxi.ym.appserver.web.cluster.vo.ClusterUserListForm;
import com.uxiaoxi.ym.appserver.web.cluster.vo.ClusterUserListVO;
import com.uxiaoxi.ym.appserver.web.cluster.vo.ClusterUserSearchForm;
import com.uxiaoxi.ym.appserver.web.cluster.vo.ClusterUserSearchResultVO;
import com.uxiaoxi.ym.appserver.web.cluster.vo.SearchUserListPVO;
import com.uxiaoxi.ym.appserver.web.cluster.vo.SearchUserListSVO;
import com.uxiaoxi.ym.appserver.web.cluster.vo.SearchUserListTVO;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ClusterUserMapper {
    int countByExample(ClusterUserExample example);

	int deleteByExample(ClusterUserExample example);

	int deleteByPrimaryKey(Long id);

	int insert(ClusterUser record);

	int insertSelective(ClusterUser record);

	List<ClusterUser> selectByExample(ClusterUserExample example);

	ClusterUser selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") ClusterUser record,
			@Param("example") ClusterUserExample example);

	int updateByExample(@Param("record") ClusterUser record,
			@Param("example") ClusterUserExample example);

	int updateByPrimaryKeySelective(ClusterUser record);

	int updateByPrimaryKey(ClusterUser record);
    
    List<ClusterUserSearchResultVO> searchByUid(ClusterUserSearchForm form);
    
    List<ClusterUserListVO> searchByGid(ClusterUserListForm form);
    
    List<SearchUserListTVO> searchByGidT(ClusterUserListForm form);
    
    List<SearchUserListPVO> searchByGidP(ClusterUserListForm form);
    
    List<SearchUserListSVO> searchByGidS(ClusterUserListForm form);
    
    List<ClusterUser> getAllByUid(Long id);
}
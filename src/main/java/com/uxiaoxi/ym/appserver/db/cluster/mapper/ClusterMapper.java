package com.uxiaoxi.ym.appserver.db.cluster.mapper;

import com.uxiaoxi.ym.appserver.db.cluster.dto.Cluster;
import com.uxiaoxi.ym.appserver.db.cluster.dto.ClusterExample;
import com.uxiaoxi.ym.appserver.web.cluster.vo.ClusterByGidVO;
import com.uxiaoxi.ym.appserver.web.cluster.vo.ClusterBySnResult;
import com.uxiaoxi.ym.appserver.web.cluster.vo.ClusterSearchBySnForm;
import com.uxiaoxi.ym.appserver.web.cluster.vo.ClusterSearchForm;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ClusterMapper {
    int countByExample(ClusterExample example);

	int deleteByExample(ClusterExample example);

	int deleteByPrimaryKey(Long id);

	int insert(Cluster record);

	int insertSelective(Cluster record);

	List<Cluster> selectByExample(ClusterExample example);

	Cluster selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") Cluster record,
			@Param("example") ClusterExample example);

	int updateByExample(@Param("record") Cluster record,
			@Param("example") ClusterExample example);

	int updateByPrimaryKeySelective(Cluster record);

	int updateByPrimaryKey(Cluster record);

//    /**
//     * @param form
//     * @return
//     */
//    List<ClusterVO> searchByName(ClusterSearchForm form);
    
    /**
     * @param form
     * @return
     */
    ClusterByGidVO searchByGid(ClusterSearchForm form);
    
    /**
     * @param map
     * @return
     */
    int countUserByType(Map<String,Object> map);
    
    /**
     * @param form
     * @return
     */
    ClusterBySnResult searchBySn(ClusterSearchBySnForm form);
    
    /**
     * @param
     * @return
     */
    int searchMaxSn();
}
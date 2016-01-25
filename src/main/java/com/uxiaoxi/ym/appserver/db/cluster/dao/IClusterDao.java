/**
 * IClusterDao.java
 */
package com.uxiaoxi.ym.appserver.db.cluster.dao;

import java.util.List;
import java.util.Map;

import com.uxiaoxi.ym.appserver.db.cluster.dto.Cluster;
import com.uxiaoxi.ym.appserver.framework.db.IBaseSupport;
import com.uxiaoxi.ym.appserver.web.cluster.vo.ClusterByGidVO;
import com.uxiaoxi.ym.appserver.web.cluster.vo.ClusterBySnResult;
import com.uxiaoxi.ym.appserver.web.cluster.vo.ClusterBySnVO;
import com.uxiaoxi.ym.appserver.web.cluster.vo.ClusterSearchBySnForm;
import com.uxiaoxi.ym.appserver.web.cluster.vo.ClusterSearchForm;

/**
 * @author renhao
 *
 *         2015年3月3日
 */
public interface IClusterDao extends IBaseSupport<Cluster> {

//    /**
//     * @param form
//     * @return
//     */
//    public List<ClusterVO> searchByName(ClusterSearchForm form);
//    
    /**
     * @param form
     * @return
     */
    public ClusterByGidVO searchByGid(ClusterSearchForm form);
    
    /**
     * @param map
     * @return
     */
    public int countUserByType(Map<String,Object> map);
  
    /**
     * @param form
     * @return
     */
    public ClusterBySnResult searchBySn(ClusterSearchBySnForm form);
    
    /**
     * @param 
     * @return
     */
    public int searchMaxSn();

}

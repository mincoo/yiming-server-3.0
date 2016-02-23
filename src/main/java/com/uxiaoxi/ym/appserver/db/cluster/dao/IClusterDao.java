/**
 * IClusterDao.java
 */
package com.uxiaoxi.ym.appserver.db.cluster.dao;

import java.util.Map;

import com.uxiaoxi.ym.appserver.db.cluster.dto.Cluster;
import com.uxiaoxi.ym.appserver.framework.db.IBaseSupport;
import com.uxiaoxi.ym.appserver.web.cluster.form.ClusterSearchBySnForm;
import com.uxiaoxi.ym.appserver.web.cluster.vo.ClusterBySnResult;

/**
 * @author renhao
 *
 *         2015年3月3日
 */
public interface IClusterDao extends IBaseSupport<Cluster> {

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

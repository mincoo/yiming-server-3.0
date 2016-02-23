/**
 * ClusterDaoImpl.java
 */
package com.uxiaoxi.ym.appserver.db.cluster.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.uxiaoxi.ym.appserver.db.cluster.dao.IClusterDao;
import com.uxiaoxi.ym.appserver.db.cluster.dto.Cluster;
import com.uxiaoxi.ym.appserver.db.cluster.mapper.ClusterMapper;
import com.uxiaoxi.ym.appserver.framework.db.impl.BaseSupport;
import com.uxiaoxi.ym.appserver.web.cluster.form.ClusterSearchBySnForm;
import com.uxiaoxi.ym.appserver.web.cluster.vo.ClusterBySnResult;

/**
 * @author renhao
 *
 *         2015年3月3日
 */
@Repository
public class ClusterDaoImpl extends BaseSupport<Cluster, ClusterMapper>
        implements IClusterDao {
    
    @Override
    public int countUserByType(Map<String,Object> map) {
        ClusterMapper mapper = this.getSqlSession().getMapper(ClusterMapper.class);

        return mapper.countUserByType(map);
    }
    
    @Override
    public ClusterBySnResult searchBySn(ClusterSearchBySnForm form) {
        ClusterMapper mapper = this.getSqlSession().getMapper(ClusterMapper.class);

        return mapper.searchBySn(form);
    }
    
    @Override
    public int searchMaxSn() {
        ClusterMapper mapper = this.getSqlSession().getMapper(ClusterMapper.class);

        return mapper.searchMaxSn();
    }

}

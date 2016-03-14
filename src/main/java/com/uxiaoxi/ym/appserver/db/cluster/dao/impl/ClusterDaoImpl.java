/**
 * ClusterDaoImpl.java
 */
package com.uxiaoxi.ym.appserver.db.cluster.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.uxiaoxi.ym.appserver.db.account.dto.Account;
import com.uxiaoxi.ym.appserver.db.cluster.dao.IClusterDao;
import com.uxiaoxi.ym.appserver.db.cluster.dto.Cluster;
import com.uxiaoxi.ym.appserver.db.cluster.dto.ClusterExample;
import com.uxiaoxi.ym.appserver.db.cluster.mapper.ClusterMapper;
import com.uxiaoxi.ym.appserver.framework.db.impl.BaseSupport;
import com.uxiaoxi.ym.appserver.framework.page.model.Page;
import com.uxiaoxi.ym.appserver.web.cluster.form.ClusterSearchBySnForm;
import com.uxiaoxi.ym.appserver.web.cluster.form.ExitForm;
import com.uxiaoxi.ym.appserver.web.cluster.vo.ClusterBySnResult;
import com.uxiaoxi.ym.appserver.web.common.vo.SqlBean;

/**
 * @author renhao
 *
 *         2015年3月3日
 */
@Repository
public class ClusterDaoImpl extends BaseSupport<Cluster, ClusterMapper>
        implements IClusterDao {
    
    @SuppressWarnings("unchecked")
    @Override
    public Page<Cluster> getData(SqlBean sqlBean, Integer page_no, Integer page_size) {
        Page<Cluster> page = null;
        try {
            page = this.selectPage("com.uxiaoxi.ym.appserver.db.cluster.mapper.ClusterMapper.getData",sqlBean, page_no, page_size);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return page;
    }
    
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
    
    @Override
    public boolean isCreateBy(ExitForm form) {
        ClusterMapper mapper = this.getSqlSession().getMapper(ClusterMapper.class);
        
        ClusterExample example = new ClusterExample();
        example.createCriteria().andCreateByEqualTo(form.getUid())
                .andIdEqualTo(form.getGid());
        
        if(mapper.countByExample(example)>0){
            return true;
        }

        return false;
    }
}

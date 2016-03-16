/**
 * IClusterDao.java
 */
package com.uxiaoxi.ym.appserver.db.cluster.dao;

import java.util.List;
import java.util.Map;

import com.uxiaoxi.ym.appserver.db.account.dto.Account;
import com.uxiaoxi.ym.appserver.db.cluster.dto.Cluster;
import com.uxiaoxi.ym.appserver.framework.db.IBaseSupport;
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
    
    /**
     * @param form
     * @return
     */
    public boolean isCreateBy(ExitForm form);
    
    public Page<Cluster> getData(SqlBean sqlBean, Integer page_no, Integer page_size);

    public List<Cluster> getData();
}

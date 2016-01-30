/**
 * IClusterService.java
 */
package com.uxiaoxi.ym.appserver.biz.cluster;

import com.uxiaoxi.ym.appserver.web.cluster.form.AddDelUserForm;
import com.uxiaoxi.ym.appserver.web.cluster.form.ClusterSearchBySnForm;
import com.uxiaoxi.ym.appserver.web.cluster.form.ClusterSearchForm;
import com.uxiaoxi.ym.appserver.web.cluster.form.ClusterUserListForm;
import com.uxiaoxi.ym.appserver.web.cluster.form.ClusterUserSearchForm;
import com.uxiaoxi.ym.appserver.web.cluster.form.CreateClusterForm;
import com.uxiaoxi.ym.appserver.web.cluster.form.ExitForm;
import com.uxiaoxi.ym.appserver.web.cluster.form.JoinClusterForm;
import com.uxiaoxi.ym.appserver.web.cluster.form.UpdateRemarkForm;
import com.uxiaoxi.ym.appserver.web.common.vo.ResResult;

/**
 * @author renhao
 *
 * 2015年3月3日
 */
public interface IClusterService {

    /**
     * @param form
     * @return
     */
    public ResResult getlist(ClusterUserSearchForm form);

    /**
     * @param form
     * @return
     */
    public ResResult createCluster(CreateClusterForm form);
    
    /**
     * @param form
     * @return
     */
    public ResResult updateCluster(CreateClusterForm form);

//    /**
//     * @param form
//     * @return
//     */
//    public ResResult searchClusterByGid(ClusterSearchForm form);
    
//    /**
//     * @param form
//     * @return
//     */
//    public ResResult searchCluster(ClusterSearchForm form);

    /**
     * @param form
     * @return
     */
    public ResResult joinCluster(JoinClusterForm form);

    /**
     * @param form
     * @return
     */
    public ResResult addUser(AddDelUserForm form);

    /**
     * @param form
     * @return
     */
    public ResResult deluser(AddDelUserForm form);
    
    /**
     * @param form
     * @return
     */
    public ResResult exitgroup(ExitForm form);

    /**
     * @param form
     * @return
     */
    public ResResult getUserList(ClusterUserListForm form);
    
    /**
     * @param form
     * @return
     */
    public ResResult searchClusterBySn(ClusterSearchBySnForm form);
    
    /**
     * @param form
     * @return
     */
    public ResResult updateRemark(UpdateRemarkForm form);
    
    /**
     * @param uid
     * @return
     */
    public ResResult searchcname(Long uid);
    
}

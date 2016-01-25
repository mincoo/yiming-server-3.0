/**
 * IClusterService.java
 */
package com.uxiaoxi.ym.appserver.biz.cluster;

import com.uxiaoxi.ym.appserver.web.cluster.vo.AddChildForm;
import com.uxiaoxi.ym.appserver.web.cluster.vo.AddDelUserForm;
import com.uxiaoxi.ym.appserver.web.cluster.vo.AddStudentForm;
import com.uxiaoxi.ym.appserver.web.cluster.vo.ClusterSearchBySnForm;
import com.uxiaoxi.ym.appserver.web.cluster.vo.ClusterSearchForm;
import com.uxiaoxi.ym.appserver.web.cluster.vo.ClusterUserListForm;
import com.uxiaoxi.ym.appserver.web.cluster.vo.ClusterUserSearchForm;
import com.uxiaoxi.ym.appserver.web.cluster.vo.CreateClusterForm;
import com.uxiaoxi.ym.appserver.web.cluster.vo.ExitForm;
import com.uxiaoxi.ym.appserver.web.cluster.vo.JoinClusterForm;
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

    /**
     * @param form
     * @return
     */
    public ResResult searchClusterByGid(ClusterSearchForm form);
    
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
    public ResResult delstudent(AddDelUserForm form);
    
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
    public ResResult getUserListT(ClusterUserListForm form);
    
    /**
     * @param form
     * @return
     */
    public ResResult getUserListP(ClusterUserListForm form);
    
    /**
     * @param form
     * @return
     */
    public ResResult getUserListS(ClusterUserListForm form);
    
    /**
     * @param form
     * @return
     */
    public ResResult addStudent(AddStudentForm form);

    /**
     * @param form
     * @return
     */
    public ResResult addChild(AddChildForm form);


    
}

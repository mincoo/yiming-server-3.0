/**
 * IStudentFollowDao.java
 */
package com.uxiaoxi.ym.appserver.db.cluster.dao;

import java.util.List;
import java.util.Map;

import com.uxiaoxi.ym.appserver.db.cluster.dto.StudentFollow;
import com.uxiaoxi.ym.appserver.framework.db.IBaseSupport;
import com.uxiaoxi.ym.appserver.web.cluster.form.AddChildForm;
import com.uxiaoxi.ym.appserver.web.cluster.form.ClusterUserListForm;
import com.uxiaoxi.ym.appserver.web.cluster.vo.SearchUserListPSub;
import com.uxiaoxi.ym.appserver.web.cluster.vo.SearchUserListSSub;
import com.uxiaoxi.ym.appserver.web.cluster.vo.SearchUserListSVO;
import com.uxiaoxi.ym.appserver.web.cluster.vo.SearchUserListTSub;

/**
 * @author mbg
 *
 * 2015-9-22
 */
public interface IStudentFollowDao extends IBaseSupport<StudentFollow> {

    /**
     * @param map
     * @return
     */
    public List<SearchUserListTSub> searchInfoTSub(Map<String,Object> map);
    
    /**
     * @param map
     * @return
     */
    public List<SearchUserListPSub> searchInfoPSub(Map<String,Object> map);
    
    /**
     * @param map
     * @return
     */
    public List<SearchUserListSSub> searchInfoSSub(Map<String,Object> map);
    
    /**
     * @param form
     * @return
     */
    public List<SearchUserListSVO> searchByGidS(ClusterUserListForm form);
    
    /**
     * @param form
     * @return
     */
    public StudentFollow search(AddChildForm form,Long sid);
    
}

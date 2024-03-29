/**
 * IClusterUserDao.java
 */
package com.uxiaoxi.ym.appserver.db.cluster.dao;

import java.util.List;

import com.uxiaoxi.ym.appserver.db.cluster.dto.ClusterUser;
import com.uxiaoxi.ym.appserver.framework.db.IBaseSupport;
import com.uxiaoxi.ym.appserver.web.cluster.form.AddDelUserForm;
import com.uxiaoxi.ym.appserver.web.cluster.form.ClusterUserListForm;
import com.uxiaoxi.ym.appserver.web.cluster.form.ClusterUserSearchForm;
import com.uxiaoxi.ym.appserver.web.cluster.form.ExitForm;
import com.uxiaoxi.ym.appserver.web.cluster.vo.ClusterUserListVO;
import com.uxiaoxi.ym.appserver.web.cluster.vo.ClusterUserSearchResultVO;
import com.uxiaoxi.ym.appserver.web.msg.form.MsgTagChangeForm;

/**
 * @author renhao
 *
 *         2015年3月3日
 */
public interface IClusterUserDao extends IBaseSupport<ClusterUser> {

    /**
     * @param form
     * @return
     */
    public List<ClusterUserSearchResultVO> searchByUid(ClusterUserSearchForm form);

    /**
     * @param form
     */
    public int deluser(AddDelUserForm form);
    
    /**
     * @param form
     */
    public int exitgroup(ExitForm form);
    
    /**
     * @param form
     */
    public int exitgroupAll(ExitForm form);

    /**
     * @param form
     * @return
     */
    public List<ClusterUserListVO> searchByGidP(ClusterUserListForm form);
    
    /**
     * @param form
     * @return
     */
    public List<ClusterUserListVO> searchByGidT(ClusterUserListForm form);

    /**
     * @param gid
     */
    public List<ClusterUser> selectByGid(Long gid);

    /**
     * @param id
     */
    public List<ClusterUser> getAllByUid(Long id);

    /**
     * @param gid
     * @param uid
     * @return
     */
    public ClusterUser searchByGidAndUid(Long gid, Long uid);
    
    /**
     * @param from
     * @return
     */
    public int updateMsgFlg(MsgTagChangeForm from);
    
    /**
     * @param gid
     * @param uid
     * @return
     */
    public String selectChildName(Long uid, Long gid);

}

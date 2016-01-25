/**
 * IClusterUserDao.java
 */
package com.uxiaoxi.ym.appserver.db.cluster.dao;

import java.util.List;

import com.uxiaoxi.ym.appserver.db.cluster.dto.ClusterUser;
import com.uxiaoxi.ym.appserver.db.msg.dto.MsgAcc;
import com.uxiaoxi.ym.appserver.db.msg.dto.MsgAccExample;
import com.uxiaoxi.ym.appserver.db.msg.mapper.MsgAccMapper;
import com.uxiaoxi.ym.appserver.framework.db.IBaseSupport;
import com.uxiaoxi.ym.appserver.web.account.vo.SearchUserResultVO;
import com.uxiaoxi.ym.appserver.web.cluster.vo.AddDelUserForm;
import com.uxiaoxi.ym.appserver.web.cluster.vo.ClusterUserListForm;
import com.uxiaoxi.ym.appserver.web.cluster.vo.ClusterUserListVO;
import com.uxiaoxi.ym.appserver.web.cluster.vo.ClusterUserSearchForm;
import com.uxiaoxi.ym.appserver.web.cluster.vo.ClusterUserSearchResultVO;
import com.uxiaoxi.ym.appserver.web.cluster.vo.ExitForm;
import com.uxiaoxi.ym.appserver.web.cluster.vo.SearchUserListPVO;
import com.uxiaoxi.ym.appserver.web.cluster.vo.SearchUserListSVO;
import com.uxiaoxi.ym.appserver.web.cluster.vo.SearchUserListTVO;
import com.uxiaoxi.ym.appserver.web.msg.vo.MsgTagChangeForm;

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
     * @return
     */
    public List<ClusterUserListVO> searchByGid(ClusterUserListForm form);

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
     * @param form
     * @return
     */
    public List<SearchUserListTVO> searchByGidT(ClusterUserListForm form);
    
    /**
     * @param form
     * @return
     */
    public List<SearchUserListPVO> searchByGidP(ClusterUserListForm form);
    
    /**
     * @param form
     * @return
     */
    public List<SearchUserListSVO> searchByGidS(ClusterUserListForm form);
    
    /**
     * @param from
     * @return
     */
    public int updateJpushFlg(MsgTagChangeForm from);

}

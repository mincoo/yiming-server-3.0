/**
 * ClusterUserDaoImpl.java
 */
package com.uxiaoxi.ym.appserver.db.cluster.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uxiaoxi.ym.appserver.db.cluster.dao.IClusterUserDao;
import com.uxiaoxi.ym.appserver.db.cluster.dto.ClusterUser;
import com.uxiaoxi.ym.appserver.db.cluster.dto.ClusterUserExample;
import com.uxiaoxi.ym.appserver.db.cluster.mapper.ClusterUserMapper;
import com.uxiaoxi.ym.appserver.framework.db.impl.BaseSupport;
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
@Repository
public class ClusterUserDaoImpl extends
        BaseSupport<ClusterUser, ClusterUserMapper> implements IClusterUserDao {


    @Override
    public List<ClusterUserSearchResultVO> searchByUid(
            ClusterUserSearchForm form) {
        ClusterUserMapper mapper = this.getSqlSession().getMapper(
                ClusterUserMapper.class);

        return mapper.searchByUid(form);
    }

    @Override
    public int deluser(AddDelUserForm form) {
        ClusterUserMapper mapper = this.getSqlSession().getMapper(
                ClusterUserMapper.class);

        ClusterUserExample example = new ClusterUserExample();
        example.createCriteria().andAccIdEqualTo(form.getNid())
                .andCluIdEqualTo(form.getGid());

        return mapper.deleteByExample(example);
    }

    @Override
    public int exitgroup(ExitForm form) {
        ClusterUserMapper mapper = this.getSqlSession().getMapper(
                ClusterUserMapper.class);

        ClusterUserExample example = new ClusterUserExample();
        example.createCriteria().andAccIdEqualTo(form.getUid())
                .andCluIdEqualTo(form.getGid());

        return mapper.deleteByExample(example);
    }
    
    @Override
    public int exitgroupAll(ExitForm form) {
        ClusterUserMapper mapper = this.getSqlSession().getMapper(
                ClusterUserMapper.class);

        ClusterUserExample example = new ClusterUserExample();
        example.createCriteria().andCluIdEqualTo(form.getGid());

        return mapper.deleteByExample(example);
    }

    @Override
    public List<ClusterUserListVO> searchByGidT(ClusterUserListForm form) {

        ClusterUserMapper mapper = this.getSqlSession().getMapper(
                ClusterUserMapper.class);
        return mapper.searchByGidT(form);
    }

    @Override
    public List<ClusterUserListVO> searchByGidP(ClusterUserListForm form) {

        ClusterUserMapper mapper = this.getSqlSession().getMapper(
                ClusterUserMapper.class);
        return mapper.searchByGidP(form);
    }

    @Override
    public List<ClusterUser> selectByGid(Long gid) {
        ClusterUserMapper mapper = this.getSqlSession().getMapper(
                ClusterUserMapper.class);
        ClusterUserExample example = new ClusterUserExample();
        example.createCriteria().andCluIdEqualTo(gid);
        return mapper.selectByExample(example);
    }

    @Override
    public List<ClusterUser> getAllByUid(Long id) {
        // ClusterUserMapper mapper =
        // this.getSqlSession().getMapper(ClusterUserMapper.class);
        // ClusterUserExample example = new ClusterUserExample();
        // example.createCriteria().andAccIdEqualTo(id);
        // return mapper.selectByExample(example);
        ClusterUserMapper mapper = this.getSqlSession().getMapper(
                ClusterUserMapper.class);
        return mapper.getAllByUid(id);
    }

    @Override
    public ClusterUser searchByGidAndUid(Long gid, Long uid) {
        ClusterUserMapper mapper = this.getSqlSession().getMapper(
                ClusterUserMapper.class);
        ClusterUserExample example = new ClusterUserExample();
        example.createCriteria().andCluIdEqualTo(gid).andAccIdEqualTo(uid);
        List<ClusterUser> list = mapper.selectByExample(example);
        if (list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }

    }

    @Override
    public int updateMsgFlg(MsgTagChangeForm form) {
        ClusterUser record = new ClusterUser();
        record.setAccId(form.getUid());
        record.setCluId(form.getGid());
        record.setMsgFlg(form.getStatus());
        record.setCreateDt(new Date());

        ClusterUserMapper mapper = this.getSqlSession().getMapper(
                ClusterUserMapper.class);
        ClusterUserExample example = new ClusterUserExample();
        example.createCriteria().andCluIdEqualTo(form.getGid())
                .andAccIdEqualTo(form.getUid());
        return mapper.updateByExampleSelective(record, example);
    }

    @Override
    public String selectChildName(Long uid, Long gid){
        ClusterUserMapper mapper = this.getSqlSession().getMapper(
                ClusterUserMapper.class);
        ClusterUserExample example = new ClusterUserExample();
        example.createCriteria().andCluIdEqualTo(gid).andAccIdEqualTo(uid);
        return mapper.selectChildName(example);
    };

}

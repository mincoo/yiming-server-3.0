/**
 * StudentFollowDaoImpl.java
 */
package com.uxiaoxi.ym.appserver.db.cluster.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.uxiaoxi.ym.appserver.db.cluster.dao.IStudentFollowDao;
import com.uxiaoxi.ym.appserver.db.cluster.dto.ClusterUser;
import com.uxiaoxi.ym.appserver.db.cluster.dto.ClusterUserExample;
import com.uxiaoxi.ym.appserver.db.cluster.dto.StudentFollow;
import com.uxiaoxi.ym.appserver.db.cluster.dto.StudentFollowExample;
import com.uxiaoxi.ym.appserver.db.cluster.mapper.ClusterUserMapper;
import com.uxiaoxi.ym.appserver.db.cluster.mapper.StudentFollowMapper;
import com.uxiaoxi.ym.appserver.framework.db.impl.BaseSupport;
import com.uxiaoxi.ym.appserver.web.cluster.form.AddChildForm;
import com.uxiaoxi.ym.appserver.web.cluster.form.ClusterUserListForm;
import com.uxiaoxi.ym.appserver.web.cluster.vo.SearchUserListPSub;
import com.uxiaoxi.ym.appserver.web.cluster.vo.SearchUserListSSub;
import com.uxiaoxi.ym.appserver.web.cluster.vo.SearchUserListSVO;
import com.uxiaoxi.ym.appserver.web.cluster.vo.SearchUserListTSub;
import com.uxiaoxi.ym.appserver.web.common.vo.StatusConst;
/**
 * @author mbg
 *
 * 2015-9-22
 */
@Repository
public class StudentFollowDaoImpl extends BaseSupport<StudentFollow, StudentFollowMapper> implements IStudentFollowDao {

    @Override
    public List<SearchUserListTSub> searchInfoTSub(Map<String,Object> map) {
        
    	StudentFollowMapper mapper = this.getSqlSession().getMapper(StudentFollowMapper.class);
        return mapper.searchInfoTSub(map);
    }
    
    @Override
    public List<SearchUserListPSub> searchInfoPSub(Map<String,Object> map) {
        
    	StudentFollowMapper mapper = this.getSqlSession().getMapper(StudentFollowMapper.class);
        return mapper.searchInfoPSub(map);
    }
    
    @Override
    public List<SearchUserListSSub> searchInfoSSub(Map<String,Object> map) {
        
    	StudentFollowMapper mapper = this.getSqlSession().getMapper(StudentFollowMapper.class);
        return mapper.searchInfoSSub(map);
    }
    
    @Override
    public List<SearchUserListSVO> searchByGidS(ClusterUserListForm form) {
        
    	StudentFollowMapper mapper = this.getSqlSession().getMapper(StudentFollowMapper.class);
        return mapper.searchByGidS(form);
    }
    
    @Override
    public StudentFollow search(AddChildForm form,Long sid) {
    	StudentFollowMapper mapper = this.getSqlSession().getMapper(StudentFollowMapper.class);
    	StudentFollowExample example = new StudentFollowExample();
        example.createCriteria().andCluIdEqualTo(form.getGid()).andAccIdEqualTo(form.getUid()).andStuIdEqualTo(sid).andTypeEqualTo(new Long(StatusConst.PATRIARCH));
        List<StudentFollow> list = mapper.selectByExample(example);
        if(list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }
}

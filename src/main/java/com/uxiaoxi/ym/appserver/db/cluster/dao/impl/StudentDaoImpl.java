/**
 * StudentDaoImpl.java
 */
package com.uxiaoxi.ym.appserver.db.cluster.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uxiaoxi.ym.appserver.db.cluster.dao.IStudentDao;
import com.uxiaoxi.ym.appserver.db.cluster.dto.ClusterUser;
import com.uxiaoxi.ym.appserver.db.cluster.dto.ClusterUserExample;
import com.uxiaoxi.ym.appserver.db.cluster.dto.Student;
import com.uxiaoxi.ym.appserver.db.cluster.dto.StudentExample;
import com.uxiaoxi.ym.appserver.db.cluster.mapper.ClusterUserMapper;
import com.uxiaoxi.ym.appserver.db.cluster.mapper.StudentMapper;
import com.uxiaoxi.ym.appserver.framework.db.impl.BaseSupport;
import com.uxiaoxi.ym.appserver.framework.page.model.Page;
import com.uxiaoxi.ym.appserver.web.cluster.form.AddDelUserForm;
import com.uxiaoxi.ym.appserver.web.common.vo.SqlBean;
/**
 * @author mbg
 *
 * 2015-9-22
 */
@Repository
public class StudentDaoImpl extends BaseSupport<Student, StudentMapper> implements IStudentDao {
	
    @Override
    public int delstudent(AddDelUserForm form) {
        StudentMapper mapper = this.getSqlSession().getMapper(StudentMapper.class);
        
        StudentExample example = new StudentExample();
        example.createCriteria().andIdEqualTo(form.getNid()).andCluIdEqualTo(form.getGid());
        
        return mapper.deleteByExample(example);
    }
    
    @Override
    public int countByGid(Long gid) {
    	StudentMapper mapper = this.getSqlSession().getMapper(StudentMapper.class);
    	StudentExample example = new StudentExample();
        example.createCriteria().andCluIdEqualTo(gid);
        List<Student> list = mapper.selectByExample(example);
        if(list!=null){
        	return list.size();
        }else{
        	return 0;
        }
    }
}

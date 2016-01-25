/**
 * IStudentDao.java
 */
package com.uxiaoxi.ym.appserver.db.cluster.dao;

import java.util.List;

import com.uxiaoxi.ym.appserver.db.cluster.dto.Student;
import com.uxiaoxi.ym.appserver.framework.db.IBaseSupport;
import com.uxiaoxi.ym.appserver.web.cluster.vo.AddDelUserForm;

/**
 * @author mbg
 *
 * 2015-9-22
 */
public interface IStudentDao extends IBaseSupport<Student> {

    /**
     * @param form
     */
    public int delstudent(AddDelUserForm form);
    
    /**
     * @param gid
     */
    public int countByGid(Long gid);
}

/**
 * RemarkDaoImpl.java
 */
package com.uxiaoxi.ym.appserver.db.cluster.dao.impl;

import org.springframework.stereotype.Repository;

import com.uxiaoxi.ym.appserver.db.cluster.dao.IRemarkDao;
import com.uxiaoxi.ym.appserver.db.cluster.dto.Remark;
import com.uxiaoxi.ym.appserver.db.cluster.dto.RemarkExample;
import com.uxiaoxi.ym.appserver.db.cluster.mapper.RemarkMapper;
import com.uxiaoxi.ym.appserver.framework.db.impl.BaseSupport;

/**
 * @author renhao
 *
 *         2015年3月3日
 */
@Repository
public class RemarkDaoImpl extends BaseSupport<Remark, RemarkMapper>
        implements IRemarkDao {
    
    public Remark selectRemark(Long uid,Long uidobj){
        RemarkMapper mapper = this.getSqlSession().getMapper(RemarkMapper.class);
        
        RemarkExample example = new RemarkExample();
        example.createCriteria().andAccIdEqualTo(uid).andAccIdObjEqualTo(uidobj);

        return mapper.selectRemark(example);
    };
}

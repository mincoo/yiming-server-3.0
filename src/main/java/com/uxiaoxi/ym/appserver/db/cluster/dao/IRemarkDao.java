/**
 * IRemarkDao.java
 */
package com.uxiaoxi.ym.appserver.db.cluster.dao;

import com.uxiaoxi.ym.appserver.db.cluster.dto.Remark;
import com.uxiaoxi.ym.appserver.framework.db.IBaseSupport;

/**
 * @author renhao
 *
 *         2015年3月3日
 */
public interface IRemarkDao extends IBaseSupport<Remark> {
    
    public String selectRemark(Long uid,Long uidobj,Long gid);

}

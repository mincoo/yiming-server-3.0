/**
 * IGetTotalCount.java
 */
package com.uxiaoxi.ym.appserver.framework.page.database.dao;

import org.apache.ibatis.session.SqlSession;

/**
 * @author renh
 *
 * 2013-3-21
 */
public interface IGetTotalCount {

    /**
     * 获得分页数据的总记录数
     * 
     * @param strWay
     * @param strObject
     * @return
     * @throws Exception
     */
    int getTotalCount(String strWay, Object strObject, SqlSession sqlSession)
            throws Exception;

}

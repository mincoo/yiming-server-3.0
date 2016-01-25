/**
 * GetFirstSQLDao.java
 */
package com.uxiaoxi.ym.appserver.framework.page.database.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.uxiaoxi.ym.appserver.framework.page.database.dao.IGetTotalCount;
import com.uxiaoxi.ym.appserver.framework.page.model.SQLAdapter;
import com.uxiaoxi.ym.appserver.framework.page.mybatis.MySql5PageHepler;




/**
 * @author renh
 * 
 *         2013-3-21
 */
@Repository
public class GetTotalCountImpl implements
        IGetTotalCount {

    @Override
    public int getTotalCount(String strWay, Object strObject, SqlSession sqlSession) throws Exception {

        // souce sql
        String sql = sqlSession.getConfiguration().getMappedStatement(strWay)
                .getBoundSql(strObject).getSql();
        SQLAdapter sQLAdapter = new SQLAdapter();
        sQLAdapter.setSql(MySql5PageHepler.getCountString(sql));
        int count = sqlSession.selectOne("com.uxiaoxi.ym.appserver.framework.page.Page.getTotalCount", sQLAdapter);
        return count;

    }
}

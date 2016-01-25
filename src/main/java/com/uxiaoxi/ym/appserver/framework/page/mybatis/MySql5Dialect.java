/**
 * MySql5Dialect.java
 */
package com.uxiaoxi.ym.appserver.framework.page.mybatis;

import com.uxiaoxi.ym.appserver.framework.page.model.Dialect;

/**
 * @author renh
 *
 * 2013-3-21
 */
public class MySql5Dialect extends Dialect{
protected static final String SQL_END_DELIMITER = ";";

    public String getLimitString(String sql, int offset, int limit) {
        return MySql5PageHepler.getLimitString(sql, offset, limit);
    }

}

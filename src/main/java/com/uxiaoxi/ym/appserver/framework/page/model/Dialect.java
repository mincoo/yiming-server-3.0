/**
 * Dialect.java
 */
package com.uxiaoxi.ym.appserver.framework.page.model;

/**
 * @author zhaocm
 *
 * 2013-3-21
 */
public abstract class Dialect {
    public static enum Type{
        MYSQL,
        ORACLE
    }
    
    public abstract String getLimitString(String sql, int skipResults, int maxResults);
    
}
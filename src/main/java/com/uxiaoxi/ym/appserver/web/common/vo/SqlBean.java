/**
 * SqlBean.java
 */
package com.uxiaoxi.ym.appserver.web.common.vo;

/**
 * @author zhaocm
 *
 * 2013-4-19
 */
public class SqlBean {
    
    /**
     * where条件
     */
    private String condition;
    
    /**
     * 排序
     */
    private String orderby;

    public String getOrderby() {
        return orderby;
    }

    public void setOrderby(String orderby) {
        this.orderby = orderby;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    
}

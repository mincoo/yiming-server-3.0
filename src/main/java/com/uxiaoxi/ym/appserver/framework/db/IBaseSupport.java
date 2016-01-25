/**
 * IBaseSupport.java
 */
package com.uxiaoxi.ym.appserver.framework.db;

import com.uxiaoxi.ym.appserver.web.common.vo.ResultBean;

/**
 * @author renh
 *
 * 2014-3-24
 */
public interface IBaseSupport<T> {

    
    public ResultBean insert(T record);
    
    public ResultBean deleteByPrimaryKey(Long id);
    
    public ResultBean updateByPrimaryKey(T record);
    
    public ResultBean updateByPrimaryKeySelective(T record);
    
    public T selectByKey(Long id);
}

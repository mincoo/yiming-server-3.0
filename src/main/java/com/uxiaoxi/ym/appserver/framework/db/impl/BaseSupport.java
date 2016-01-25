/**
 * BaseSupport.java
 */
package com.uxiaoxi.ym.appserver.framework.db.impl;

import static org.springframework.util.Assert.notNull;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.support.DaoSupport;

import com.uxiaoxi.ym.appserver.framework.db.IBaseSupport;
import com.uxiaoxi.ym.appserver.framework.page.database.dao.IGetTotalCount;
import com.uxiaoxi.ym.appserver.framework.page.model.Page;
import com.uxiaoxi.ym.appserver.web.common.vo.ResultBean;



/**
 * 
 * T:entity K:mapper V:example
 * 
 * @author renh
 * 
 *         2014-3-21
 */
public class BaseSupport<T, K> extends DaoSupport implements IBaseSupport<T>{
    @Resource
    private IGetTotalCount getTotalCountImpl;

    @Resource(name = "sqlSession")
    private SqlSession sqlSession;

    private Class<T> entityClass;

    private Class<K> mapperClass;

    private static final Logger logger = LoggerFactory
            .getLogger(BaseSupport.class);

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public BaseSupport() {

        Type genType = getClass().getGenericSuperclass();
        if (genType instanceof ParameterizedType) {
            Type[] params = ((ParameterizedType) genType)
                    .getActualTypeArguments();
            entityClass = (Class) params[0];
            mapperClass = (Class) params[1];
        }

    }

    /**
     * 通过主键查询方法
     */
    @SuppressWarnings("unchecked")
    public T selectByKey(Long id) {
        T t = null;
        try {
            K mapper = sqlSession.getMapper(mapperClass);
            Method method = mapperClass.getMethod("selectByPrimaryKey",
                    Long.class);
            Object obj = method.invoke(mapper, id);
            if (obj != null) {
                t = (T) obj;
            }
        } catch (Exception e) {
            logger.error("BaseSupport insert method error!");
            e.printStackTrace();
        }
        return t;
    }

    /**
     * 增加一条数据
     * 
     * @param record
     * @return
     */
    public ResultBean insert(T record) {

        try {
            K mapper = sqlSession.getMapper(mapperClass);
            Method method = mapperClass.getMethod("insert", entityClass);
            method.invoke(mapper, record);

        } catch (Exception e) {
            logger.error("BaseSupport insert method error!");
            e.printStackTrace();
        }

        return getResultBean(1, "插入数据库成功");
    }

    /**
     * 删除一条数据
     * 
     * @param record
     * @return
     */
    public ResultBean deleteByPrimaryKey(Long id) {

        try {
            K mapper = sqlSession.getMapper(mapperClass);
            Method method = mapperClass.getMethod("deleteByPrimaryKey",
                    Long.class);
            method.invoke(mapper, id);

        } catch (Exception e) {
            logger.error("BaseSupport deleteByPrimaryKey method error!");
            e.printStackTrace();
        }

        return getResultBean(1, "删除数据成功");
    }

    /**
     * 更新一条数据
     * 
     * @param record
     * @return
     */
    public ResultBean updateByPrimaryKey(T record) {

        try {
            K mapper = sqlSession.getMapper(mapperClass);
            Method method = mapperClass.getMethod("updateByPrimaryKey",
                    entityClass);
            method.invoke(mapper, record);

        } catch (Exception e) {
            logger.error("BaseSupport updateByPrimaryKey method error!");
            e.printStackTrace();
        }

        return getResultBean(1, "更新数据成功");
    }


    /**
     * 更新一条数据
     * 
     * @param record
     * @return
     */
    public ResultBean updateByPrimaryKeySelective(T record){

        try {
            K mapper = sqlSession.getMapper(mapperClass);
            Method method = mapperClass.getMethod("updateByPrimaryKeySelective",entityClass);
            method.invoke(mapper, record);
            
        } catch (Exception e) {
            logger.error( "BaseSupport updateByPrimaryKeySelective method error!");
            e.printStackTrace();
        }
        
        return getResultBean(1,"更新数据成功");
    }

    /**
     * 
     * 
     * @param strWay
     *            sql
     * @param params
     *            变量
     * @param pageNO
     * @param pageSize
     * @return
     * @throws Exception
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public Page selectPage(String strWay, Object params, int pageNO,
            int pageSize) throws Exception {
        Page page = new Page();
        long totalSize = getTotalCountImpl.getTotalCount(strWay, params, this.getSqlSession());

        List list = this.getSqlSession().selectList(strWay, params,
                new RowBounds((pageNO - 1) * pageSize, pageSize));

        page.setParam(pageNO, pageSize, totalSize, list);
        return page;
    }

    /**
     * 
     * 构造一个类型为ResultBean的对象返回
     * 
     * @param code
     * @param msg
     * @return
     */
    public ResultBean getResultBean(int code, String msg) {
        ResultBean rb = new ResultBean();
        rb.setCode(code);
        rb.setMsg(msg);
        return rb;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void checkDaoConfig() {
        notNull(this.sqlSession,
                "Property 'sqlSessionFactory' or 'sqlSessionTemplate' are required");
    }

    public SqlSession getSqlSession() {
        return sqlSession;
    }

    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

}

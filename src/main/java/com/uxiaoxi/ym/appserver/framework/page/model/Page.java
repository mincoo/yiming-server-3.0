package com.uxiaoxi.ym.appserver.framework.page.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页对象. 包含当前页数据、当前页码、每页记录数等
 * 
 * @author renh
 */
public class Page<T> {

    private static int DEFAULT_PAGE_SIZE = 10;

    private int pageNO; // 当前页码

    private int pageSize = DEFAULT_PAGE_SIZE; // 每页的记录数

    private long totalCount; // 总记录数

    private List<T> data; // 当前页中存放的记录,类型一般为List

    /**
     * 构造方法，只构造空页.
     */
    public Page() {
        this(0, DEFAULT_PAGE_SIZE, 0, new ArrayList<T>());
    }

    /**
     * 
     * 构造方法
     * 
     * @param pageNO
     *            当前页码
     * @param pageSize
     *            每页的记录数
     * @param totalSize
     *            总记录数
     * @param data
     *            当前页存放的记录
     */
    public Page(int pageNO, int pageSize, long totalSize, List<T> data) {
        setParam(pageNO, pageSize, totalSize, data);
    }

    public void setParam(int pageNO, int pageSize, long totalSize, List<T> data) {
        this.pageNO = pageNO;
        this.pageSize = pageSize;
        this.totalCount = totalSize;
        this.data = data;
    }

    /**
     * 取总记录数.
     */
    public long getTotalCount() {
        return this.totalCount;
    }

    /**
     * 取总页数.
     */
    public long getTotalPageCount() {
        if (totalCount % pageSize == 0)
            return totalCount / pageSize;
        else
            return totalCount / pageSize + 1;
    }

    /**
     * 取每页数据容量.
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * 取当前页中的记录.
     */
    public Object getData() {
        return data;
    }

    /**
     * 取该页当前页码,页码从1开始.
     * 
     * @return
     */
    public int getPageNO() {
        return pageNO;
    }

    /**
     * 该页是否有下一页.
     */
    public boolean hasNextPage() {
        return this.getPageNO() < this.getTotalPageCount() - 1;
    }

    /**
     * 该页是否有上一页.
     */
    public boolean hasPreviousPage() {
        return this.getPageNO() > 1;
    }

    public void setPageNO(int pageNO) {
        this.pageNO = pageNO;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

}
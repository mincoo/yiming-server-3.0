/**
 * SearchResult.java
 */
package com.uxiaoxi.ym.appserver.web.common.vo;

import java.util.List;

/**
 * @author renhao
 *
 * 2015年3月10日
 */
public class ListResult<T> {

    /**
     * 最后一条记录的id
     */
    private Long last;
    
    /**
     * 列表大小
     */
    private Long size;
    
    /**
     * 列表
     */
    private List<T> list;

    /**
     * @return the last
     */
    public Long getLast() {
        return last;
    }

    /**
     * @param last the last to set
     */
    public void setLast(Long last) {
        this.last = last;
    }

    /**
     * @return the list
     */
    public List<T> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<T> list) {
        this.list = list;
    }

	/**
	 * @return the size
	 */
	public Long getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(Long size) {
		this.size = size;
	}

}

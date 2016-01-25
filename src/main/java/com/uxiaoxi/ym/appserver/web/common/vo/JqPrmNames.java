/**
 * JqPrmNames.java
 */
package com.uxiaoxi.ym.appserver.web.common.vo;

import org.apache.commons.lang.StringUtils;

import net.sf.json.JSONObject;

/**
 * @author renh
 *
 * 2013-4-17
 */
public class JqPrmNames {

    /**
     * 页码
     */
    private Integer page_no;
    
    /**
     * 记录数
     */
    private Integer page_size;
    
    /**
     * 排序的字段名
     */
    private String sidx;
    
    /**
     * 排序方式
     */
    private String sord;
    
    /**
     * 是否是查询
     */
    private Boolean search;
    
    /**
     * 随机数
     */
    private Long nd;
    
    private Long id;
    
    /**
     * 操作
     */
    private String oper;
    
    /**
     * 编辑操作
     */
    private String editoper;
    
    /**
     * 添加操作
     */
    private String addoper;
    
    /**
     * 删除操作
     */
    private String deloper;
    
    private Long totalrows;
    
    private String subgridid;
    
    /**
     * 查询条件
     */
    private String filters;

    /**
     * 返回whre条件
     * 
     * @return
     */
    public String getCondition() {
        if(StringUtils.isNotBlank(filters)) {
            JSONObject json = JSONObject.fromObject(filters);
            
            Filters f = (Filters)JSONObject.toBean(json,Filters.class);
            return  f.getCondition();
        } else {
            return "";
        }
    }
    
    public String getOrderBy(){
        return this.sidx + " " +this.sord;
    }

    public Integer getPage_no() {
        return page_no;
    }

    public void setPage_no(Integer page_no) {
        this.page_no = page_no;
    }

    public Integer getPage_size() {
        return page_size;
    }

    public void setPage_size(Integer page_size) {
        this.page_size = page_size;
    }

    public String getSidx() {
        return sidx;
    }

    public void setSidx(String sidx) {
        this.sidx = sidx;
    }

    public String getSord() {
        return sord;
    }

    public void setSord(String sord) {
        this.sord = sord;
    }

    public Long getNd() {
        return nd;
    }

    public void setNd(Long nd) {
        this.nd = nd;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOper() {
        return oper;
    }

    public void setOper(String oper) {
        this.oper = oper;
    }

    public String getEditoper() {
        return editoper;
    }

    public void setEditoper(String editoper) {
        this.editoper = editoper;
    }

    public String getAddoper() {
        return addoper;
    }

    public void setAddoper(String addoper) {
        this.addoper = addoper;
    }

    public String getDeloper() {
        return deloper;
    }

    public void setDeloper(String deloper) {
        this.deloper = deloper;
    }

    public Long getTotalrows() {
        return totalrows;
    }

    public void setTotalrows(Long totalrows) {
        this.totalrows = totalrows;
    }

    public String getSubgridid() {
        return subgridid;
    }

    public void setSubgridid(String subgridid) {
        this.subgridid = subgridid;
    }

    public String getFilters() {
        return filters;
    }

    public void setFilters(String filters) {
        this.filters = filters;
    }

    public Boolean getSearch() {
        return search;
    }

    public void setSearch(Boolean search) {
        this.search = search;
    }

    
    
}

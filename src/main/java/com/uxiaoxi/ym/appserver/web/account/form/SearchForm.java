/**
 * SearchForm.java
 */
package com.uxiaoxi.ym.appserver.web.account.form;

import javax.validation.constraints.NotNull;

/**
 * @author renhao
 *
 * 2015年3月10日
 */
public class SearchForm {

    
     /**
     * 名称
     */
    private String name;

     /**
     * 开始id
     */
    @NotNull
    private Long start;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the start
     */
    public Long getStart() {
        return start;
    }

    /**
     * @param start the start to set
     */
    public void setStart(Long start) {
        this.start = start;
    }
     
}

/**
 * Rule.java
 */
package com.uxiaoxi.ym.appserver.web.common.vo;

/**
 * @author renh
 *
 * 2013-4-17
 */
public class Rule {
    private String field;
    
    private String op;
    
    private String data ;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}

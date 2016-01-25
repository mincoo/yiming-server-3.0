/**
 * Jdata.java
 */
package com.uxiaoxi.ym.appserver.web.common.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author renh
 * 
 *         2013-4-15
 */
public class Jdata {

    private Long id;

    private String invdate;

    private String name;

    private Double amount;

    private Double tax;

    private Double total;

    private String notes;

    public List<String> toStringList() {
//        JqGridData data = new JqGridData();
//        data.setId(id);
        List<String> rows = new ArrayList<String>();
        rows.add(String.valueOf(id));
        rows.add(invdate);
        rows.add(name);
        rows.add(String.valueOf(amount));
        rows.add(String.valueOf(tax));
        rows.add(String.valueOf(total));
        rows.add(String.valueOf(notes));

//        data.setCell(rows);
        return rows;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInvdate() {
        return invdate;
    }

    public void setInvdate(String invdate) {
        this.invdate = invdate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}

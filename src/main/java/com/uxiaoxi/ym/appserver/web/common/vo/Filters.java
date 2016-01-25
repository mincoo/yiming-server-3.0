/**
 * Filters.java
 */
package com.uxiaoxi.ym.appserver.web.common.vo;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import net.sf.json.JSONObject;

/**
 * @author renh
 * 
 *         2013-4-17
 */
public class Filters {

    /**
     * the rules of the search. AND or OR.
     */
    private String groupOp;

    /**
     * an array with the following options
     */
    private List<Object> rules;
    /**
     * 
     */
    private String groups;

    public String getCondition() {

        StringBuffer conditionbf = new StringBuffer();
        for (int i=0;i<rules.size();i++) {
            Object obj= rules.get(i);
            
            Rule rule = (Rule) JSONObject.toBean(JSONObject.fromObject(obj),
                    Rule.class);
            if(StringUtils.isNotBlank(rule.getData()) || "nu".equals(rule.getOp()) || "nn".equals(rule.getOp())) {
                if(i == 0 || conditionbf.length() == 0 ) {
                    conditionbf.append(" AND ");
                } else {
                    conditionbf.append(" " + groupOp + " ");
                }
                conditionbf.append(getRule(rule));
            }
        }
        return conditionbf.toString();
    }

    public StringBuffer getRule(Rule rule) {

        StringBuffer ruleBf = new StringBuffer();

        // ['eq','ne','lt','le','gt','ge','bw','bn','in','ni','ew','en','cn','nc','nu','nn']
        switch (rule.getOp()) {
        case "eq":
            ruleBf.append(rule.getField());
            ruleBf.append(" = ");
            ruleBf.append("'");
            ruleBf.append(rule.getData());
            ruleBf.append("'");
            break;
        case "ne":
            ruleBf.append(rule.getField());
            ruleBf.append(" <> ");
            ruleBf.append("'");
            ruleBf.append(rule.getData());
            ruleBf.append("'");
            break;
        case "lt":
            ruleBf.append(rule.getField());
            ruleBf.append(" < ");
            ruleBf.append("'");
            ruleBf.append(rule.getData());
            ruleBf.append("'");
            break;
        case "le":
            ruleBf.append(rule.getField());
            ruleBf.append(" <= ");
            ruleBf.append("'");
            ruleBf.append(rule.getData());
            ruleBf.append("'");
            break;
        case "gt":
            ruleBf.append(rule.getField());
            ruleBf.append(" > ");
            ruleBf.append("'");
            ruleBf.append(rule.getData());
            ruleBf.append("'");
            break;
        case "ge":
            ruleBf.append(rule.getField());
            ruleBf.append(" >= ");
            ruleBf.append("'");
            ruleBf.append(rule.getData());
            ruleBf.append("'");
            break;
        case "bw":
            ruleBf.append(rule.getField());
            ruleBf.append(" like '");
            ruleBf.append(rule.getData());
            ruleBf.append("%'");
            break;
        case "bn":
            ruleBf.append(rule.getField());
            ruleBf.append(" not like '");
            ruleBf.append(rule.getData());
            ruleBf.append("%'");
            break;
        case "in":
            ruleBf.append(rule.getField());
            ruleBf.append(" in (");
            String strIndata= rule.getData();
            strIndata = strIndata.replaceAll("，", ",");
            String [] indata = strIndata.split(",");
            for(int i=0;i<indata.length;i++){
                ruleBf.append("'");
                ruleBf.append(indata[i]);
                ruleBf.append("'");
                if(i<indata.length-1) {
                    ruleBf.append(",");
                }
            }
            
            ruleBf.append(")");
            break;
        case "ni":
            ruleBf.append(rule.getField());
            ruleBf.append(" not in (");
            String strNidata= rule.getData();
            strIndata = strNidata.replaceAll("，", ",");
            String [] nidata = strNidata.split(",");
            for(int i=0;i<nidata.length;i++){
                ruleBf.append("'");
                ruleBf.append(nidata[i]);
                ruleBf.append("'");
                if(i<nidata.length-1) {
                    ruleBf.append(",");
                }
            }
            ruleBf.append(")");
            break;
        case "ew":
            ruleBf.append(rule.getField());
            ruleBf.append(" like '%");
            ruleBf.append(rule.getData());
            ruleBf.append("'");
            break;
        case "en":
            ruleBf.append(rule.getField());
            ruleBf.append(" not like '%");
            ruleBf.append(rule.getData());
            ruleBf.append("'");
            break;
        case "nu":
            ruleBf.append(rule.getField());
            ruleBf.append(" is null ");
            break;
        case "nn":
            ruleBf.append(rule.getField());
            ruleBf.append(" is not null ");
            break;
        case "cn":
            ruleBf.append(rule.getField());
            ruleBf.append(" like '%");
            ruleBf.append(rule.getData());
            ruleBf.append("%'");
            break;
        case "nc":
            ruleBf.append(rule.getField());
            ruleBf.append(" not like '%");
            ruleBf.append(rule.getData());
            ruleBf.append("%'");
            break;
        }

        return ruleBf;
    }

    public String getGroupOp() {
        return groupOp;
    }

    public void setGroupOp(String groupOp) {
        this.groupOp = groupOp;
    }

    public String getGroups() {
        return groups;
    }

    public void setGroups(String groups) {
        this.groups = groups;
    }

    public List<Object> getRules() {
        return rules;
    }

    public void setRules(List<Object> rules) {
        this.rules = rules;
    }
}


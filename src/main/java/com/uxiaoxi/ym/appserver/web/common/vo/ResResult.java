/**
 * ResResult.java
 */
package com.uxiaoxi.ym.appserver.web.common.vo;

import net.sf.json.JSONObject;

/**
 * @author renh
 *
 * 2014-5-14
 */
public class ResResult {
    
    private Object data;
    
    private int status;
    
    private String msg;
    
    public ResResult(){};
    
    public ResResult(Object data){
        this.status = StatusConst.SUCCESS;
        this.msg = StatusConst.STRSUCCESS;
        this.data = data;
        
    };
    
    public ResResult(int status,String msg,Object data){
        this.status = status;
        this.msg = msg;
        this.data = data;
    };

    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * @param msg the msg to set
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String toString(){
        JSONObject json = JSONObject.fromObject(this);
        return json.toString();
    }

    /**
     * @return the data
     */
    public Object getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Object data) {
        this.data = data;
    }




}

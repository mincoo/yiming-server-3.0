/**
 * AccountVO.java
 */
package com.uxiaoxi.ym.appserver.web.account.vo;

import com.uxiaoxi.ym.appserver.db.account.dto.Account;

/**
 * @author renhao
 *
 * 2015年3月9日
 */
public class AccountVO {

    private Integer uid;
    
    private String phone;
    
    private Integer type;
    
    private String name;
    
    private String face;
    
    private String token;
    
    public AccountVO() {
        
    }
    
    public AccountVO(Account account) {
        this.uid = account.getId().intValue();
        this.phone = account.getPhone();
        this.type = account.getType();
        this.name = account.getName();
        this.face = account.getFace();
        this.token = account.getToken();
    }
    
    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the type
     */
    public Integer getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(Integer type) {
        this.type = type;
    }

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
     * @return the face
     */
    public String getFace() {
        return face;
    }

    /**
     * @param face the face to set
     */
    public void setFace(String face) {
        this.face = face;
    }

    /**
     * @return the token
     */
    public String getToken() {
        return token;
    }

    /**
     * @param token the token to set
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * @return the uid
     */
    public Integer getUid() {
        return uid;
    }

    /**
     * @param uid the uid to set
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }
    
    /**
     * 转化为Account
     * 
     * @return00000.
     * 
     * 
     */
    public Account toAccount(){
        
        Account account = new Account();
        account.setId(Long.valueOf(this.uid));
        account.setPhone(this.phone);
        account.setType(this.type);
        account.setName(this.name);
        account.setFace(this.face);
        account.setToken(this.token);
        return account;
    }
    
}

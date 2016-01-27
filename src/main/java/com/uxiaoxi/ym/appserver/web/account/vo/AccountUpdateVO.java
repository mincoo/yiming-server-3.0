/**
 * AccountUpdateVO.java
 */
package com.uxiaoxi.ym.appserver.web.account.vo;

import com.uxiaoxi.ym.appserver.db.account.dto.Account;

/**
 * @author renhao
 *
 * 2015年3月9日
 */
public class AccountUpdateVO {

    private Long uid;
    
    private String phone;
    
    private String name;
    
    private String face;
    
    private Integer sex;
    
   

	/**
     * @return the uid
     */
    public Long getUid() {
        return uid;
    }

    /**
     * @param uid the uid to set
     */
    public void setUid(Long uid) {
        this.uid = uid;
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
     * @return the sex
     */

    public Integer getSex() {
		return sex;
	}
    /**
     * @param uid the sex to set
     */
	public void setSex(Integer sex) {
		this.sex = sex;
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
        account.setName(this.name);
        account.setFace(this.face);
        account.setSex(this.sex);
        return account;
    }
    
}

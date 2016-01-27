/**
 * SearchByPhoneForm.java
 */
package com.uxiaoxi.ym.appserver.web.account.form;

/**
 * @author renhao
 *
 * 2015年3月10日
 */
public class SearchByPhoneForm {

    /**
    * 用户ID
    */
   private Long uid;
   
   /**
   * 用户类型
   */
   private Integer type;
   
     /**
     * 手机
     */
    private String phone;

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


     
}

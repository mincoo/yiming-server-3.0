/**
 * RegisterForm.java
 */
package com.uxiaoxi.ym.appserver.web.account.form;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author renhao
 *
 * 2015年3月9日
 */
public class RegisterForm {

    
    /**
     * 电话
     */
    @NotBlank(message = "请输入手机号")
    @Pattern(regexp = "^1\\d{10}$", message = "不是有效的手机号") 
    private String phone;
    
    /**
     * 用户类型
     *  1 教师（需要后台审核）
     *  2 学生
     */
    @NotNull(message = "请选择用户类型")
    private Integer type;
    
    /**
     * 昵称
     */
    @NotNull(message = "请输入昵称")
    private String name;
    
    /**
     * 密码
     */
    @Length(min=6, max=20, message="密码长度必须在6-20之间")
    private String passwd;
    
    /**
     * 验证码
     */
    @NotNull(message = "请输入验证码")
    @Digits(message = "验证码错误", integer=6, fraction=0)
    private Integer vcode;
    

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
     * @return the passwd
     */
    public String getPasswd() {
        return passwd;
    }

    /**
     * @param passwd the passwd to set
     */
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    /**
     * @return the vcode
     */
    public Integer getVcode() {
        return vcode;
    }

    /**
     * @param vcode the vcode to set
     */
    public void setVcode(Integer vcode) {
        this.vcode = vcode;
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


}

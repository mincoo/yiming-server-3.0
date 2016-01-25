/**
 * SexEnum.java
 */
package com.uxiaoxi.ym.jpush;

import com.uxiaoxi.ym.appserver.framework.util.JavaEnumUtils;

/**
 * @author renh
 * 
 *         2013-5-17
 */
public enum PushTypeEnum {

    TAG(1, "tag"),

    ALIAS(2, "alias");

    /**
     * 构造函数
     * 
     * @param code
     *            编码
     * @param description
     *            说明
     */
    private PushTypeEnum(int code, String description) {
        this.code = code;
        this.description = description;
        JavaEnumUtils.put(this.getClass().getName() + code, this);
    }

    /**
     * <pre>
     * 一个便利的方法，方便使用者通过code获得枚举对象，
     * 对于非法状态，以个人处理&lt;/b&gt;
     * </pre>
     * 
     * @param code
     * @return
     */
    public static PushTypeEnum valueOf(int code) {
        Object obj = JavaEnumUtils.get(PushTypeEnum.class.getName() + code);
        if (null != obj) {
            return (PushTypeEnum) obj;
        }
        return TAG;
    }

    /** 编码 */
    private int code;

    /** 描述的KEY */
    private String description;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}

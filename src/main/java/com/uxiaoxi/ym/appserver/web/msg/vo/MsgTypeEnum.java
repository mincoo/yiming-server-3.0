/**
 * SexEnum.java
 */
package com.uxiaoxi.ym.appserver.web.msg.vo;

import com.uxiaoxi.ym.appserver.framework.util.JavaEnumUtils;

/**
 * @author renh
 * 
 *         2013-5-17
 */
public enum MsgTypeEnum {

    TXT(1, "文本"),

    URL(2, "链接");

    /**
     * 构造函数
     * 
     * @param code
     *            编码
     * @param description
     *            说明
     */
    private MsgTypeEnum(int code, String description) {
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
    public static MsgTypeEnum valueOf(int code) {
        Object obj = JavaEnumUtils.get(MsgTypeEnum.class.getName() + code);
        if (null != obj) {
            return (MsgTypeEnum) obj;
        }
        return TXT;
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

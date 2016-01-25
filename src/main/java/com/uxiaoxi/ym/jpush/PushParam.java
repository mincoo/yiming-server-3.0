/**
 * PushParam.java
 */
package com.uxiaoxi.ym.jpush;

/**
 * @author renhao
 *
 * 2015年3月12日
 */
public class PushParam {

    /**
     * 标签
     */
    private String tag;
    
    /**
     * 别名
     */
    private String alias;
    
    /**
     * 推送类型
     */
    private PushTypeEnum typeEnum;
  
    /**
     * 消息内容
     */
    private String content;
    
    /**
     * 消息id
     */
    private Long mid; 
    
    /**
     * 消息类型
     */
    private Integer type;
    
    /**
     * url
     */
    private String url;
    
    /**
     * 组名称
     */
    private String gname;
    
    /**
     * 用户名
     */
    private String uname;

    /**
     * @return the tag
     */
    public String getTag() {
        return tag;
    }

    /**
     * @param tag the tag to set
     */
    public void setTag(String tag) {
        this.tag = tag;
    }

    /**
     * @return the alias
     */
    public String getAlias() {
        return alias;
    }

    /**
     * @param alias the alias to set
     */
    public void setAlias(String alias) {
        this.alias = alias;
    }

    /**
     * @return the typeEnum
     */
    public PushTypeEnum getTypeEnum() {
        return typeEnum;
    }

    /**
     * @param typeEnum the typeEnum to set
     */
    public void setTypeEnum(PushTypeEnum typeEnum) {
        this.typeEnum = typeEnum;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return the mid
     */
    public Long getMid() {
        return mid;
    }

    /**
     * @param mid the mid to set
     */
    public void setMid(Long mid) {
        this.mid = mid;
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
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return the gname
     */
    public String getGname() {
        return gname;
    }

    /**
     * @param gname the gname to set
     */
    public void setGname(String gname) {
        this.gname = gname;
    }

    /**
     * @return the uname
     */
    public String getUname() {
        return uname;
    }

    /**
     * @param uname the uname to set
     */
    public void setUname(String uname) {
        this.uname = uname;
    }
    
}

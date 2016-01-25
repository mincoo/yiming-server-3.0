/**
 * VersionVO.java
 */
package com.uxiaoxi.ym.appserver.web.version.vo;

import java.text.SimpleDateFormat;

import com.uxiaoxi.ym.appserver.db.version.dto.VersionMng;

/**
 * @author renhao
 *
 * 2015年3月27日
 */
public class VersionVO {

    private String version;
    
    private String name;
    
    private String url;
    
    private Integer ostype;
    
    private String date;

    public VersionVO(){}
    
    public VersionVO(VersionMng vmg){
        this.version = vmg.getVersion();
        this.name = vmg.getVersionName();
        this.url = vmg.getUrl();
        this.ostype = vmg.getOsType();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        this.date = dateFormat.format(vmg.getCreateDt());
    }
    
    /**
     * @return the version
     */
    public String getVersion() {
        return version;
    }

    /**
     * @param version the version to set
     */
    public void setVersion(String version) {
        this.version = version;
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
     * @return the ostype
     */
    public Integer getOstype() {
        return ostype;
    }

    /**
     * @param ostype the ostype to set
     */
    public void setOstype(Integer ostype) {
        this.ostype = ostype;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }
    
    
}

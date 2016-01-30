/**
 * ClusterVO.java
 */
package com.uxiaoxi.ym.appserver.web.cluster.vo;

import java.io.Serializable;
import java.text.SimpleDateFormat;

import com.uxiaoxi.ym.appserver.db.cluster.dto.Cluster;

/**
 * @author renhao
 *
 * 2015年3月10日
 */
public class ClusterVO implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = -6800902660399537088L;

    private Long gid;
    
    private Long uid;
    
    private String sn;
    
    private String name;
    
    private String province;
    
    private String city;
    
    private String district;
    
    private String school;
    
    private String createDt;
    
    private String face;
    
    public ClusterVO(){
        
    }
    /**
     * @param clu
     */
    public ClusterVO(Cluster clu) {
        this.gid = clu.getId();
        this.uid = clu.getCreateBy();
        this.sn = clu.getSn();
        this.name = clu.getTitle();
        this.school = clu.getSchool();
        this.province = clu.getProvince();
        this.city = clu.getCity();
        this.face = clu.getFace();
        this.district = clu.getDistrict();
        if(clu.getCreateDt()!=null){
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	        this.setCreateDt(dateFormat.format(clu.getCreateDt()));
        }
    }

    /**
     * @return the gid
     */
    public Long getGid() {
        return gid;
    }

    /**
     * @param gid the gid to set
     */
    public void setGid(Long gid) {
        this.gid = gid;
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
	 * @return the school
	 */
	public String getSchool() {
		return school;
	}
	/**
	 * @param school the school to set
	 */
	public void setSchool(String school) {
		this.school = school;
	}
	/**
	 * @return the province
	 */
	public String getProvince() {
		return province;
	}
	/**
	 * @param province the province to set
	 */
	public void setProvince(String province) {
		this.province = province;
	}
	/**
	 * @return the createDt
	 */
	public String getCreateDt() {
		return createDt;
	}
	/**
	 * @param createDt the createDt to set
	 */
	public void setCreateDt(String createDt) {
		this.createDt = createDt;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the district
	 */
	public String getDistrict() {
		return district;
	}
	/**
	 * @param district the district to set
	 */
	public void setDistrict(String district) {
		this.district = district;
	}
	/**
	 * @return the sn
	 */
	public String getSn() {
		return sn;
	}
	/**
	 * @param sn the sn to set
	 */
	public void setSn(String sn) {
		this.sn = sn;
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
}

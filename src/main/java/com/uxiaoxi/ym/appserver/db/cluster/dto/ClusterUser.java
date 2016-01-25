package com.uxiaoxi.ym.appserver.db.cluster.dto;

import java.util.Date;

public class ClusterUser {
    private Long id;

	private Long accId;

	private Long cluId;

	private String accName;

	private Date createDt;

	private Long jpushFlg;

	private Integer accType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAccId() {
		return accId;
	}

	public void setAccId(Long accId) {
		this.accId = accId;
	}

	public Long getCluId() {
		return cluId;
	}

	public void setCluId(Long cluId) {
		this.cluId = cluId;
	}

	public String getAccName() {
		return accName;
	}

	public void setAccName(String accName) {
		this.accName = accName == null ? null : accName.trim();
	}

	public Date getCreateDt() {
		return createDt;
	}

	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}

	public Long getJpushFlg() {
		return jpushFlg;
	}

	public void setJpushFlg(Long jpushFlg) {
		this.jpushFlg = jpushFlg;
	}

	public Integer getAccType() {
		return accType;
	}

	public void setAccType(Integer accType) {
		this.accType = accType;
	}
}
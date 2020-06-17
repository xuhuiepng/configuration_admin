/**  
 * Project Name		D3  
 * File Name		SysmListOrg.java  
 * Package Name		cn.secure.entity
 * Date				2018年6月1日下午17:58:41  
 * Copyright (c) 2018, cert@cnic.cn All Rights Reserved.  
 *  
 */
package cn.cnic.security.configuration.entity;

import java.util.Date;


/**
 * @Description	研究院信息表
 * @ClassName	SysmListOrg
 * @author		ygc
 * @date		2018年6月1日 下午6:00:52
 * @version		V1.0
 * @since		JDK 1.8
 */
public class SysmListOrg {

	/**
	 * 研究院id
	 */
	private Integer orgId;
	/**
	 * 分院/研究所id
	 */
	private Integer orgParentId;
	/**
	 * 分院/研究所名称
	 */
	private String orgName;
	/**
	 * 简称
	 */
	private String abbreviation;
	/**
	 * 地图坐标-经度
	 */
	private String longitude;
	/**
	 * 地图坐标-纬度
	 */
	private String latitude;
	/**
	 * ip网段(安全域)
	 */
	private String ipScope;
	/**
	 * 所属父类id
	 */
	private Integer parentId;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 创建者
	 */
	private String createUser;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 修改者
	 */
	private String updateUser;
	/**
	 * 修改时间
	 */
	private Date updateTime;
	/**
	 * 修改时间
	 */
	private Date updated;

	public Integer getOrgId() {
		return orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getIpScope() {
		return ipScope;
	}

	public void setIpScope(String ipScope) {
		this.ipScope = ipScope;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public Integer getOrgParentId() {
		return orgParentId;
	}

	public void setOrgParentId(Integer orgParentId) {
		this.orgParentId = orgParentId;
	}
	

}

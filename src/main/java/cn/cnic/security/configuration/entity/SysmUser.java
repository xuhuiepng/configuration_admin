/**  
 * Project Name		D3  
 * File Name		SysmUser.java  
 * Package Name		cn.secure.entity
 * Date				2018年6月1日下午17:58:41  
 * Copyright (c) 2018, cert@cnic.cn All Rights Reserved.  
 *  
 */
package cn.cnic.security.configuration.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.stereotype.Component;
/**
 * @Description	用户表
 * @ClassName	SysmUser
 * @author		ygc
 * @date		2018年6月1日 下午6:03:35
 * @version		V1.0
 * @since		JDK 1.8
 */
@Component
public class SysmUser implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 用户id
	 */
	private Integer userId;
	/**
	 * 用户名
	 */
	private String userName;
	/**
	 * 角色
	 */
	private Integer roleId;
	/**
	 * 单位id
	 */
	private Integer orgId;
	/**
	 * 分院id orgParentId
	 */
	private Integer orgParentId;
	/**
	 * 单位名
	 */
	private String orgName;
	/**
	 * 认证令牌
	 */
	private String accessToken;
	/**
	 * 刷新令牌
	 */
	private String refreshToken;
	/**
	 * 联系人
	 */
	private String contacts;
	/**
	 * 电话
	 */
	private String phone;
	/**
	 * 通报方式(0:邮箱;1:电话)
	 */
	private Integer sendMethod;
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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getOrgId() {
		return orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}
	
	public Integer getOrgParentId() {
		return orgParentId;
	}

	public void setOrgParentId(Integer orgParentId) {
		this.orgParentId = orgParentId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public String getContacts() {
		return contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getSendMethod() {
		return sendMethod;
	}

	public void setSendMethod(Integer sendMethod) {
		this.sendMethod = sendMethod;
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

}

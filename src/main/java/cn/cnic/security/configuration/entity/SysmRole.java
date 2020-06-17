/**  
 * Project Name		D3  
 * File Name		SysmRole.java  
 * Package Name		cn.secure.entity
 * Date				2018年6月1日下午17:58:41  
 * Copyright (c) 2018, cert@cnic.cn All Rights Reserved.  
 *  
 */
package cn.cnic.security.configuration.entity;

import java.util.Date;


/**
 * @Description	角色表
 * @ClassName	SysmRole
 * @author		ygc
 * @date		2018年6月1日 下午6:03:07
 * @version		V1.0
 * @since		JDK 1.8
 */
public class SysmRole {

	private static final long serialVersionUID = 1L;
	/**
	 * 角色id
	 */
	private Integer roleId;
	/**
	 * 角色名
	 */
	private String roleName;
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

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
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

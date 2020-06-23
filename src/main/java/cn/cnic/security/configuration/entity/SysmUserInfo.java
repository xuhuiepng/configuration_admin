/**  
 * Project Name		D3  
 * File Name		SysmUserInfo.java  
 * Package Name		cn.secure.entity
 * Date				2018年6月1日下午17:58:41  
 * Copyright (c) 2018, cert@cnic.cn All Rights Reserved.  
 *  
 */
package cn.cnic.security.configuration.entity;


/**
 * @Description	登陆用户信息_bean
 * @ClassName	SysmUserInfo
 * @author		ygc
 * @date		2018年6月1日 下午6:04:53
 * @version		V1.0
 * @since		JDK 1.8
 */
public class SysmUserInfo  {
	/**
	 * 系统用户
	 */
	private UserEntity sysmUser;
	/**
	 * 系统权限
	 */
	private SysmRole sysmRole;
	/**
	 * 系统列表机构
	 */
	private SysmListOrg sysmListOrg;

	public UserEntity getSysmUser() {
		return sysmUser;
	}

	public void setSysmUser(UserEntity sysmUser) {
		this.sysmUser = sysmUser;
	}

	public SysmRole getSysmRole() {
		return sysmRole;
	}

	public void setSysmRole(SysmRole sysmRole) {
		this.sysmRole = sysmRole;
	}

	public SysmListOrg getSysmListOrg() {
		return sysmListOrg;
	}

	public void setSysmListOrg(SysmListOrg sysmListOrg) {
		this.sysmListOrg = sysmListOrg;
	}

}

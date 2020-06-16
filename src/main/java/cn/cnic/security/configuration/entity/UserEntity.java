package cn.cnic.security.configuration.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 用户表
 * 
 * @author xuhuipeng
 * @email xuhuipeng@cnic.com
 * @date 2020-06-04 14:41:02
 */
@Data
@TableName("ca_user")
public class UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(value = "user_id", type = IdType.AUTO)
	private Integer userId;
	/**
	 * 
	 */
	private String userName;
	/**
	 * 
	 */
	private Integer roleId;
	/**
	 * 
	 */
	private Integer orgId;
	/**
	 * 
	 */
	private Integer orgParentId;
	/**
	 * 联系人
	 */
	private String contacts;
	/**
	 * 手机
	 */
	private String phone;
	/**
	 * 
	 */
	private String remark;
	/**
	 * 更新/修改账号
	 */
	private String updateUser;
	/**
	 * 更新时间
	 */
	private Date updateTime;
	/**
	 * 最后登录ip
	 */
	private String lastIp;
	/**
	 * 最后登录时间
	 */
	private Date lastTime;
	/**
	 * 登录次数
	 */
	private Integer loginNumber;
	/**
	 * 认证次数
	 */
	private Integer authenticationNumber;
	/**
	 * 本地密码
	 */
	private String localPassword;
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
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
	public String getLastIp() {
		return lastIp;
	}
	public void setLastIp(String lastIp) {
		this.lastIp = lastIp;
	}
	public Date getLastTime() {
		return lastTime;
	}
	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}
	public Integer getLoginNumber() {
		return loginNumber;
	}
	public void setLoginNumber(Integer loginNumber) {
		this.loginNumber = loginNumber;
	}
	public Integer getAuthenticationNumber() {
		return authenticationNumber;
	}
	public void setAuthenticationNumber(Integer authenticationNumber) {
		this.authenticationNumber = authenticationNumber;
	}
	public String getLocalPassword() {
		return localPassword;
	}
	public void setLocalPassword(String localPassword) {
		this.localPassword = localPassword;
	}

}

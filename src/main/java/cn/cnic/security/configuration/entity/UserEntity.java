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
	

}

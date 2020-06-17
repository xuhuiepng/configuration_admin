package cn.cnic.security.configuration.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author xuhuipeng
 * @email xuhuipeng@cnic.com
 * @date 2020-06-09 09:59:33
 */
@Data
@TableName("app_authentication")
public class AppAuthenticationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 认证令牌
	 */
	@TableId(type = IdType.NONE)
	private String appToken;
	/**
	 * 名称
	 */
	private String appName;
	/**
	 * 绑定ip
	 */
	private String bingIp;

	/**
	 * 项目名
	 */
	private String projectName;
	/**
	 * 域名
	 */
	private String domain;
	/**
	 * 
	 */
	private String updateTime;
	/**
	 * 应用向科技云认证的次数
	 */
	private Integer num;
	/**
	 * 应用的key
	 */
	private Integer clientId;
	/**
	 * 密钥
	 */
	private String clientSecret;
	/**
	 * 应用回调地址
	 */
	private String redirectUri;
	/**
	 * 认证服务器地址
	 */
	private String accessTokenUrl;
	/**
	 * 接入应该的主题
	 */
	private String theme;
	/**
	 * 逻辑删除
	 */
	private Integer isDel;

}

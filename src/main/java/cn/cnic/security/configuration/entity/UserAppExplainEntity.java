package cn.cnic.security.configuration.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import lombok.Data;

/**
 * 用户与系统关系表
 * 
 * @author xuhuipeng
 * @email xuhuipeng@cnic.com
 * @date 2020-06-17 14:01:39
 */
@Data
@TableName("ca_user_app_explain")
public class UserAppExplainEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer cId;
	/**
	 * 
	 */
	private Integer userId;
	/**
	 * 
	 */
	private Integer clientId;
	/**
	 * 停用
	 */
	private Enum deactivation;

}

package cn.cnic.security.configuration.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 中科院研究所列表
 * 
 * @author xuhuipeng
 * @email xuhuipeng@cnic.com
 * @date 2020-06-04 14:41:02
 */
@Data
@TableName("ca_institutions_list")
public class InstitutionsListEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(type= IdType.AUTO)
	private Integer id;
	/**
	 * 研究所名称
	 */
	private String orgName;
	/**
	 * 简称
	 */
	private String abbreviation;
	/**
	 * 
	 */
	private String longitude;
	/**
	 * 
	 */
	private String latitude;
	/**
	 * 
	 */
	private String ipScope;
	/**
	 * 
	 */
	private String code;
	/**
	 * 
	 */
	private Integer parentId;
	/**
	 * 
	 */
	private String remark;
	/**
	 * 
	 */
	private Date createTime;
	/**
	 * 
	 */
	private Date updated;

}

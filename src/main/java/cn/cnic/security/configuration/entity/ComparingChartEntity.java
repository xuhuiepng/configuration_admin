package cn.cnic.security.configuration.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 邮箱后缀-研究所-坐标的映射
 * 
 * @author xuhuipeng
 * @email xuhuipeng@cnic.com
 * @date 2020-06-04 14:41:02
 */
@Data
@TableName("comparing_chart")
public class ComparingChartEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 邮箱后缀
	 */
	private String suffix;
	/**
	 * 简称
	 */
	private String abbreviation;
	/**
	 * 单位全名
	 */
	private String fullname;
	/**
	 * 坐标
	 */
	private Double latitude;
	/**
	 * 坐标
	 */
	private Double longitude;
	/**
	 * 所属研究院
	 */
	private String belongTo;

}

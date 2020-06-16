package cn.cnic.security.configuration.dao;

import cn.cnic.security.configuration.entity.ComparingChartEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 邮箱后缀-研究所-坐标的映射
 * 
 * @author xuhuipeng
 * @email xuhuipeng@cnic.com
 * @date 2020-06-04 14:41:02
 */
@Mapper
public interface ComparingChartDao extends BaseMapper<ComparingChartEntity> {
	
}

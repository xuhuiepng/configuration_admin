package cn.cnic.security.configuration.dao;

import cn.cnic.security.configuration.entity.UserAppExplainEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户与系统关系表
 * 
 * @author xuhuipeng
 * @email xuhuipeng@cnic.com
 * @date 2020-06-17 14:01:39
 */
@Mapper
public interface UserAppExplainDao extends BaseMapper<UserAppExplainEntity> {
	
}
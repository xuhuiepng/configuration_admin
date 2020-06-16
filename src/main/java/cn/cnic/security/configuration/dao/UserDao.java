package cn.cnic.security.configuration.dao;

import cn.cnic.security.configuration.entity.UserEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户表
 * 
 * @author xuhuipeng
 * @email xuhuipeng@cnic.com
 * @date 2020-06-04 14:41:02
 */
@Mapper
public interface UserDao extends BaseMapper<UserEntity> {
	
}

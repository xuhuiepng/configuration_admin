package cn.cnic.security.configuration.dao;

import cn.cnic.security.configuration.entity.UserAppExplainEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 用户与系统关系表
 * 
 * @author xuhuipeng
 * @email xuhuipeng@cnic.com
 * @date 2020-06-17 14:01:39
 */
@Mapper
@Repository
public interface UserAppExplainDao extends BaseMapper<UserAppExplainEntity> {
	Integer activate(@Param("userId") Integer userId,
                     @Param("clientId") Integer clientId);
}

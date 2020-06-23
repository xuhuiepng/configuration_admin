package cn.cnic.security.configuration.dao;

import cn.cnic.security.configuration.entity.SysmUserInfo;
import cn.cnic.security.configuration.entity.UserEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 用户表
 * 
 * @author xuhuipeng
 * @email xuhuipeng@cnic.com
 * @date 2020-06-04 14:41:02
 */
@Mapper
@Repository
public interface UserDao extends BaseMapper<UserEntity> {
    //授权用的查找
    SysmUserInfo findSysmUserInfo(String username);
}

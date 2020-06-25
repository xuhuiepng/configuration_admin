package cn.cnic.security.configuration.dao;

import cn.cnic.security.configuration.entity.SysmUserInfo;
import cn.cnic.security.configuration.entity.UserEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author wq
 * @email 1013893214@qq.com
 * @date 2020-06-24 15:39
 */
@Mapper
@Repository
public interface AuthorizationDao extends BaseMapper<UserEntity> {
    //认证方法
    SysmUserInfo findDeactivation(Integer appKey, String emailAccount);
}

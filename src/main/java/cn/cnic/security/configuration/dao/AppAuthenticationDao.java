package cn.cnic.security.configuration.dao;


import cn.cnic.security.configuration.entity.AppAuthenticationEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 *
 * @author xuhuipeng
 * @email xuhuipeng@cnic.com
 * @date 2020-06-09 09:59:33
 */
@Mapper
@Repository
public interface AppAuthenticationDao extends BaseMapper<AppAuthenticationEntity> {

    int logicDelete(@Param("token") String token);

    int getUserApp(@Param("token") String token);

    int deactivateUserApp(@Param("token") String token);

}


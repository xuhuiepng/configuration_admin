package cn.cnic.security.configuration.dao;

import cn.cnic.security.configuration.entity.UserAppListEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserAppListDao {

    List<UserAppListEntity> selectAppListPage(@Param("minPage")Integer minPage,
                                              @Param("pageSize") Integer pageSize);

    List<UserAppListEntity> selectAppListPageByUserName(@Param("minPage")Integer minPage,
                                                        @Param("pageSize") Integer pageSize,
                                                        @Param("userName") String userName);

    Integer logicDelete(@Param("userId") Integer userId,
                     @Param("clientId") Integer clientId);

}

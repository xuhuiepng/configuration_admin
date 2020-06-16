package cn.cnic.security.configuration.dao;

import cn.cnic.security.configuration.entity.AppListEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AppListDao {

    List<AppListEntity> selectAppListPage(@Param("minPage")Integer minPage,
                                          @Param("pageSize") Integer pageSize);

    List<AppListEntity> selectAppListPageByUserName(@Param("minPage")Integer minPage,
                                                    @Param("pageSize") Integer pageSize,
                                                    @Param("userName") String userName);

}

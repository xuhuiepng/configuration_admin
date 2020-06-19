package cn.cnic.security.configuration.service;

import cn.cnic.security.configuration.entity.UserAppListEntity;

import java.util.List;

public interface UserAppListService {
    List<UserAppListEntity> queryAppListPage(Integer pageSize, Integer currPage);

    List<UserAppListEntity> queryAppListPageByUserName(Integer pageSize, Integer currPage, String userName);

    Integer LogicDelete(Integer userId,Integer clientId);
}

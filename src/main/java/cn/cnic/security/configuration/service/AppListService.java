package cn.cnic.security.configuration.service;

import cn.cnic.security.configuration.entity.AppListEntity;

import java.util.List;

public interface AppListService {
    List<AppListEntity> queryAppListPage(Integer pageSize,Integer currPage);

    List<AppListEntity> queryAppListPageByUserName(Integer pageSize,Integer currPage,String userName);
}

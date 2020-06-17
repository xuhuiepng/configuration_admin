package cn.cnic.security.configuration.service.impl;

import cn.cnic.security.configuration.dao.AppListDao;
import cn.cnic.security.configuration.entity.AppListEntity;
import cn.cnic.security.configuration.service.AppListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppListServiceImpl implements AppListService {

    @Autowired
    private  AppListDao appListDao;

    @Override
    public List<AppListEntity> queryAppListPage(Integer pageSize,Integer currPage) {

        Integer minPage = (currPage-1)*pageSize;

        return appListDao.selectAppListPage(minPage,pageSize);

    }

    @Override
    public List<AppListEntity> queryAppListPageByUserName(Integer pageSize, Integer currPage, String userName) {
        Integer minPage = (currPage-1)*pageSize;
        userName = "%"+userName+"%";
        return appListDao.selectAppListPageByUserName(minPage,pageSize,userName);
    }
}

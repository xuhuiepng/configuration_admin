package cn.cnic.security.configuration.service.impl;

import cn.cnic.security.configuration.dao.UserAppListDao;
import cn.cnic.security.configuration.entity.UserAppListEntity;
import cn.cnic.security.configuration.service.UserAppListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("appListService")
public class UserAppListServiceImpl implements UserAppListService {

    @Autowired
    private UserAppListDao userAppListDao;

    @Override
    public List<UserAppListEntity> queryAppListPage(Integer pageSize, Integer currPage) {

        Integer minPage = (currPage-1)*pageSize;

        return userAppListDao.selectAppListPage(minPage,pageSize);

    }

    @Override
    public List<UserAppListEntity> queryAppListPageByUserName(Integer pageSize, Integer currPage, String userName) {
        Integer minPage = (currPage-1)*pageSize;
        userName = "%"+userName+"%";
        return userAppListDao.selectAppListPageByUserName(minPage,pageSize,userName);
    }

    @Override
    public Integer LogicDelete(Integer userId, Integer clientId) {
        return userAppListDao.logicDelete(userId, clientId);
    }
}

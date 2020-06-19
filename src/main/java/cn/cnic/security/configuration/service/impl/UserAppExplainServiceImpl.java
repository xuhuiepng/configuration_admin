package cn.cnic.security.configuration.service.impl;

import cn.cnic.security.common.utils.PageUtils;
import cn.cnic.security.common.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import cn.cnic.security.configuration.dao.UserAppExplainDao;
import cn.cnic.security.configuration.entity.UserAppExplainEntity;
import cn.cnic.security.configuration.service.UserAppExplainService;


@Service("userAppExplainService")
public class UserAppExplainServiceImpl extends ServiceImpl<UserAppExplainDao, UserAppExplainEntity> implements UserAppExplainService {
    @Autowired
    UserAppExplainDao userAppExplainDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UserAppExplainEntity> page = this.page(
                new Query<UserAppExplainEntity>().getPage(params),
                new QueryWrapper<UserAppExplainEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public Integer activate(Integer userId, Integer clientId) {
        return userAppExplainDao.activate(userId, clientId);
    }

}
package cn.cnic.security.configuration.service.impl;

import cn.cnic.security.common.utils.PageUtils;
import cn.cnic.security.common.utils.Query;
import cn.cnic.security.configuration.dao.AppAuthenticationDao;
import cn.cnic.security.configuration.service.AppAuthenticationService;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import cn.cnic.security.configuration.entity.AppAuthenticationEntity;



@Service("appAuthenticationService")
public class AppAuthenticationServiceImpl extends ServiceImpl<AppAuthenticationDao, AppAuthenticationEntity> implements AppAuthenticationService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AppAuthenticationEntity> page = this.page(
                new Query<AppAuthenticationEntity>().getPage(params),
                new QueryWrapper<AppAuthenticationEntity>()
        );

        return new PageUtils(page);
    }

}
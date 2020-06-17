package cn.cnic.security.configuration.service.impl;

import cn.cnic.security.common.utils.PageUtils;
import cn.cnic.security.common.utils.Query;
import cn.cnic.security.configuration.dao.AppAuthenticationDao;
import cn.cnic.security.configuration.service.AppAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import cn.cnic.security.configuration.entity.AppAuthenticationEntity;



@Service("appAuthenticationService")
public class AppAuthenticationServiceImpl extends ServiceImpl<AppAuthenticationDao, AppAuthenticationEntity> implements AppAuthenticationService {

    @Autowired
    private  AppAuthenticationDao appAuthenticationDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        QueryWrapper queryWrapper = new QueryWrapper<AppAuthenticationEntity>();

        queryWrapper.eq("is_del",'0'); //过滤已经删除的认证

        if(params.containsKey("appName"))
            queryWrapper.like("app_name",params.get("appName"));
        if(params.containsKey("bingIp"))
            queryWrapper.like("bing_ip",params.get("bingIp"));
        if(params.containsKey("domain"))
            queryWrapper.like("domain",params.get("domain"));
        if(params.containsKey("projectName"))
            queryWrapper.like("project_name",params.get("projectName"));

        IPage<AppAuthenticationEntity> page = this.page(
                new Query<AppAuthenticationEntity>().getPage(params),
                queryWrapper
        );

        return new PageUtils(page);
    }

    @Override
    public void logicDelete(List<String> tokenList) {

        for(String token:tokenList){
            appAuthenticationDao.logicDelete(token);
        }

    }

}
package cn.cnic.security.configuration.controller;

import cn.cnic.security.common.utils.PageUtils;
import cn.cnic.security.common.utils.R;
import cn.cnic.security.configuration.entity.AppAuthenticationEntity;
import cn.cnic.security.configuration.entity.AppListEntity;
import cn.cnic.security.configuration.entity.UserAppExplainEntity;
import cn.cnic.security.configuration.entity.UserEntity;
import cn.cnic.security.configuration.service.AppAuthenticationService;
import cn.cnic.security.configuration.service.AppListService;
import cn.cnic.security.configuration.service.UserAppExplainService;
import cn.cnic.security.configuration.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Wrapper;
import java.util.*;

@RestController
@RequestMapping("configuration/applist")
public class AppListController {
    @Autowired
    private  AppListService appListService;

    @Autowired
    private UserService userService;

    @Autowired
    private AppAuthenticationService appAuthenticationService;

    @Autowired
    private UserAppExplainService userAppExplainService;


    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){


        int pageSize = 10;
        int currPage = 1;

        List<AppListEntity> appList = new ArrayList<>();

        if(params.containsKey("limit"))
            pageSize = Integer.parseInt((String)params.get("limit"));

        if(params.containsKey("page"))
            currPage = Integer.parseInt((String)params.get("page"));

        if(params.containsKey("userName"))
            appList.addAll(appListService.queryAppListPageByUserName(pageSize,currPage,(String)params.get("userName")));
        else
            appList.addAll(appListService.queryAppListPage(pageSize,currPage));


        Set<String> userNameSet = new HashSet<>();

        for(AppListEntity temp:appList){
            userNameSet.add(temp.getUserName());
        }

        int totalCount = userNameSet.size();

        PageUtils page = new PageUtils(appList,totalCount,pageSize,currPage);

        return R.ok().put("page",page);
    }

    @RequestMapping("/users")
    public R getUsers(){

        List<UserEntity> users = userService.list();

        return R.ok().put("users",users);
    }

    @RequestMapping("/apps")
    public R getApps(){
        QueryWrapper<AppAuthenticationEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("is_del","0");

        List<AppAuthenticationEntity> apps = appAuthenticationService.list(queryWrapper);

        return R.ok().put("apps",apps);
    }

    @RequestMapping("/save")
    public R save(@RequestBody UserAppExplainEntity userAppExplainEntity){
        QueryWrapper<UserAppExplainEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",userAppExplainEntity.getUserId());
        queryWrapper.eq("client_id",userAppExplainEntity.getClientId());

        Integer count = userAppExplainService.count(queryWrapper);

        if(count==1){
            return R.error(-1,"用户权限重复添加");
        }

        userAppExplainEntity.setDeactivation("1");
        userAppExplainService.save(userAppExplainEntity);

        return R.ok();
    }



}

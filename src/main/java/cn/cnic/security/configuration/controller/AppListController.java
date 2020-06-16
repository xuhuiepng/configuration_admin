package cn.cnic.security.configuration.controller;

import cn.cnic.security.common.utils.PageUtils;
import cn.cnic.security.common.utils.R;
import cn.cnic.security.configuration.entity.AppListEntity;
import cn.cnic.security.configuration.service.AppListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("configuration/applist")
public class AppListController {
    @Autowired
    private  AppListService appListService;


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



}

package cn.cnic.security.configuration.controller;

import cn.cnic.security.common.utils.PageUtils;
import cn.cnic.security.common.utils.R;
import cn.cnic.security.configuration.entity.AppAuthenticationEntity;
import cn.cnic.security.configuration.entity.UserAppListEntity;
import cn.cnic.security.configuration.entity.UserAppExplainEntity;
import cn.cnic.security.configuration.entity.UserEntity;
import cn.cnic.security.configuration.service.AppAuthenticationService;
import cn.cnic.security.configuration.service.UserAppListService;
import cn.cnic.security.configuration.service.UserAppExplainService;
import cn.cnic.security.configuration.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("configuration")
public class UserAppListController {
    @Autowired
    private UserAppListService userAppListService;

    @Autowired
    private UserService userService;

    @Autowired
    private AppAuthenticationService appAuthenticationService;

    @Autowired
    private UserAppExplainService userAppExplainService;


    @GetMapping("/userapps")
    public R list(@RequestParam Map<String, Object> params){


        int pageSize = 10;
        int currPage = 1;

        List<UserAppListEntity> appList = new ArrayList<>();

        if(params.containsKey("limit"))
            pageSize = Integer.parseInt((String)params.get("limit"));

        if(params.containsKey("page"))
            currPage = Integer.parseInt((String)params.get("page"));

        if(params.containsKey("userName"))
            appList.addAll(userAppListService.queryAppListPageByUserName(pageSize,currPage,(String)params.get("userName")));
        else
            appList.addAll(userAppListService.queryAppListPage(pageSize,currPage));


        Set<String> userNameSet = new HashSet<>();

        for(UserAppListEntity temp:appList){
            userNameSet.add(temp.getUserName());
        }

        int totalCount = userNameSet.size();

        PageUtils page = new PageUtils(appList,totalCount,pageSize,currPage);

        return R.ok().put("page",page);
    }

    @GetMapping("/userapps/users")
    public R getUsers(){

        List<UserEntity> users = userService.list();

        return R.ok().put("users",users);
    }

    @GetMapping("/userapps/apps")
    public R getApps(){
        QueryWrapper<AppAuthenticationEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("is_del","0");

        List<AppAuthenticationEntity> apps = appAuthenticationService.list(queryWrapper);

        return R.ok().put("apps",apps);
    }

    @PostMapping("/userapps")
    public R save(@RequestBody UserAppExplainEntity userAppExplainEntity){
        QueryWrapper<UserAppExplainEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",userAppExplainEntity.getUserId());
        queryWrapper.eq("client_id",userAppExplainEntity.getClientId());

        Integer count = userAppExplainService.count(queryWrapper);

        if(count==1){
            queryWrapper.eq("deactivation","1");
            count = userAppExplainService.count(queryWrapper);
            if(count==1){
                userAppExplainService.activate(userAppExplainEntity.getUserId(),userAppExplainEntity.getClientId());
            }else{
                return R.error(-1,"用户权限重复添加");
            }
        }else{
            userAppExplainEntity.setDeactivation("0");
            userAppExplainService.save(userAppExplainEntity);
        }
        return R.ok();
    }

    @PostMapping("/userapps:delete")
    public R delete(@RequestBody UserAppListEntity userAppListEntity){
        QueryWrapper<AppAuthenticationEntity> appQuery = new QueryWrapper<>();
        QueryWrapper<UserEntity> userQuery = new QueryWrapper<>();
        appQuery.eq("app_name", userAppListEntity.getAppName());
        userQuery.eq("user_name", userAppListEntity.getUserName());
        Integer userId = userService.getOne(userQuery).getUserId();
        Integer clientId = appAuthenticationService.getOne(appQuery).getClientId();
        Integer count = userAppListService.LogicDelete(userId,clientId);
        if(count==0){
            return R.error(-1,"删除失败");
        }

        return R.ok();

    }



}

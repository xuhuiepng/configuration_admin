package cn.cnic.security.configuration.controller;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import cn.cnic.security.common.utils.MD5;
import cn.cnic.security.common.utils.PageUtils;
import cn.cnic.security.common.utils.R;
import cn.cnic.security.configuration.entity.AppAuthenticationEntity;
import cn.cnic.security.configuration.service.AppAuthenticationService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 *
 * @author xuhuipeng
 * @email xuhuipeng@cnic.com
 * @date 2020-06-09 09:59:33
 */
@RestController
@RequestMapping("configuration/appauthentication")
public class AppAuthenticationController {
    @Autowired
    private AppAuthenticationService appAuthenticationService;

    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("configuration:appauthentication:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = appAuthenticationService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{appToken}")
//    @RequiresPermissions("configuration:appauthentication:info")
    public R info(@PathVariable("appToken") String appToken){
        AppAuthenticationEntity appAuthentication = appAuthenticationService.getById(appToken);

        return R.ok().put("appAuthentication", appAuthentication);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("configuration:appauthentication:save")
    public R save(@RequestBody AppAuthenticationEntity appAuthentication){

        appAuthentication.setAppToken(MD5.MD5Encode(appAuthentication.getAppName(),"utf8"));
        appAuthentication.setClientSecret(MD5.MD5Encode(appAuthentication.getClientSecret(),"utf8"));
        appAuthentication.setNum(0);

        appAuthenticationService.save(appAuthentication);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("configuration:appauthentication:update")
    public R update(@RequestBody AppAuthenticationEntity appAuthentication){
        //appAuthentication.setAppToken(MD5.MD5Encode(appAuthentication.getAppName(),"utf8"));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String  nowDate  =  sdf.format(new Date());

        appAuthentication.setUpdateTime(nowDate);

        appAuthenticationService.updateById(appAuthentication);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("configuration:appauthentication:delete")
    public R delete(@RequestBody String[] appTokens){
        //appAuthenticationService.removeByIds(Arrays.asList(appTokens));
        appAuthenticationService.logicDelete(Arrays.asList(appTokens));
        return R.ok();
    }

    @RequestMapping("/verify")
    public R verify(@RequestBody AppAuthenticationEntity appAuthentication){

        QueryWrapper<AppAuthenticationEntity> queryWrapper = new QueryWrapper<>();

        if(appAuthentication.getAppName()!=null){
            queryWrapper.eq("app_name",appAuthentication.getAppName());
            if(appAuthenticationService.count(queryWrapper)==0)
                return R.ok().put("isExist",false);
            else
                return R.ok().put("isExist",true);
        }

        if(appAuthentication.getClientId()!=null){
            queryWrapper.eq("client_id",appAuthentication.getClientId());
            if(appAuthenticationService.count(queryWrapper)==0)
                return R.ok().put("isExist",false);
            else
                return R.ok().put("isExist",true);
        }

        return R.ok().put("isExist",false);
    }

}


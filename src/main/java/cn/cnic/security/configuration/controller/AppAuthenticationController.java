package cn.cnic.security.configuration.controller;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import cn.cnic.security.common.utils.PageUtils;
import cn.cnic.security.common.utils.R;
import cn.cnic.security.configuration.entity.AppAuthenticationEntity;
import cn.cnic.security.configuration.service.AppAuthenticationService;
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
		appAuthenticationService.save(appAuthentication);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("configuration:appauthentication:update")
    public R update(@RequestBody AppAuthenticationEntity appAuthentication){
		appAuthenticationService.updateById(appAuthentication);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("configuration:appauthentication:delete")
    public R delete(@RequestBody String[] appTokens){
		appAuthenticationService.removeByIds(Arrays.asList(appTokens));

        return R.ok();
    }

}

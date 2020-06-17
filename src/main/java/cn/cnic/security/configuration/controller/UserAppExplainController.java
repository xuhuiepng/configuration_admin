package cn.cnic.security.configuration.controller;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import cn.cnic.security.common.utils.PageUtils;
import cn.cnic.security.common.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.cnic.security.configuration.entity.UserAppExplainEntity;
import cn.cnic.security.configuration.service.UserAppExplainService;




/**
 * 用户与系统关系表
 *
 * @author xuhuipeng
 * @email xuhuipeng@cnic.com
 * @date 2020-06-17 14:01:39
 */
@RestController
@RequestMapping("configuration/userappexplain")
public class UserAppExplainController {
    @Autowired
    private UserAppExplainService userAppExplainService;

    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("configuration:userappexplain:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = userAppExplainService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{cId}")
//    @RequiresPermissions("configuration:userappexplain:info")
    public R info(@PathVariable("cId") Integer cId){
		UserAppExplainEntity userAppExplain = userAppExplainService.getById(cId);

        return R.ok().put("userAppExplain", userAppExplain);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("configuration:userappexplain:save")
    public R save(@RequestBody UserAppExplainEntity userAppExplain){
		userAppExplainService.save(userAppExplain);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("configuration:userappexplain:update")
    public R update(@RequestBody UserAppExplainEntity userAppExplain){
		userAppExplainService.updateById(userAppExplain);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("configuration:userappexplain:delete")
    public R delete(@RequestBody Integer[] cIds){
		userAppExplainService.removeByIds(Arrays.asList(cIds));

        return R.ok();
    }

}

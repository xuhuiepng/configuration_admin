package cn.cnic.security.configuration.controller;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.cnic.security.configuration.entity.RoleEntity;
import cn.cnic.security.configuration.service.RoleService;
import cn.cnic.security.common.utils.PageUtils;
import cn.cnic.security.common.utils.R;



/**
 * 权限表
 *
 * @author xuhuipeng
 * @email xuhuipeng@cnic.com
 * @date 2020-06-04 14:41:02
 */
@RestController
@RequestMapping("configuration/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("configuration:role:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = roleService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{roleId}")
//    @RequiresPermissions("configuration:role:info")
    public R info(@PathVariable("roleId") Integer roleId){
		RoleEntity role = roleService.getById(roleId);

        return R.ok().put("role", role);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("configuration:role:save")
    public R save(@RequestBody RoleEntity role){
		roleService.save(role);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("configuration:role:update")
    public R update(@RequestBody RoleEntity role){
		roleService.updateById(role);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("configuration:role:delete")
    public R delete(@RequestBody Integer[] roleIds){
		roleService.removeByIds(Arrays.asList(roleIds));

        return R.ok();
    }

}

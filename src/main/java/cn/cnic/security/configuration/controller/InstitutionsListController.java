package cn.cnic.security.configuration.controller;

import java.util.*;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import cn.cnic.security.configuration.entity.InstitutionsListEntity;
import cn.cnic.security.configuration.service.InstitutionsListService;
import cn.cnic.security.common.utils.PageUtils;
import cn.cnic.security.common.utils.R;



/**
 * 中科院研究所列表
 *
 * @author xuhuipeng
 * @email xuhuipeng@cnic.com
 * @date 2020-06-04 14:41:02
 */
@RestController
@RequestMapping("configuration")
public class InstitutionsListController {
    @Autowired
    private InstitutionsListService institutionsListService;

    /**
     * 列表
     */
    @GetMapping("/institutions")
//    @RequiresPermissions("configuration:institutionslist:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = institutionsListService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/institutions/{id}")
//    @RequiresPermissions("configuration:institutionslist:info")
    public R info(@PathVariable("id") Integer id){
		InstitutionsListEntity institutionsList = institutionsListService.getById(id);

        return R.ok().put("institutionsList", institutionsList);
    }

    /**
     * 保存
     */
    @PostMapping("/institutions")
//    @RequiresPermissions("configuration:institutionslist:save")
    public R save(@RequestBody InstitutionsListEntity institutionsList){
        institutionsList.setCreateTime(new Date());
		institutionsListService.save(institutionsList);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/institutions/{id}")
//    @RequiresPermissions("configuration:institutionslist:update")
    public R update(@RequestBody InstitutionsListEntity institutionsList){
        institutionsList.setUpdated(new Date());
		institutionsListService.updateById(institutionsList);

        return R.ok();
    }

    /**
     * 删除
     * 这里涉及到批量删除，delete请求会出现url过长的问题，此处采用post请求
     */
    @PostMapping("/institutions:delete")
//    @RequiresPermissions("configuration:institutionslist:delete")
    public R delete(@RequestBody Integer[] ids){
		institutionsListService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}

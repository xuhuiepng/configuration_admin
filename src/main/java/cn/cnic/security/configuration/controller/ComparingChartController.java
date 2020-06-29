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

import cn.cnic.security.configuration.entity.ComparingChartEntity;
import cn.cnic.security.configuration.service.ComparingChartService;




/**
 * 邮箱后缀-研究所-坐标的映射
 *
 * @author xuhuipeng
 * @email xuhuipeng@cnic.com
 * @date 2020-06-04 14:41:02
 */
@RestController
@RequestMapping("configuration/comparingchart")
public class ComparingChartController {
    @Autowired
    private ComparingChartService comparingChartService;

    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("configuration:comparingchart:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = comparingChartService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
//    @RequiresPermissions("configuration:comparingchart:info")
    public R info(@PathVariable("id") int id){
		ComparingChartEntity comparingChart = comparingChartService.getById(id);

        return R.ok().put("comparingChart", comparingChart);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("configuration:comparingchart:save")
    public R save(@RequestBody ComparingChartEntity comparingChart){
    	comparingChart.setId(comparingChartService.getMaxId() + 1);
		comparingChartService.save(comparingChart);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("configuration:comparingchart:update")
    public R update(@RequestBody ComparingChartEntity comparingChart){
		comparingChartService.updateById(comparingChart);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("configuration:comparingchart:delete")
    public R delete(@RequestBody String[] suffixs){
		comparingChartService.removeByIds(Arrays.asList(suffixs));

        return R.ok();
    }

}

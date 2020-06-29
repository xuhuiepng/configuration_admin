package cn.cnic.security.configuration.service;

import cn.cnic.security.common.utils.PageUtils;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.cnic.security.configuration.entity.ComparingChartEntity;

import java.util.Map;

/**
 * 邮箱后缀-研究所-坐标的映射
 *
 * @author xuhuipeng
 * @email xuhuipeng@cnic.com
 * @date 2020-06-04 14:41:02
 */
public interface ComparingChartService extends IService<ComparingChartEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
    int getMaxId();
}


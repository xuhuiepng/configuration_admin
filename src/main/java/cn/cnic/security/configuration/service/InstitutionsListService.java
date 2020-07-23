package cn.cnic.security.configuration.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cn.cnic.security.common.utils.PageUtils;
import cn.cnic.security.configuration.entity.InstitutionsListEntity;

import java.util.Map;

/**
 * 中科院研究所列表
 *
 * @author xuhuipeng
 * @email xuhuipeng@cnic.com
 * @date 2020-06-04 14:41:02
 */
public interface InstitutionsListService extends IService<InstitutionsListEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PageUtils queryNullSuffix(Map<String, Object> params);
}


package cn.cnic.security.configuration.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cn.cnic.security.common.utils.PageUtils;
import cn.cnic.security.configuration.entity.RoleEntity;

import java.util.Map;

/**
 * 权限表
 *
 * @author xuhuipeng
 * @email xuhuipeng@cnic.com
 * @date 2020-06-04 14:41:02
 */
public interface RoleService extends IService<RoleEntity> {

    PageUtils queryPage(Map<String, Object> params);
}


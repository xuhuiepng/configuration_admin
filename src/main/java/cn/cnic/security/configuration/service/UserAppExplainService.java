package cn.cnic.security.configuration.service;

import cn.cnic.security.common.utils.PageUtils;
import com.baomidou.mybatisplus.extension.service.IService;

import cn.cnic.security.configuration.entity.UserAppExplainEntity;

import java.util.Map;

/**
 * 用户与系统关系表
 *
 * @author xuhuipeng
 * @email xuhuipeng@cnic.com
 * @date 2020-06-17 14:01:39
 */
public interface UserAppExplainService extends IService<UserAppExplainEntity> {

    PageUtils queryPage(Map<String, Object> params);

    Integer activate(Integer userId,Integer clientId);
}


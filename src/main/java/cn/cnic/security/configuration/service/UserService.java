package cn.cnic.security.configuration.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cn.cnic.security.common.utils.PageUtils;
import cn.cnic.security.configuration.entity.UserEntity;

import java.util.List;
import java.util.Map;

/**
 * 用户表
 *
 * @author xuhuipeng
 * @email xuhuipeng@cnic.com
 * @date 2020-06-04 14:41:02
 */
public interface UserService extends IService<UserEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
    List<UserEntity> login(Map<String, Object> params);
}


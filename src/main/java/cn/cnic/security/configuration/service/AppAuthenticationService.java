package cn.cnic.security.configuration.service;

import cn.cnic.security.common.utils.PageUtils;
import cn.cnic.security.configuration.entity.AppAuthenticationEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 *
 *
 * @author xuhuipeng
 * @email xuhuipeng@cnic.com
 * @date 2020-06-09 09:59:33
 */
public interface AppAuthenticationService extends IService<AppAuthenticationEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void logicDelete(List<String> tokenList);
}




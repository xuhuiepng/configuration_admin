package cn.cnic.security.configuration.controller;



import cn.cnic.security.common.utils.R;
import cn.cnic.security.configuration.entity.AppAuthenticationEntity;
import cn.cnic.security.configuration.service.AppAuthenticationService;
import cn.cnic.security.configuration.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class AuthenticationController {

    @Autowired
    private AppAuthenticationService authenticationService;


    /**
     *
     * @return
     */
    @PostMapping(value = {"sso/authentication"})
    public R authentication(String code , Integer appKey){
        if(StringUtils.isEmpty(code) && appKey != null){
            return R.error(1,"参数为空");
        }
        /**
         * 1.去科技云认证code
         * 2.1 存在
         * 2.1.1 查看账号是否存在
         * 2.1.2 账号是否有着应用的权限
         *
         * 2.2 不存在
         */

        QueryWrapper<AppAuthenticationEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("client_id", appKey);
        AppAuthenticationEntity entity = authenticationService.getOne(queryWrapper);
        if(entity == null ){
            log.warn("authentication appKey = {}",appKey);
            return R.error(1,"参数错误appkey");
        }




        return null;
    }

}

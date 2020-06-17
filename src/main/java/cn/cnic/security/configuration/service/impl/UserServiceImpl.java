package cn.cnic.security.configuration.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.cnic.security.common.utils.PageUtils;
import cn.cnic.security.common.utils.Query;

import cn.cnic.security.configuration.dao.UserDao;
import cn.cnic.security.configuration.entity.UserEntity;
import cn.cnic.security.configuration.service.UserService;


@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
    	QueryWrapper<UserEntity> query = new QueryWrapper<UserEntity>();
    	if(params.containsKey("userName")) {
    		query.like("user_name", params.get("userName"));
    	}
    	if(params.containsKey("contacts")) {
    		query.like("contacts", params.get("contacts"));
    	}
    	
        IPage<UserEntity> page = this.page(
                new Query<UserEntity>().getPage(params),
                query
        );

        return new PageUtils(page);
    }
    
    @Override
    public List<UserEntity> login(Map<String, Object> params) {
    	QueryWrapper<UserEntity> query = new QueryWrapper<UserEntity>();
    	query.eq("user_name", params.get("username"));
    	
    	List<UserEntity> list = this.baseMapper.selectList(query);
    	return list;
    }

}
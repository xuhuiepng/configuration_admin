/**
 * 
 */
package cn.cnic.security.configuration.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.cnic.security.common.utils.IPUtils;
import cn.cnic.security.common.utils.R;
import cn.cnic.security.configuration.entity.UserEntity;
import cn.cnic.security.configuration.service.UserService;

/**
 * @author chenkai
 *
 */
@RestController
@RequestMapping("configuration/index")
public class IndexController {
	@Autowired
    private UserService userService;
	
	@PostMapping("/login")
//  @RequiresPermissions("configuration:index:login")
	public R login(HttpServletRequest request, HttpServletResponse response, @RequestBody Map<String, Object> params){
		
		List<UserEntity> users = userService.login(params);
		
		if(users.isEmpty()) {
			return R.error("用户"+params.get("username") +"不存在");
		}
		UserEntity user = users.get(0);
		String pw = user.getLocalPassword();
		String pws = (String) params.get("password");
		if(pw.equals(pws)) {
			user.setLastIp(IPUtils.getIpAddr(request));
			user.setLastTime(new Date());
			user.setLoginNumber(user.getLoginNumber() == null ? 1 : user.getLoginNumber() + 1);
			user.setAuthenticationNumber(user.getAuthenticationNumber() == null ? 1 : user.getAuthenticationNumber() + 1);
			userService.updateById(user);
			
			Cookie cookie = new Cookie("userName", user.getUserName());
			cookie.setMaxAge(259200);
			cookie.setPath("/");
		    response.addCookie(cookie);
		    
			return R.ok();
		}
		user.setAuthenticationNumber(user.getAuthenticationNumber() == null ? 1 : user.getAuthenticationNumber() + 1);
		userService.updateById(user);
		return R.error("密码错误");	    
	}
	
	@PostMapping("/logout")
	public R logout(HttpServletResponse response) {
		Cookie cookie = new Cookie("userName", null);
		cookie.setMaxAge(0);
		cookie.setPath("/");
	    response.addCookie(cookie);
		return R.ok();
	}
	
}

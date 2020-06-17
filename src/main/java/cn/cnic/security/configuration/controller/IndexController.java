/**
 * 
 */
package cn.cnic.security.configuration.controller;

import java.net.InetAddress;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	@Autowired
	private HttpServletRequest request;
	
	@RequestMapping("/login")
//  @RequiresPermissions("configuration:index:login")
	public R login(@RequestBody Map<String, Object> params){
		
		List<UserEntity> users = userService.login(params);
		
		if(users.isEmpty()) {
			return R.error("用户"+params.get("username") +"不存在");
		}
		UserEntity user = users.get(0);
		String pw = user.getLocalPassword();
		String pws = (String) params.get("password");
		if(pw.equals(pws)) {
			user.setLastIp(getIpAddress());
			user.setLastTime(new Date());
			user.setLoginNumber(user.getLoginNumber() == null ? 1 : user.getLoginNumber() + 1);
			user.setAuthenticationNumber(user.getAuthenticationNumber() == null ? 1 : user.getAuthenticationNumber() + 1);
			userService.updateById(user);
			return R.ok().put("user", user);
		}
		user.setAuthenticationNumber(user.getAuthenticationNumber() == null ? 1 : user.getAuthenticationNumber() + 1);
		userService.updateById(user);
		return R.error("密码错误");	    
	}
	
	
	private String getIpAddress() {
		String ip = request.getHeader("x-forwarded-for");
		if(ip == null || ip.length() == 0 || "unknow".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length () == 0 || "unknown".equalsIgnoreCase (ip)) {
	        ip = request.getHeader ("WL-Proxy-Client-IP");
	    }
		 if (ip == null || ip.length () == 0 || "unknown".equalsIgnoreCase (ip)) {
		        ip = request.getRemoteAddr ();
		        if (ip.equals ("127.0.0.1")) {
		            //根据网卡取本机配置的IP
		            InetAddress inet = null;
		            try {
		                inet = InetAddress.getLocalHost ();
		            } catch (Exception e) {
		                e.printStackTrace ();
		            }
		            ip = inet.getHostAddress ();
		        }
		    }
		    // 多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
		    if (ip != null && ip.length () > 15) {
		        if (ip.indexOf (",") > 0) {
		            ip = ip.substring (0, ip.indexOf (","));
		        }
		    }
		    return ip;				
	}
	
}

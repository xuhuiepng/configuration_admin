package cn.cnic.security.configuration.service.impl;

import cn.cnic.security.configuration.dao.UserDao;
import cn.cnic.security.configuration.entity.AppAuthenticationEntity;
import cn.cnic.security.configuration.entity.SysmUserInfo;
import cn.vlabs.umt.oauth.AccessToken;
import cn.vlabs.umt.oauth.Oauth;
import cn.vlabs.umt.oauth.UMTOauthConnectException;
import cn.vlabs.umt.oauth.common.exception.OAuthProblemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

import java.util.Properties;

/**
 * 认证与授权
 */
@Service
public class AuthenticationAndAuthorizationServicelImpl {

    //这两个参数应该不会变，直接写死
    private String accessTokenURL = "https://passport.escience.cn/oauth2/token";
    private String authorizeURL = "https://passport.escience.cn/oauth2/authorize";

    @Autowired
    private UserDao userDao;

    /**
     * 科技云认证
     * @param request
     * @return
     */
    public AccessToken authentication(HttpServletRequest request, AppAuthenticationEntity prop) throws UMTOauthConnectException, OAuthProblemException {
        Properties p = new Properties();
        p.setProperty("client_id", prop.getClientId().toString());
        p.setProperty("client_secret",prop.getClientSecret());
        p.setProperty("redirect_uri", prop.getRedirectUri());
        p.setProperty("redirect_uri", prop.getRedirectUri());
        p.setProperty("access_token_URL", accessTokenURL);
        p.setProperty("authorize_URL", authorizeURL);
        p.setProperty("theme", prop.getTheme());
        Oauth oauth = new Oauth(p);
        return oauth.getAccessTokenByRequest(request);
    }

    /**
     * 授权
     * @param emailAccount 邮箱账号
     * @return
     */
    public SysmUserInfo authorization(String emailAccount){
        //1.查询应用表查看是否有权限
        //2.授权
        SysmUserInfo sysmUserInfo = userDao.findSysmUserInfo(emailAccount);
        return sysmUserInfo;
    }

}

package com.fastdev.web.config.shiro;

import com.fastdev.web.business.account.AccountService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class UserAuthorizingRealm extends AuthorizingRealm {

    private static final Logger logger = LoggerFactory.getLogger(UserAuthorizingRealm.class);

    @Autowired
    private AccountService accountService;

    /**
     * 认证回调函数,登录时调用.
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {

        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        String account = token.getUsername();
        String password = new String(token.getPassword());

        logger.debug("登录用户名:" + token.getUsername());
        logger.debug("登录密码密文  :" + password);

        Map<String, String> accountInfo = accountService.getAccountInfos();

        if (accountInfo.containsKey(account) == false) {
            logger.debug("登录验证失败 原因：无此用户");
            throw new UnknownAccountException("无此用户");
        }

        logger.debug("帐户密码密文  :" + accountInfo.get(account));
        if (!StringUtils.equals(accountInfo.get(account), password)) {
            logger.debug("登录验证失败 原因：密码不匹配");
            throw new IncorrectCredentialsException("账号或密码错误");
        }

        // 创建用户鉴权信息
        UserAuthorizingInfo userAuthInfo = new UserAuthorizingInfo();
        userAuthInfo.setAccount(account);

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(userAuthInfo, password, getName());

        return info;

    }

    /**
     * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        UserAuthorizingInfo userAuthorizingInfo = (UserAuthorizingInfo) super.getAvailablePrincipal(principals);

        if (userAuthorizingInfo == null) {
            return null;
        }

        SimpleAuthorizationInfo simpleAuthorInfo = new SimpleAuthorizationInfo();
        return simpleAuthorInfo;
    }


}

package com.fastdev.web.config.shiro;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.DelegatingFilterProxy;

import javax.servlet.Filter;
import java.util.Map;

/**
 * Created by 李一萌 on 2017/4/29.
 */
@Configuration
public class ShiroConfigurer {

    @Bean(name = "rememberMeCookie")
    public SimpleCookie rememberMeCookie() {
        SimpleCookie cookie = new SimpleCookie("rememberMe");
        cookie.setHttpOnly(false);
        cookie.setMaxAge(604800);
        return cookie;
    }

    @Bean(name = "rememberMeManager")
    public CookieRememberMeManager getRememberMeManager() {
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCipherKey(Base64.decode("9AvVhmFLUs0KTA3Kprsdag=="));
        cookieRememberMeManager.setCookie(rememberMeCookie());
        return cookieRememberMeManager;
    }

    @Bean(name = "myRealm")
    public UserAuthorizingRealm getMyRealm() {
        UserAuthorizingRealm myRealm = new UserAuthorizingRealm();
        return myRealm;
    }

    @Bean(name = "lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager() {
        DefaultWebSecurityManager dwsm = new DefaultWebSecurityManager();
        dwsm.setRealm(getMyRealm());
        dwsm.setRememberMeManager(getRememberMeManager());
        dwsm.setSessionMode(DefaultWebSecurityManager.NATIVE_SESSION_MODE);
        return dwsm;
    }

    @Bean(name = "userAuthorizingAuthcFilter")
    public UserAuthorizingAuthcFilter getUserAuthorizingAuthcFilter() {
        UserAuthorizingAuthcFilter userAuthorizingAuthcFilter = new UserAuthorizingAuthcFilter();
        return userAuthorizingAuthcFilter;
    }

    @Bean
    public FilterRegistrationBean delegatingFilterProxy() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        DelegatingFilterProxy proxy = new DelegatingFilterProxy();
        proxy.setTargetFilterLifecycle(true);
        proxy.setTargetBeanName("shiroFilter");
        filterRegistrationBean.setFilter(proxy);
        return filterRegistrationBean;
    }


    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean getShiroFilterFactoryBean() {

        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 必须设置 SecurityManager
        shiroFilterFactoryBean.setSecurityManager(getDefaultWebSecurityManager());
        // 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
        //shiroFilterFactoryBean.setLoginUrl("/account/login");
        // 用户访问未对其授权的资源时,所显示的连接
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");

        Map<String, Filter> filtersMap = shiroFilterFactoryBean.getFilters();
        filtersMap.put("authc", getUserAuthorizingAuthcFilter());
        shiroFilterFactoryBean.setFilters(filtersMap);

//        StringBuffer sb = new StringBuffer();
//        sb.append("/account/** = anon\n");
//        sb.append("/engines/** = authc\n");
//        shiroFilterFactoryBean.setFilterChainDefinitions(sb.toString());
        Map<String, String> filterChainDefinitionMap = shiroFilterFactoryBean.getFilterChainDefinitionMap();
        filterChainDefinitionMap.put("/account/login", "anon");
        filterChainDefinitionMap.put("/account/logout", "anon");
        filterChainDefinitionMap.put("/account/logininfo", "authc");
        filterChainDefinitionMap.put("/engines/**", "authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);


        return shiroFilterFactoryBean;
    }

}

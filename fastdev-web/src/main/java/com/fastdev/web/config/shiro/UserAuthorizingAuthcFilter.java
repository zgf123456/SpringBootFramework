
package com.fastdev.web.config.shiro;


import com.alibaba.fastjson.JSONObject;
import com.fastdev.web.business.account.AccountService;
import com.fastdev.web.common.dto.ResponseVo;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.util.Map;

public class UserAuthorizingAuthcFilter extends FormAuthenticationFilter {

    private static final Logger logger = LoggerFactory.getLogger(UserAuthorizingAuthcFilter.class);

    @Autowired
    private AccountService accountService;

    /**
     * 所有请求都会经过的方法。
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        if (this.isLoginRequest(request, response)) {
            if (this.isLoginSubmission(request, response)) {
                if (logger.isTraceEnabled()) {
                    logger.trace("Login submission detected.  Attempting to execute login.");
                }
                return this.executeLogin(request, response);
            } else {
                if (logger.isTraceEnabled()) {
                    logger.trace("Login page view.");
                }

                return true;
            }
        } else {
            if (logger.isTraceEnabled()) {
                logger.trace("Attempting to access a path which requires authentication.  Forwarding to the Authentication url [" + getLoginUrl() + "]");
            }

            boolean rememberMeAuth = false;

            Subject subject = SecurityUtils.getSubject();
            if (!subject.isAuthenticated() && subject.isRemembered()) {
                Object principal = subject.getPrincipal();

                if (null != principal) {

                    UserAuthorizingInfo userAuthorizingInfo = (UserAuthorizingInfo) principal;
                    String rememberUser = userAuthorizingInfo.getAccount();
                    logger.debug("被记住的登录用户：" + rememberUser);

                    Map<String, String> accountInfo = accountService.getAccountInfos();
                    if(accountInfo.containsKey(rememberUser)){
                        UsernamePasswordToken token = new UsernamePasswordToken(rememberUser, accountInfo.get(rememberUser));
                        token.setRememberMe(true);
                        subject.login(token);//登录
                        rememberMeAuth = true;
                    }
                }
            }
            if (rememberMeAuth) {
                return true;
            } else {
                String headerKey = ((HttpServletRequest) request).getHeader("X-Requested-With");
                String callback = request.getParameter("callback");

                //AJAX请求
                // 同域：【X-Requested-With】关键字判断
                // 跨域：【callback】参数判断
                if ("XMLHttpRequest".equalsIgnoreCase(headerKey) || StringUtils.isNotBlank(callback)) {
                    ResponseVo responseVo = new ResponseVo();
                    responseVo.setReturnCode(ResponseVo.NOAUTHC);
                    responseVo.setReturnMsg("您已长时间未操作，请重新登录！");

                    response.setCharacterEncoding("UTF-8");
                    PrintWriter out = response.getWriter();
                    if (StringUtils.isNotBlank(callback)) {
                        out.print(callback + "(" + JSONObject.toJSON(responseVo).toString() + ")");
                    } else {
                        out.print(JSONObject.toJSON(responseVo).toString());
                    }
                    out.flush();
                    out.close();
                } else {
                    // 不是ajax请求
                    saveRequestAndRedirectToLogin(request, response);
                }
                return false;

            }


        }
    }
}

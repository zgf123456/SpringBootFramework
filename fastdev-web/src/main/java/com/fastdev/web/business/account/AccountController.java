package com.fastdev.web.business.account;

import com.fastdev.web.common.dto.ResponseVo;
import com.fastdev.web.config.shiro.UserAuthorizingInfo;
import com.fastdev.web.config.shiro.UserAuthorizingUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * 登录测试，JSONP测试
 *
 */
@RestController
public class AccountController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AccountService accountService;

    @RequestMapping("/account/login")
    @ResponseBody
    public Object login(HttpServletRequest request, String callback) {
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        String rememberMe = request.getParameter("rememberMe");
        ResponseVo responseVo = new ResponseVo();
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(responseVo);
        mappingJacksonValue.setJsonpFunction(callback);

        if (StringUtils.isBlank(account)) {
            responseVo.setReturnCode(ResponseVo.FAIL);
            responseVo.setReturnMsg("请输入登录账号");
            return mappingJacksonValue;
        }
        if (StringUtils.isBlank(password)) {
            responseVo.setReturnCode(ResponseVo.FAIL);
            responseVo.setReturnMsg("请输入登录密码");
            return mappingJacksonValue;
        }

        boolean rememberMeFlg = true;
        if (StringUtils.isNotBlank(rememberMe) && !"1".equals(rememberMe)) {
            rememberMeFlg = false;
        }

        try {
            responseVo = accountService.verifyUserInfo(account, password, rememberMeFlg);
        } catch (Exception e) {
            responseVo.setReturnCode(ResponseVo.FAIL);
            responseVo.setReturnMsg("登录失败");
            logger.error("用户登录系统异常 account:" + account + " password:" + password + " 原因：" + e);
        }

        return mappingJacksonValue;
    }

    @RequestMapping("/account/logout")
    @ResponseBody
    public Object logout(HttpServletRequest request, String callback) {
        ResponseVo responseVo = new ResponseVo();
        try {
            Subject subject = SecurityUtils.getSubject();
            subject.logout();
            responseVo.setReturnCode(ResponseVo.SUCC);
            responseVo.setReturnMsg("用户注销系统成功");
        } catch (Exception e) {
            responseVo.setReturnCode(ResponseVo.FAIL);
            responseVo.setReturnMsg("用户注销系统失败");
            logger.error("用户注销系统失败 原因：" + e);
        }

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(responseVo);
        mappingJacksonValue.setJsonpFunction(callback);
        return mappingJacksonValue;
    }

    @RequestMapping(value = "/account/logininfo")
    @ResponseBody
    public Object loginInfo(String callback) {
        ResponseVo responseVo = new ResponseVo();
        try {
            //尝试获取已经登录的用户鉴权信息
            UserAuthorizingInfo userAuthInfo = UserAuthorizingUtils.getUserAuthInfo();
            //获取登录用户信息
            Map<String, Object> resultData = new HashMap<String, Object>();
            resultData.put("account", userAuthInfo.getAccount());
            responseVo.setReturnCode(ResponseVo.SUCC);
            responseVo.setReturnMsg("获取登录用户信息成功");
            responseVo.setBody(resultData);
        } catch (Exception e) {
            responseVo.setReturnCode(ResponseVo.FAIL);
            responseVo.setReturnMsg("获取登录用户信息失败");
            logger.error("获取登录用户信息失败 原因：" + e);
        }

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(responseVo);
        mappingJacksonValue.setJsonpFunction(callback);
        return mappingJacksonValue;
    }


}

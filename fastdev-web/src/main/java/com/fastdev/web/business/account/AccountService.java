package com.fastdev.web.business.account;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.fastdev.web.common.dto.ResponseVo;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 李一萌 on 2017/5/1.
 */
@Service
public class AccountService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${system.account}")
    private String ACCOUNT_STR;

    /**
     * 验证用户登录信息（Shrio验证）
     */
    public ResponseVo verifyUserInfo(String username, String password, boolean rememberMe) {

        ResponseVo responseVo = new ResponseVo();

        // 创建用户名和密码的令牌
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        // 记录登录状态时需要开启
        token.setRememberMe(rememberMe);
        // 获取shiro Subject对象
        Subject subject = SecurityUtils.getSubject();
        try {
            // 执行登录 调用
            subject.login(token);
            // 验证是否成功登录的方法
            if (subject.isAuthenticated()) {
                responseVo.setReturnCode(ResponseVo.SUCC);
                responseVo.setReturnMsg("登录成功");
            } else {
                responseVo.setReturnCode(ResponseVo.FAIL);
                responseVo.setReturnMsg("登录失败");
            }
        } catch (ShiroException ex) {
            responseVo.setReturnCode(ResponseVo.FAIL);
            responseVo.setReturnMsg(ex.getMessage());
            logger.error("登录失败 原因：", ex);
        } catch (Exception ex) {
            // 其他的未知错误
            logger.error("登录失败 原因：", ex);
            responseVo.setReturnCode(ResponseVo.FAIL);
            responseVo.setReturnMsg(ex.getMessage());
        }
        return responseVo;

    }

    public Map<String, String> getAccountInfos() {
        Map<String, String> accountInfos = new HashMap<>();
        if (StringUtils.isBlank(ACCOUNT_STR)) {
            return accountInfos;
        }
        accountInfos = JSON.parseObject("{" + ACCOUNT_STR + "}", new TypeReference<Map<String, String>>() {
        });
        return accountInfos;
    }
}

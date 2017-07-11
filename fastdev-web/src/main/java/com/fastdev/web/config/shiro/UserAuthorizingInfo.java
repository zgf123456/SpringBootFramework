package com.fastdev.web.config.shiro;


import java.io.Serializable;

/**
 * 用户鉴权信息Bean
 * Created by NemoLee on 2016/3/18.
 */
public class UserAuthorizingInfo implements Serializable, UserAuthorizingInfoIF {

    private static final long serialVersionUID = 1L;

    /* 用户信息 */
    String userId;
    String userCode;
    String account;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Override
    public String getUserCode() {
        return userId;
    }
}

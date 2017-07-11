package com.fastdev.web.config.shiro;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

public class UserAuthorizingUtils {


    public static UserAuthorizingInfo getUserAuthInfo() {
        Subject sb = SecurityUtils.getSubject();
        return (UserAuthorizingInfo) (sb.getPrincipal());
    }

    public static String getMerchUserId() {
        UserAuthorizingInfo userAuthInfo = getUserAuthInfo();
        String merchUserId = "";
        if (userAuthInfo != null) {
            merchUserId = userAuthInfo.getUserId();
        }
        return merchUserId;
    }

    public static String getAccount() {
        UserAuthorizingInfo userAuthInfo = getUserAuthInfo();
        String userAccount = "";
        if (userAuthInfo != null) {
            userAccount = userAuthInfo.getAccount();
        }
        return userAccount;
    }

    public static String getUserCode() {
        UserAuthorizingInfo userAuthInfo = getUserAuthInfo();
        String merchId = "";
        if (userAuthInfo != null) {
            merchId = userAuthInfo.getUserCode();
        }
        return merchId;
    }

}

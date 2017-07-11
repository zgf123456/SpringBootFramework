package com.fastdev.web.common.dto;

import java.io.Serializable;

public class ResponseVo implements Serializable {

    private static final long serialVersionUID = 7247714666080613254L;

    public static final String SUCC = "200";
    public static final String FAIL = "500";
    public static final String NOAUTHC = "900";

    private String returnCode;
    private String returnMsg;
    private String sign;
    private Object body;


    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }
}

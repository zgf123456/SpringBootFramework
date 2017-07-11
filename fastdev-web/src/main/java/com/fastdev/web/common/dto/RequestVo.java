package com.fastdev.web.common.dto;

import java.io.Serializable;

public class RequestVo implements Serializable {

    private static final long serialVersionUID = 7247714666080613254L;

    private String serviceType;
    private String systemType;
    private String sign;
    private Object body;

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getSystemType() {
        return systemType;
    }

    public void setSystemType(String systemType) {
        this.systemType = systemType;
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

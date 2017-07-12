package com.fastdev.common.aop;

import java.util.HashMap;

/**
 * Controller入口传递参数的DTO
 */
public class GenericServiceDto extends HashMap<String, String> {

    private String reqUID;
//    private String sign;
    private String userCode;

    public String getReqUID() {
        return this.get("REQ_UID");
    }

    public void setReqUID(String reqUID) {
        this.put("REQ_UID", reqUID);
    }

    public String getUserCode() {
        return this.get("USER_CODE");
    }

    public void setUserCode(String userCode) {
        this.put("USER_CODE", userCode);
    }

//    public void signature(String key) {
//        this.sign = SignatureUtil.getMapSign(this, key);
//        this.put("sign", sign);
//    }
}

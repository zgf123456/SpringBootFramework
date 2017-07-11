/**
 * Project Name:yisecpaybg
 * File Name:BusinessException.java
 * Package Name:com.creditease.ns.yisecpaybg.base
 * Date:2016年3月16日下午3:07:05
 */

package com.fastdev.common.exception;

/**
 * Declare: 系统自定义业务异常 <br/>
 * Description: 系统自定义业务异常 <br/>
 * ClassName:BusinessException <br/>
 */
public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private String code; // 异常对应的返回码
    private String message; // 异常对应的描述信息

    public BusinessException() {
        super();
    }

    public BusinessException(String message) {
        super(message);
        this.message = message;
    }

    public BusinessException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public BusinessException(Throwable e) {
        super(e);
        this.message = e.getMessage();
    }


    public BusinessException(String message, Throwable e) {
        super(e);
        this.message = message;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}

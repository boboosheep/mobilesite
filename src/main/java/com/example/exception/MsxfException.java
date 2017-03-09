package com.example.exception;

import com.example.ErrorCode;

/**
 * @描述 : 基础异常类，所有系统自定义异常需要继承该异常类
 * @作者 : JiaoJian
 * @创建时间 : 2015年9月16日 上午10:22:00
 */
public class MsxfException extends RuntimeException {
    private static final long serialVersionUID = 7614972703708803482L;

    private ErrorCode errorCode;

    public MsxfException(ErrorCode errorCode){
        super(errorCode.getMessage());

        this.errorCode = errorCode;
    }

    public MsxfException(ErrorCode errorCode, String message) {
        super(message);

        this.errorCode = errorCode;
    }

    public MsxfException(ErrorCode errorCode, String message, Throwable t) {
        super(message, t);

        this.errorCode = errorCode;
    }

    public String getCode() {
        return this.errorCode.getCode();
    }

    public ErrorCode getErrorCode() {
        return this.errorCode;
    }

 }

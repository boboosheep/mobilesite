/**
 * MSXF
 */
package com.example.rest;

/**
 * @author hongzheng.liu
 * @created 2015年9月25日
 */
public class RestError {
    private String code;

    private String message;

    public RestError(String code, String message) {
        this.code = code;
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

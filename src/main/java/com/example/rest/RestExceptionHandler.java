/**
 * MSXF
 */
package com.example.rest;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.context.request.WebRequest;

import com.example.exception.MsxfException;
import com.example.exception.MsxfUnauthorizedException;
import com.example.exception.MsxfValidationException;

/**
 * @author hongzheng.liu
 * @created 2015年9月25日
 */
@ControllerAdvice
public class RestExceptionHandler {
    protected final Logger log = LoggerFactory.getLogger(this.getClass());
    

    @ExceptionHandler(MsxfException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public RestError handleDataStoreException(MsxfException ex, WebRequest request, HttpServletResponse response) {

        log.error("===> Request failed message: ", ex);

        return new RestError(ex.getCode(), ex.getMessage());
    }

    /**
     * 用于处理验签失败类的异常
     */
    @ExceptionHandler(MsxfUnauthorizedException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public RestError handleUnauthorizedException(MsxfUnauthorizedException ex, WebRequest request,
                                                 HttpServletResponse response) {

        log.error("===> Request failed, message: ", ex);
        return new RestError(ex.getCode(), ex.getMessage());
    }

    @ExceptionHandler(MsxfValidationException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public RestValidationError handleValidationException(MsxfValidationException ex, WebRequest request,
                                                         HttpServletResponse response) {

        log.error("===> Request parameter validation , message:", ex);

        return new RestValidationError(ex.getFields(), ex.getMessage());
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public RestValidationError handleMissingParameterException(MissingServletRequestParameterException ex,
                                                               WebRequest request, HttpServletResponse response) {
        RestValidationError rve = new RestValidationError(ex.getMessage());

        log.error("===> Request parameter validation error: ", ex);

        rve.getFields().put(ex.getParameterName(), "Required");

        return rve;
    }

    @ExceptionHandler({HttpClientErrorException.class, HttpServerErrorException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public void handleHttpClientErrorException(HttpStatusCodeException ex, WebRequest request,
                                                    HttpServletResponse response) {
        log.error("===> Internal invoke failed, message: ", ex);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public void handleHttpClientErrorException(Exception ex, WebRequest request,
                                               HttpServletResponse response) {
        log.error("===> Internal invoke failed: ", ex);
    }
}


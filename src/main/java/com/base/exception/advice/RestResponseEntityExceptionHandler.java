package com.base.exception.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

/**
 *  全局异常
 */
@ControllerAdvice(basePackages = "")
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    private final Logger log = LoggerFactory.getLogger(getClass());
    @ExceptionHandler({Exception.class})
    protected ResponseEntity<Object> handleConflict(Exception ex, WebRequest request) {
        HttpStatus httpStatus;
        if(ex instanceof Forbidden403Exception) {
            httpStatus = HttpStatus.FORBIDDEN;
        } else {
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return handleExceptionInternal(ex,
                null,
                new HttpHeaders(),
                httpStatus,
                request);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body,
                                                             HttpHeaders headers, HttpStatus status, WebRequest request) {
        if(ex instanceof UnsupportedOperationException) {
        } else {
            log.error(null, ex);
        }
        headers.add("Content-Type", "application/json;charset=UTF-8");
        Map<String, Object> map = new HashMap<>();
        map.put("message", ex.getMessage()!=null?ex.getMessage():ex.getClass().getName());
//        body = JsonUtil.toJson(map);
        return super.handleExceptionInternal(ex, body, headers, status, request);
    }
}

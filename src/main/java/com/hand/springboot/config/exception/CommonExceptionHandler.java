package com.hand.springboot.config.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * 全局异常处理
 *
 * @author liangwusun 2021/03/29 14:56
 */
@ControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler(UserNotExistException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String,Object> handlerUerNotExistException(UserNotExistException e){
        Map<String,Object> result = new HashMap<>();
        result.put("id",e.getId());
        result.put("message",e.getMessage());
        return result;
    }
}

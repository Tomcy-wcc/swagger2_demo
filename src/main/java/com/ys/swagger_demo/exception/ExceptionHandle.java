package com.ys.swagger_demo.exception;

import com.ys.swagger_demo.vo.CodeEnum;
import com.ys.swagger_demo.vo.ResponseData;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description 异常统一处理器
 * @auther wcc
 * @create 2020-01-03 22:28
 */
@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseData errorHandle(Exception e){
        return ResponseData.out(CodeEnum.BAD_REQUEST, e.getMessage());
    }
}

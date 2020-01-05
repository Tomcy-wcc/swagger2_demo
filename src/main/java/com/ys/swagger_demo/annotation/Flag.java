package com.ys.swagger_demo.annotation;


import java.lang.annotation.*;

/**
 * 标记那些接口被扫描
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Flag {

}

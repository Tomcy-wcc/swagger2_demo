package com.ys.swagger_demo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description
 * @auther wcc
 * @create 2020-01-03 22:01
 */
@ApiModel("响应结果")
public class ResponseData<T> extends BaseResponse {

    @ApiModelProperty("数据")
    private T data;

    private ResponseData() {
    }

    private ResponseData(CodeEnum code, T data) {
        super(code);
        this.data = data;
    }

    public static <T> ResponseData<T> out(CodeEnum code, T data) {
        return new ResponseData<T>(code, data);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}

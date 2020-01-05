package com.ys.swagger_demo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description
 * @auther wcc
 * @create 2020-01-03 22:00
 */
@ApiModel("响应结果")
public class BaseResponse {

    @ApiModelProperty("响应码")
    private int code;

    @ApiModelProperty("响应消息")
    private String msg;

    protected BaseResponse() {
    }

    protected BaseResponse(CodeEnum code) {
        this.code = code.getCode();
        this.msg = code.getMsg();
    }

    public static BaseResponse out(CodeEnum code) {
        return new BaseResponse(code);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

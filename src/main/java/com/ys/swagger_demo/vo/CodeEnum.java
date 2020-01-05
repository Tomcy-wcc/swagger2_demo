package com.ys.swagger_demo.vo;

/**
 * @Description
 * @auther wcc
 * @create 2020-01-03 21:59
 */
public enum CodeEnum {
    SUCCESS(0, "成功！"),
    FAIL(1, "失败，未知错误！"),
    NO_RESULT(2, "查询成功，没有结果"),
    REPEAT_INSERT(3, "用户已经存在"),
    NO_USER_SELECT(4, "用户不存在"),
    BAD_REQUEST(400, "请求参数没填好"),
    ;
    /**
     * 响应状态码
     */
    private final int code;
    /**
     * 响应提示
     */
    private final String msg;

    CodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}

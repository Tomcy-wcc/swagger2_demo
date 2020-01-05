package com.ys.swagger_demo.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description
 * @auther wcc
 * @create 2019-12-26 19:25
 */
@ApiModel("地址实体类")
public class Address {

    @ApiModelProperty("省")
    private String province;

    public Address() {
    }

    public Address(String province) {
        this.province = province;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Override
    public String toString() {
        return "Address{" +
                "province='" + province + '\'' +
                '}';
    }
}

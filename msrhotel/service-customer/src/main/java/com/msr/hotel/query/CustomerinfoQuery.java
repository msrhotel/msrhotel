package com.msr.hotel.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
@ApiModel(value = "customerinfo查询对象", description = "客人信息查询对象封装")
@Data
public class CustomerinfoQuery implements Serializable {
    @ApiModelProperty(value = "客户姓名")
    private String customerName;

    @ApiModelProperty(value = "客户联系电话")
    private String customerinfoTel;

    @ApiModelProperty(value = "客户生日")
    private String customerinfoBirthday;
}

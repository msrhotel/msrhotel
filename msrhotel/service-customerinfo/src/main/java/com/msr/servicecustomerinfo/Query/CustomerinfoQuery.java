package com.msr.servicecustomerinfo.Query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "customerinfo查询对象", description = "客人信息查询对象封装")
@Data
public class CustomerinfoQuery {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "客户姓名")
    private String customerName;

    @ApiModelProperty(value = "客户联系电话")
    private String customerinfoTel;

    @ApiModelProperty(value = "客户生日")
    private String customerinfoBirthday;
}

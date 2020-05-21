package com.msr.serviceorder.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@ApiModel(value = "订单查询对象", description = "订单信息查询对象封装")
@Data
public class HotelOrderQuery implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "订单ID")
    private String orderId;

    @ApiModelProperty(value = "客户ID")
    private String customerId;

    @ApiModelProperty(value = "房型 1单人间 2双人间 3总统套房")
    private Integer orderType;

    @ApiModelProperty(value = "预订退房时间",example = "2019-01-01 10:10:10")
    private String outDate;

    @ApiModelProperty(value = "预订入住日期",example = "2019-02-01 10:10:10")
    private String inDate;
}

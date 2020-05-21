package com.msr.hotel.query;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@ApiModel(value = "customer查询对象", description = "客人入住信息查询对象封装")
@Data
public class CustomerQuery implements Serializable {
    private static final long serialVersionUID = 1L;

//    @ApiModelProperty(value = ",模糊查询")
//    private String name;

    @ApiModelProperty(value = "客户入住房间号")
    private Integer inRoom;

    @ApiModelProperty(value = "入住时的退房时间",example = "2019-01-01 10:10:10")
    private String outDate;

    @ApiModelProperty(value = "客户入住日期",example = "2019-01-01 10:10:10")
    private String inDate;
}

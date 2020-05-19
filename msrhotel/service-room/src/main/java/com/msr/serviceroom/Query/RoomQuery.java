package com.msr.serviceroom.Query;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@ApiModel(value = "Room查询对象", description = "客房查询对象封装")
@Data

public class RoomQuery {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "房间类型")
    private Integer roomType;

    @ApiModelProperty(value = "价格")
    private String roomPrice;

    @ApiModelProperty(value = "房态")
    private String roomState;

    @ApiModelProperty(value = "查询开始时间", example = "2019-01-01 10:10:10")
    private String begin;//注意，这里使用的是String类型，前端传过来的数据无需进行类型转换

    @ApiModelProperty(value = "查询结束时间", example = "2019-12-01 10:10:10")
    private String end;
}



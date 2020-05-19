package com.msr.serviceaccount.query;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
@Data
public class ConsumeQuery {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "对应用户id")
    private String customerId;

    @ApiModelProperty(value = "账务消费类型")
    private Integer consumeTypeId;

    @ApiModelProperty(value = "账务消费日期")
    private Date consumeDate;



    @ApiModelProperty(value = "账务操作员")
    private String consumeSatff;

    @ApiModelProperty(value = "查询开始时间", example = "2019-01-01 10:10:10")
    private String begin;//注意，这里使用的是String类型，前端传过来的数据无需进行类型转换

    @ApiModelProperty(value = "查询结束时间", example = "2019-12-01 10:10:10")
    private String end;
}

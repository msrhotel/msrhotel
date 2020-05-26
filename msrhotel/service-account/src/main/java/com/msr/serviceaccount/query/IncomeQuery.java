package com.msr.serviceaccount.query;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
@Data
public class IncomeQuery {
    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "收入账务ID，主键")
    @TableId(value = "income_id", type = IdType.ID_WORKER_STR)
    private String incomeId;

    @ApiModelProperty(value = "对应用户id")
    private String customerId;

    @ApiModelProperty(value = "账务收入类型")
    private Integer incomeTypeId;

    @ApiModelProperty(value = "账务操作员")
    private String incomeSatff;

    @ApiModelProperty(value = "账务收入日期",example ="2019-01-01 10:10:10")
    private Date incomeDate;


    @ApiModelProperty(value = "查询开始时间", example = "2019-01-01 10:10:10")
    private String begin;//注意，这里使用的是String类型，前端传过来的数据无需进行类型转换

    @ApiModelProperty(value = "查询结束时间", example = "2019-12-01 10:10:10")
    private String end;
}

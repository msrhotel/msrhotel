package com.msr.serviceaccount.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author msr
 * @since 2020-05-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="HotelIncome对象", description="")
public class HotelIncome implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "收入账务ID，主键")
    @TableId(value = "income_id", type = IdType.ID_WORKER_STR)
    private String incomeId;

    @ApiModelProperty(value = "账务收入类型")
    private Integer incomeTypeId;

    @ApiModelProperty(value = "账务收入日期")
    private Date incomeDate;

    @ApiModelProperty(value = "账务收入金额")
    private Integer incomeAmount;

    @ApiModelProperty(value = "账务操作员")
    private String incomeSatff;

    @ApiModelProperty(value = "备注")
    private String incomeInfo;

    @ApiModelProperty(value = "对应用户id")
    private String customerId;

    @ApiModelProperty(value = "逻辑删除 1（true）已删除， 0（false）未删除")
    @TableLogic
    private Boolean isDeleted;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;


}

package com.msr.serviceaccount.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.alibaba.excel.annotation.ExcelProperty;
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
    @ExcelProperty(value = "收入账务ID",index = 0)
    @Excel(name = "收入账务ID", width = 30, type = 10)
    private String incomeId;

    @ApiModelProperty(value = "账务收入类型")
    @ExcelProperty(value = "账务收入类型",index = 1)
    @Excel(name = "账务收入类型", width = 30, type = 10)
    private Integer incomeTypeId;

    @ApiModelProperty(value = "账务收入日期",example ="2019-01-01 10:10:10")
    @TableField(fill = FieldFill.INSERT)
    @ExcelProperty(value = "账务收入日期",index = 2)
    @Excel(name = "账务收入日期", width = 30, type = 10)
    private Date incomeDate;

    @ApiModelProperty(value = "账务收入金额")
    @ExcelProperty(value = "账务收入金额",index = 3)
    @Excel(name = "账务收入金额", width = 30, type = 10)
    private Integer incomeAmount;

    @ApiModelProperty(value = "账务操作员")
    @ExcelProperty(value = "账务操作员",index = 4)
    @Excel(name = "账务操作员", width = 30, type = 10)
    private String incomeStaff;

    @ApiModelProperty(value = "备注")
    @ExcelProperty(value = "备注",index = 5)
    @Excel(name = "备注", width = 30, type = 10)
    private String incomeInfo;

    @ApiModelProperty(value = "对应用户id")
    @ExcelProperty(value = "客户ID",index = 6)
    @Excel(name = "客户ID", width = 30, type = 10)
    private String customerId;

    @ApiModelProperty(value = "逻辑删除 1（true）已删除， 0（false）未删除")
    @TableLogic
    @ExcelProperty(value = "逻辑删除",index = 7)
    @Excel(name = "逻辑删除", width = 30, type = 10)
    private Boolean isDeleted;

    @ApiModelProperty(value = "创建时间",example ="2019-01-01 10:10:10" )
    @TableField(fill = FieldFill.INSERT)
    @ExcelProperty(value = "创建时间",index = 8)
    @Excel(name = "创建时间", width = 30, type = 10)
    private Date gmtCreate;

    @ApiModelProperty(value = "更新时间",example ="2019-01-01 10:10:10")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @ExcelProperty(value = "更新时间",index = 9)
    @Excel(name = "更新时间", width = 30, type = 10)
    private Date gmtModified;


}

package com.msr.serviceaccount.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
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
@ApiModel(value="HotelConsume对象", description="")
@AllArgsConstructor
@NoArgsConstructor
public class HotelConsume implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "消费账务ID，主键")
    @TableId(value = "consume_id", type = IdType.ID_WORKER_STR)
    @ExcelProperty("消费账务ID")
//    @Excel(name = "消费账务ID", width = 30, type = 10)
    private String consumeId;

    @ApiModelProperty("账务消费类型")
    @ExcelProperty(value = "账务消费类型")
//    @Excel(name = "账务消费类型", width = 30, type = 10)
    private Integer consumeTypeId;

    @ApiModelProperty(value = "账务消费日期",example ="2019-01-01 10:10:10")
    @TableField(fill = FieldFill.INSERT)
    @ExcelProperty("账务消费日期")
    @DateTimeFormat("yyyy-MM-dd HH:mm:ss")
//    @Excel(name = "账务消费日期", width = 30, type = 10)
    private Date consumeDate;

    @ApiModelProperty(value = "账务金额")
    @ExcelProperty("账务金额")
//    @Excel(name = "账务金额", width = 30, type = 10)
    private Integer consumeAmount;

    @ApiModelProperty(value = "账务操作员")
    @ExcelProperty("账务操作员")
//    @Excel(name = "账务操作员", width = 30, type = 10)
    private String consumeStaff;

    @ApiModelProperty(value = "备注")
    @ExcelProperty("备注")
//    @Excel(name = "备注", width = 30, type = 10)
    private String consumeInfo;

    @ApiModelProperty(value = "对应用户id")
    @ExcelProperty("客户ID")
//    @Excel(name = "客户ID", width = 30, type = 10)
    private String customerId;

    @ApiModelProperty(value = "逻辑删除 1（true）已删除， 0（false）未删除")
    @TableLogic
    @ExcelProperty("逻辑删除")
//    @Excel(name = "逻辑删除", width = 30, type = 10)
    private Boolean isDeleted;

    @ApiModelProperty(value = "创建时间",example ="2019-01-01 10:10:10")
    @TableField(fill = FieldFill.INSERT)
    @DateTimeFormat("yyyy-MM-dd HH:mm:ss")
    @ExcelProperty("创建时间")
//    @Excel(name = "创建时间", width = 30, type = 10)
    private Date gmtCreate;

    @ApiModelProperty(value = "更新时间",example ="2019-01-01 10:10:10") // ,example = "2019-01-01 8:00:00 "
    @DateTimeFormat("yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @ExcelProperty("更新时间")
//    @Excel(name = "更新时间", width = 30, type = 10)
    private Date gmtModified;
}

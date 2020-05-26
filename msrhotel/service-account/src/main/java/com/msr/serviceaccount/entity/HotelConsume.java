package com.msr.serviceaccount.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
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
@ApiModel(value="HotelConsume对象", description="")
public class HotelConsume implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "消费账务ID，主键")
    @TableId(value = "consume_id", type = IdType.ID_WORKER_STR)
    private String consumeId;

    @ApiModelProperty(value = "账务消费类型")
    private Integer consumeTypeId;

    @ApiModelProperty(value = "账务消费日期",example ="2019-01-01 10:10:10")
    @TableField(fill = FieldFill.INSERT)
    private Date consumeDate;

    @ApiModelProperty(value = "账务金额")
    private Integer consumeAmount;

    @ApiModelProperty(value = "账务操作员")
    private String consumeStaff;

    @ApiModelProperty(value = "备注")
    private String consumeInfo;

    @ApiModelProperty(value = "对应用户id")
    private String customerId;

    @ApiModelProperty(value = "逻辑删除 1（true）已删除， 0（false）未删除")
    @TableLogic
    private Boolean isDeleted;

    @ApiModelProperty(value = "创建时间",example ="2019-01-01 10:10:10")
    @TableField(fill = FieldFill.INSERT)
    // @JsonFormat( pattern="yyyy-MM-dd HH:mm:ss")
    private Date gmtCreate;

    @ApiModelProperty(value = "更新时间",example ="2019-01-01 10:10:10") // ,example = "2019-01-01 8:00:00 "
    // @JsonFormat( pattern="yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;
}

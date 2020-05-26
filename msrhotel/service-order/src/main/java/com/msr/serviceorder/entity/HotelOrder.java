package com.msr.serviceorder.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.time.LocalDate;
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
@ApiModel(value="HotelOrder对象", description="")
public class HotelOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "预订信息ID")
    @TableId(value = "order_id", type = IdType.ID_WORKER_STR)
    private String orderId;

    @ApiModelProperty(value = "客户身份证")
    private String customerId;

    @ApiModelProperty(value = "客户入住天数")
    private Integer orderDays;

    @ApiModelProperty(value = "预订的客房类型")
    private Integer orderType;

    @ApiModelProperty(value = "预订的入住日期")
    private LocalDate inDate;

    @ApiModelProperty(value = "预订的退房日期")
    private LocalDate outDate;

    @ApiModelProperty(value = "备注")
    private String orderInfo;

    @TableLogic
    @ApiModelProperty(value = "逻辑删除 1（true）已删除， 0（false）未删除")
    private Integer isDeleted;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @ApiModelProperty(value = "修改时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;


}

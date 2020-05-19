package com.msr.servicecustomerinfo.entity;

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
@ApiModel(value="HotelCustomerinfo对象", description="")
public class HotelCustomerinfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "客户身份证")
    @TableId(value = "customer_id", type = IdType.ID_WORKER_STR)
    private String customerId;

    @ApiModelProperty(value = "客户联系电话")
    private String customerinfoTel;

    @ApiModelProperty(value = "客户生日")
    private Date customerinfoBirthday;

    @ApiModelProperty(value = "客户姓名")
    private String customerName;

    @ApiModelProperty(value = "备注")
    private String customerinfoInfo;

    @ApiModelProperty(value = "逻辑删除 1（true）已删除， 0（false）未删除")
    @TableLogic
    private Boolean isDeleted;

    @ApiModelProperty(value = "创建时间",example = "2019-01-01 8:00:00")
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @ApiModelProperty(value = "更新时间",example = "2019-01-01 8:00:00")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;

}

package com.msr.hotel.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
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
@TableName("hotel_customer")
@ApiModel(value="Customer对象", description="")
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "客户身份证号码")
    @TableId(value = "customer_id", type = IdType.ID_WORKER_STR)
    private String customerId;

    @ApiModelProperty(value = "客户入住房间号")
    private Integer inRoom;

    @ApiModelProperty(value = "客户入住日期")
    private Date inDate;

    @ApiModelProperty(value = "入住时收取的房费")
    private Integer customerRent;

    @ApiModelProperty(value = "入住时收取的押金")
    private Integer customerDeposit;

    @ApiModelProperty(value = "入住时的退房时间")
    private Date outDate;

    @ApiModelProperty(value = "备注")
    private String customerInfo;

    @ApiModelProperty(value = "逻辑删除 1（true）已删除， 0（false）未删除")
    private Boolean isDeleted;

    @ApiModelProperty(value = "创建时间")
    private Date gmtCreate;

    @ApiModelProperty(value = "更新时间")
    private Date gmtModified;


}

package com.msr.serviceroom.entity;

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
@ApiModel(value="HotelRoom对象", description="")
public class HotelRoom implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "房间号")
    @TableId(value = "room_num", type = IdType.ID_WORKER_STR)
    private String roomNum;

    @ApiModelProperty(value = "房间类型")
    private Integer roomType;

    @ApiModelProperty(value = "价格")
    private String roomPrice;

    @ApiModelProperty(value = "房态")
    private String roomState;

    @ApiModelProperty(value = "备注")
    private Date info;

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

package com.msr.servicestaff.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
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
@ApiModel(value="HotelStaff对象", description="")
public class HotelStaff implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "员工ID")
    @TableId(value = "staff_id", type = IdType.ID_WORKER_STR)
    private String staffId;

    @ApiModelProperty(value = "员工姓名")
    private String staffName;

    @ApiModelProperty(value = "身份证")
    private String staffIdcard;

    @ApiModelProperty(value = "员工所属部门")
    private Integer staffEmp;

    @ApiModelProperty(value = "员工职位")
    private Integer staffPosition;

    @ApiModelProperty(value = "员工入职日期")
    private Date staffDate;

    @ApiModelProperty(value = "员工基本工资")
    private Integer staffSalary;

    @ApiModelProperty(value = "员工奖金")
    private Integer staffBonus;

    @ApiModelProperty(value = "备注")
    private String staffInfo;

    @ApiModelProperty(value = "逻辑删除 1（true）已删除， 0（false）未删除")
    private Boolean isDeleted;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @ApiModelProperty(value = "修改时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;


}

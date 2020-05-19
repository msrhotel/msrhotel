package com.msr.servicestaff.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@ApiModel(value = "Staff查询对象", description = "员工查询对象封装")
@Data
public class StaffQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "员工名称,模糊查询")
    private String name;

    @ApiModelProperty(value = "员工所属部门 1.经理部 2.财务部 3.人事部 4.运营部 5.总务部")
    private Integer emp;

    @ApiModelProperty(value = "员工所在职位 11.经理 12.经理秘书 21.会计 22.出纳 31.人事主管 32.人事部员" +
            "42.前台操作员 51.总务部部长 52.清洁员工")
    private Integer position;

    @ApiModelProperty(value = "查询开始时间", example = "2019-01-01 10:10:10")
    private String begin;//注意，这里使用的是String类型，前端传过来的数据无需进行类型转换

    @ApiModelProperty(value = "查询结束时间", example = "2019-12-01 10:10:10")
    private String end;
}


package com.msr.serviceaccount.entity.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="ConsumeExcelEntity对象", description="")
public class ConsumeExcelEntity {
    private static final long serialVersionUID = 1L;

    @ExcelProperty(value = "客户ID",index = 0)
    private String customerId;

    @TableId(value = "consume_id", type = IdType.ID_WORKER_STR)
    @Excel(name = "消费账务ID", width = 30, type = 10)
    @ExcelProperty(value ="消费账务ID",index = 1)
    private String consumeId;

    @ExcelProperty(value ="消费金额",index = 2)
    @Excel(name = "消费金额", width = 30, type = 10)
    private Integer consumeAmount;

    @ExcelProperty(value ="操作人员",index = 3)
    @Excel(name = "操作人员", width = 30, type = 10)
    private String consumeSatff;

    @ExcelProperty(value ="消费类型ID",index = 4)
    @Excel(name = "消费类型ID", width = 30, type = 10)
    private Integer consumeTypeId;

    @ExcelProperty(value ="消费日期",index = 5 , format = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "消费日期", width = 30, type = 10)
    private Date consumeDate;

    @ExcelProperty(value ="备注",index = 6)
    @Excel(name = "备注", width = 30, type = 10)
    private String consumeInfo;

    @ExcelProperty(value ="逻辑删除",index = 7)
    @Excel(name = "逻辑删除", width = 30, type = 10)
    private Boolean isDeleted;

    @ExcelProperty(value ="创建时间",index = 8,format = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "创建时间", width = 30, type = 10)
    private Date gmtCreate;

    @ExcelProperty(value ="修改时间",index = 9,format = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "修改时间", width = 30, type = 10)
    private Date gmtModified;

}

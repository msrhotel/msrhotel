package com.msr.serviceaccount.entity.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.annotations.ApiModel;
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

    @ExcelProperty("客户ID")
//    @Excel(name = "客户ID", width = 30 , needMerge = true)
    private String customerId;

    @ExcelProperty("消费账务ID")
//    @Excel(name = "消费账务ID", width = 30 , needMerge = true)
    private String consumeId;

    @ExcelProperty("消费金额")
//    @Excel(name = "消费金额", width = 30 , needMerge = true)
    private Integer consumeAmount;

    @ExcelProperty("操作人员")
//    @Excel(name = "操作人员", width = 30 , needMerge = true)
    private String consumeSatff;

    @ExcelProperty("消费类型ID")
//    @Excel(name = "消费类型ID", width = 30 , needMerge = true)
    private Integer consumeTypeId;

    @ExcelProperty("消费日期")
//    @Excel(name = "消费日期", width = 30 , needMerge = true, format = "yyyy-MM-dd")
    private Date consumeDate;

    @ExcelProperty("备注")
//    @Excel(name = "备注", width = 30 , needMerge = true)
    private String consumeInfo;


}

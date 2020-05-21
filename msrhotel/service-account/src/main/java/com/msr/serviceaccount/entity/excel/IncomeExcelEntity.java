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
@ApiModel(value="IncomeExcelEntity对象", description="")
public class IncomeExcelEntity {
    private static final long serialVersionUID = 1L;

    @ExcelProperty("客户ID")
    private String customerId;

    @ExcelProperty("客户ID")
    private String incomeId;

    @ExcelProperty("客户ID")
    private Integer incomeAmount;

    @ExcelProperty("客户ID")
    private String incomeSatff;

    @ExcelProperty("客户ID")
    private Integer incomeTypeId;

    @ExcelProperty("客户ID")
    private Date incomeDate;

    @ExcelProperty("客户ID")
    private String incomeInfo;

}

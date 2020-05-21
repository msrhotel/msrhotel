package com.msr.serviceaccount.entity.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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

    @ExcelProperty("收入账务ID")
    @TableId(value = "consume_id", type = IdType.ID_WORKER_STR)
    private String incomeId;

    @ExcelProperty("收入金额")
    private Integer incomeAmount;

    @ExcelProperty("操作人员")
    private String incomeSatff;

    @ExcelProperty("收入类型")
    private Integer incomeTypeId;

    @ExcelProperty("收入日期")
    private Date incomeDate;

    @ExcelProperty("备注")
    private String incomeInfo;

}

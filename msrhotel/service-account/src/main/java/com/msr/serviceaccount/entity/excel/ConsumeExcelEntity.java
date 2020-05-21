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
@ApiModel(value="ConsumeExcelEntity对象", description="")
public class ConsumeExcelEntity {
    private static final long serialVersionUID = 1L;

    @ExcelProperty(value = "客户ID",index = 0)
//    @Excel(name = "客户ID", width = 30 , needMerge = true)
    private String customerId;

    @TableId(value = "consume_id", type = IdType.ID_WORKER_STR)
    @ExcelProperty(value ="消费账务ID",index = 1)
//    @Excel(name = "消费账务ID", width = 30 , needMerge = true)
    private String consumeId;

    @ExcelProperty(value ="消费金额",index = 2)
//    @Excel(name = "消费金额", width = 30 , needMerge = true)
    private Integer consumeAmount;

    @ExcelProperty(value ="操作人员",index = 3)
//    @Excel(name = "操作人员", width = 30 , needMerge = true)
    private String consumeSatff;

    @ExcelProperty(value ="消费类型ID",index = 4)
//    @Excel(name = "消费类型ID", width = 30 , needMerge = true)
    private Integer consumeTypeId;

    @ExcelProperty(value ="消费日期",index = 5)
//    @Excel(name = "消费日期", width = 30 , needMerge = true, format = "yyyy-MM-dd")
    private Date consumeDate;

    @ExcelProperty(value ="备注",index = 6)
//    @Excel(name = "备注", width = 30 , needMerge = true)
    private String consumeInfo;


}

package com.msr.serviceaccount.controller;

import com.alibaba.excel.EasyExcel;
import com.msr.common.msrUtil.R;
import com.msr.serviceaccount.entity.excel.IncomeExcelEntity;
import com.msr.serviceaccount.service.IncomeExcelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author msr
 * @since 2020-05-18
 */
@CrossOrigin // 跨域
@Api(description = "收入报表导入导出")
@RestController
@RequestMapping("/serviceaccount/income/excel")
public class IncomeExcelController {
    @Autowired
    private IncomeExcelService incomeExcelService;
    // 导出
    @ApiOperation(value = "根据客户ID导出对应收入报表信息")
    @GetMapping("/exportIncomes/{cutomerId}")
    public R exportByCustomerId(HttpServletResponse response,
                                @ApiParam(name = "cutomerId", value = "客户ID", required = true)
                                @PathVariable String cutomerId
    ){
        List<IncomeExcelEntity> incomeList = incomeExcelService.getIncomes(cutomerId);

//        System.out.println(incomeList); // 拿到数据
        SimpleDateFormat tempDate = new SimpleDateFormat("yyyyMMddHHmmss");
        String datetime = tempDate.format(new java.util.Date());
        String fileName = "F:\\account\\income\\" + datetime +  ".xlsx";
        EasyExcel.write(fileName, IncomeExcelEntity.class).sheet("写入方法一").doWrite(incomeList);
        return R.ok();
    }
}

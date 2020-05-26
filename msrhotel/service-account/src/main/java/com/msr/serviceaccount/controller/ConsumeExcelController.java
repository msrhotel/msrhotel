package com.msr.serviceaccount.controller;


import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.alibaba.excel.EasyExcel;
import com.msr.common.msrUtil.R;
import com.msr.serviceaccount.entity.excel.ConsumeExcelEntity;
import com.msr.serviceaccount.service.ConsumeExcelService;
import com.msr.serviceaccount.util.ExcelUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.text.SimpleDateFormat;
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
@Api(description = "消费报表导入导出")
@RestController
@RequestMapping("/serviceaccount/consume/excel")
public class ConsumeExcelController {


    @Autowired
    private ConsumeExcelService consumeExcelService;
    // 导出
    @ApiOperation(value = "根据客户ID导出对应消费报表信息")
    @GetMapping("/exportConsumes/{cutomerId}")
    public R exportByCustomerId(HttpServletResponse response,
            @ApiParam(name = "cutomerId", value = "客户ID", required = true)
            @PathVariable String cutomerId
    ){
        List<ConsumeExcelEntity> consumeList = consumeExcelService.getConsumes(cutomerId);
        System.out.println(consumeList); // 拿到数据
        SimpleDateFormat tempDate = new SimpleDateFormat("yyyyMMddHHmmss");
        String datetime = tempDate.format(new java.util.Date());
        String fileName = "F:\\account\\consume\\"+ datetime +".xlsx";
        EasyExcel.write(fileName, ConsumeExcelEntity.class).sheet("写入方法一").doWrite(consumeList);
        return R.ok();
    }
    // 导入
    @ApiOperation(value = "批量导入消费报表信息")
    @PostMapping("import")
    public R importExcel(@RequestParam("file") MultipartFile file){
        //解析excel

        List<ConsumeExcelEntity> consumeList = ExcelUtils.importExcel(file,ConsumeExcelEntity.class);

        //也可以使用MultipartFile,使用 FileUtil.importExcel(MultipartFile file, Integer titleRows, Integer headerRows, Class<T> pojoClass)导入
        System.out.println("导入数据一共【"+consumeList.size()+"】行");
        System.out.println(consumeList);

        //TODO 保存数据库
        consumeExcelService.importConsumeData(consumeList);
        return R.ok();
    }
}

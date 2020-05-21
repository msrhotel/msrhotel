package com.msr.serviceaccount.controller;


import com.alibaba.excel.EasyExcel;
import com.msr.common.msrUtil.R;
import com.msr.serviceaccount.entity.excel.ConsumeExcelEntity;
import com.msr.serviceaccount.listener.ConsumeExcelListener;
import com.msr.serviceaccount.service.ConsumeExcelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
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
@RequestMapping("/hotel/consume/excel")
public class ConsumeExcelController {


    @Autowired
    private ConsumeExcelService consumeExcelService;
    // 导出
    @ApiOperation(value = "根据客户ID导出对应收入报表信息")
    @GetMapping("/exportConsumes/{cutomerId}")
    public R exportByCustomerId(HttpServletResponse response,
            @ApiParam(name = "cutomerId", value = "客户ID", required = true)
            @PathVariable String cutomerId
    ){
        List<ConsumeExcelEntity> consumeList = consumeExcelService.getConsumes(cutomerId);
        System.out.println(consumeList); // 拿到数据
        String fileName = "F:\\"+ cutomerId+".xlsx";
        EasyExcel.write(fileName, ConsumeExcelEntity.class).sheet("写入方法一").doWrite(consumeList);
        return R.ok();
    }
//    // 导入
//    @PostMapping("addSubject")
//    public R importConsumeExcel(MultipartFile file) {
//        //上传过来excel文件
//        consumeExcelService.insertConsumeData(file, consumeExcelService);
//        return R.ok();
//    }
}

package com.msr.serviceaccount.controller;


import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msr.common.msrUtil.R;
import com.msr.common.utils.Query;
import com.msr.serviceaccount.entity.HotelConsume;
import com.msr.serviceaccount.entity.excel.ConsumeExcelEntity;
import com.msr.serviceaccount.listener.ConsumeExcelListener;
import com.msr.serviceaccount.mapper.HotelConsumeMapper;
import com.msr.serviceaccount.query.ConsumeQuery;
import com.msr.serviceaccount.query.CustomerIdQuery;
import com.msr.serviceaccount.service.HotelConsumeService;
import com.msr.serviceaccount.util.ExcelListener;
import com.msr.serviceaccount.util.ExcelUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.security.PrivateKey;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author msr
 * @since 2020-05-18
 */
@CrossOrigin // 跨域
@Api(description = "消费报表信息管理")
@RestController
@RequestMapping("/serviceaccount/consume")
public class HotelConsumeController {
    @Autowired
    private HotelConsumeService consumeService;


    private final static Logger logger = LoggerFactory.getLogger(HotelConsumeController.class);

    @ApiOperation("批量导入")
    @PostMapping("importAll")
    public R importConsume(@RequestParam(value = "file" ) MultipartFile file) throws IOException { // )
        AnalysisEventListener<HotelConsume> consumeAnalysisEventListener = ExcelUtil.getListener(this.batchInsert(),2);
        EasyExcel.read(file.getInputStream(),HotelConsume.class,consumeAnalysisEventListener).sheet().doRead();
        return R.ok();
    }
    private Consumer<List<HotelConsume>> batchInsert(){
        return consume -> consumeService.saveData(consume);
    }
    @ApiOperation("批量导出所有信息")
    @GetMapping("exportAll")
    public R list(HttpServletResponse response) {
        List<HotelConsume> list = consumeService.list(null);
        SimpleDateFormat tempDate = new SimpleDateFormat("yyyyMMddHHmmss");
        String datetime = tempDate.format(new java.util.Date());
        String fileName = "F:\\account\\consume\\" + "消费报表_" + datetime + ".xlsx";
        EasyExcel.write(fileName, HotelConsume.class).sheet("写入方法一").doWrite(list);
        return R.ok();
    }


    @ApiOperation(value = "新增消费报表")
    @PostMapping("save")
    public R save(
            @ApiParam(name = "consume", value = "消费报表对象", required = true)
            @RequestBody HotelConsume consume) {
        System.out.println(consume);
        consumeService.save(consume);
        return R.ok();
    }

    @ApiOperation(value = "根据账单ID删除收入消费报表")
    @DeleteMapping("delete/{consumeId}")
    public R removeById(
            @ApiParam(name = "consumeId", value = "账户ID", required = true)
            @PathVariable String consumeId) {
        consumeService.removeById(consumeId);
        return R.ok();
    }

    @ApiOperation(value = "根据账务ID修改消费报表")
    @PostMapping("update")
    public R updateById(
//            @ApiParam(name = "consumeId", value = "账务ID", required = true)
//            @PathVariable String consumeId,

            @ApiParam(name = "consume", value = "账务信息对象", required = true)
            @RequestBody HotelConsume consume) {

//        consume.setConsumeId(consumeId);
        consumeService.updateById(consume);
        return R.ok();
    }

    @ApiOperation(value = "根据账务ID查询消费报表")
    @GetMapping("{consumeId}")
    public R getById(
            @ApiParam(name = "consumeId", value = "账务ID", required = true)
            @PathVariable String consumeId) {

        HotelConsume consume = consumeService.getById(consumeId);
        return R.ok().data("item", consume);
    }

    @ApiOperation(value = "根据客户ID查询消费报表")
    @GetMapping("customer/{customerId}")
    public R getByCustomerId(
            @ApiParam(name = "customerId", value = "客户ID", required = true)
            @PathVariable String customerId) {

        List<HotelConsume> list = consumeService.getByCustomerId(customerId);
        System.out.println(list);
        return R.ok().data("item", list);
    }

//    @ApiOperation(value = "根据客户ID查询消费报表分页列表")
//    @GetMapping("{page}/{limit}")
//    public R getByCustomerId(
//            @ApiParam(name = "page", value = "当前页码", required = true)
//            @PathVariable Long page,
//
//            @ApiParam(name = "limit", value = "每页记录数", required = true)
//            @PathVariable Long limit,
//
//            @ApiParam(name = "customerIdQuery", value = "查询对象", required = false)
//                    CustomerIdQuery customerIdQuery){
//
//        Page<HotelConsume> pageParam = new Page<>(page, limit);
//
//        consumeService.getByCustomerId(pageParam,customerIdQuery);
//        List<HotelConsume> records = pageParam.getRecords();
//        long total = pageParam.getTotal();
//
//        return  R.ok().data("total", total).data("rows", records);
//    }

    @ApiOperation(value = "消费报表分页列表")
    @GetMapping("{page}/{limit}")
    public R pageQuery(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,

            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit,

            @ApiParam(name = "consumeQuery", value = "查询对象", required = false)
                    ConsumeQuery consumeQuery) {

        Page<HotelConsume> pageParam = new Page<>(page, limit);

        consumeService.pageQuery(pageParam, consumeQuery);
        List<HotelConsume> records = pageParam.getRecords();
        long total = pageParam.getTotal();

        return R.ok().data("total", total).data("rows", records);
    }


}


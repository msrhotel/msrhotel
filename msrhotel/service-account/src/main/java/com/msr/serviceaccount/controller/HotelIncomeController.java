package com.msr.serviceaccount.controller;


import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msr.common.msrUtil.R;
import com.msr.serviceaccount.entity.HotelConsume;
import com.msr.serviceaccount.entity.HotelIncome;
import com.msr.serviceaccount.entity.excel.ConsumeExcelEntity;
import com.msr.serviceaccount.mapper.HotelConsumeMapper;
import com.msr.serviceaccount.query.IncomeCustomerIdQuery;
import com.msr.serviceaccount.query.IncomeQuery;
import com.msr.serviceaccount.service.HotelIncomeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
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
@Api(description = "收入报表")
@CrossOrigin // 跨域
@RestController
@RequestMapping("/serviceaccount/income")
public class HotelIncomeController {

    @Autowired
    private HotelIncomeService incomeService;

    @ApiOperation("批量导出所有收入信息")
    @GetMapping("exportAll")
    public R list(HttpServletResponse response){
        List<HotelIncome> list = incomeService.list(null);
        SimpleDateFormat tempDate = new SimpleDateFormat("yyyyMMddHHmmss");
        String datetime = tempDate.format(new java.util.Date());
        String fileName = "F:\\account\\income\\"+ "收入报表_" + datetime +".xlsx";
        EasyExcel.write(fileName, HotelIncome.class).sheet("写入方法一").doWrite(list);
        return R.ok();
    }

    @ApiOperation(value = "新增收入报表信息")
    @PostMapping("save")
    public R save(
            @ApiParam(name = "income", value = "收入报表信息对象", required = true)
            @RequestBody HotelIncome income){
        System.out.println(income);
        incomeService.save(income);
        return R.ok();
    }

    @ApiOperation(value = "根据账单ID删除收入收入报表信息")
    @DeleteMapping("delete/{incomeId}")
    public R removeById(
            @ApiParam(name = "incomeId", value = "账户ID", required = true)
            @PathVariable String incomeId){
        incomeService.removeById(incomeId);
        return R.ok();
    }

    @ApiOperation(value = "根据账务ID修改收入报表信息")
    @PostMapping("update")
    public R updateById(
//            @ApiParam(name = "id", value = "账务ID", required = true)
//            @PathVariable String id,

            @ApiParam(name = "income", value = "收入报表信息对象", required = true)
            @RequestBody HotelIncome income) {

//        income.setIncomeId(id);
        incomeService.updateById(income);
        return R.ok();
    }

    @ApiOperation(value = "根据账务ID查询收入报表信息")
    @GetMapping("{incomeId}")
    public R getById(
            @ApiParam(name = "incomeId", value = "账务ID", required = true)
            @PathVariable String incomeId){

        HotelIncome income = incomeService.getById(incomeId);
        return R.ok().data("item", income);
    }
    @ApiOperation(value = "根据客户ID查询消费报表")
    @GetMapping("customer/{customerId}")
    public R getByCustomerId(
            @ApiParam(name = "customerId", value = "客户ID", required = true)
            @PathVariable String customerId){

        List<HotelConsume> list = incomeService.getByCustomerId(customerId);
        System.out.println(list);
        return R.ok().data("item", list);
    }
//
//    @ApiOperation(value = "根据客户ID查询收入报表信息")
//    @GetMapping("{page}/{limit}")
//    public R getByCustomerId(
//            @ApiParam(name = "page", value = "当前页码", required = true)
//            @PathVariable Long page,
//
//            @ApiParam(name = "limit", value = "每页记录数", required = true)
//            @PathVariable Long limit,
//
//            @ApiParam(name = "incomeCustomerIdQuery", value = "查询对象", required = false)
//                    IncomeCustomerIdQuery incomeCustomerIdQuery){
//
//        Page<HotelIncome> pageParam = new Page<>(page, limit);
//
//        incomeService.getIncomeByCustomerId(pageParam,incomeCustomerIdQuery);
//        List<HotelIncome> records = pageParam.getRecords();
//        long total = pageParam.getTotal();
//
//        return  R.ok().data("total", total).data("rows", records);
//    }

    @ApiOperation(value = "收入报表")
    @GetMapping("{page}/{limit}")
    public R pageQuery(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,

            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit,

            @ApiParam(name = "incomeQuery", value = "查询对象", required = false)
                    IncomeQuery incomeQuery){

        Page<HotelIncome> pageParam = new Page<>(page, limit);

        incomeService.pageQuery(pageParam, incomeQuery);
        List<HotelIncome> records = pageParam.getRecords();
        long total = pageParam.getTotal();

        return  R.ok().data("total", total).data("rows", records);
    }

}


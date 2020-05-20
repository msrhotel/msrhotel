package com.msr.serviceaccount.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msr.common.msrUtil.R;
import com.msr.serviceaccount.entity.HotelIncome;
import com.msr.serviceaccount.mapper.HotelConsumeMapper;
import com.msr.serviceaccount.query.IncomeCustomerIdQuery;
import com.msr.serviceaccount.query.IncomeQuery;
import com.msr.serviceaccount.service.HotelIncomeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/hotel/income")
public class HotelIncomeController {

    @Autowired
    private HotelIncomeService incomeService;

    private HotelConsumeMapper consumeMapper;
    @ApiOperation("所有收入报表信息")
    @GetMapping("findAll")
    public R list(){
        List<HotelIncome> list = incomeService.list(null);
        return R.ok().data("incomes",list);
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
    @DeleteMapping("{id}")
    public R removeById(
            @ApiParam(name = "id", value = "账户ID", required = true)
            @PathVariable String id){
        incomeService.removeById(id);
        return R.ok();
    }

    @ApiOperation(value = "根据账务ID修改收入报表信息")
    @PutMapping("{id}")
    public R updateById(
            @ApiParam(name = "id", value = "账务ID", required = true)
            @PathVariable String id,

            @ApiParam(name = "income", value = "收入报表信息对象", required = true)
            @RequestBody HotelIncome income) {

        income.setIncomeId(id);
        incomeService.updateById(income);
        return R.ok();
    }

    @ApiOperation(value = "根据账务ID查询收入报表信息")
    @GetMapping("{id}")
    public R getById(
            @ApiParam(name = "id", value = "账务ID", required = true)
            @PathVariable String id){

        HotelIncome income = incomeService.getById(id);
        return R.ok().data("items", income);
    }

    @ApiOperation(value = "根据客户ID查询收入报表信息")
    @GetMapping("{page}/{limit}")
    public R getByCustomerId(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,

            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit,

            @ApiParam(name = "incomeCustomerIdQuery", value = "查询对象", required = false)
                    IncomeCustomerIdQuery incomeCustomerIdQuery){

        Page<HotelIncome> pageParam = new Page<>(page, limit);

        incomeService.getIncomeByCustomerId(pageParam,incomeCustomerIdQuery);
        List<HotelIncome> records = pageParam.getRecords();
        long total = pageParam.getTotal();

        return  R.ok().data("total", total).data("rows", records);
    }

    @ApiOperation(value = "收入报表")
    @GetMapping("page/{page}/{limit}")
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


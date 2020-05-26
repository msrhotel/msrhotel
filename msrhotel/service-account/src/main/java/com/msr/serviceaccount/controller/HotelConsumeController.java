package com.msr.serviceaccount.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msr.common.msrUtil.R;
import com.msr.common.utils.Query;
import com.msr.serviceaccount.entity.HotelConsume;
import com.msr.serviceaccount.mapper.HotelConsumeMapper;
import com.msr.serviceaccount.query.ConsumeQuery;
import com.msr.serviceaccount.query.CustomerIdQuery;
import com.msr.serviceaccount.service.HotelConsumeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.PrivateKey;
import java.util.ArrayList;
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
@Api(description = "消费报表信息管理")
@RestController
@RequestMapping("/serviceaccount/consume")
public class HotelConsumeController {
    @Autowired
    private HotelConsumeService consumeService;

    private HotelConsumeMapper consumeMapper;
    @ApiOperation("所有消费报表信息")
    @GetMapping("findAll")
    public R list(){
        List<HotelConsume> list = consumeService.list(null);
        return R.ok().data("consumes",list);
    }

    @ApiOperation(value = "新增消费报表")
    @PostMapping("save")
    public R save(
            @ApiParam(name = "consume", value = "消费报表对象", required = true)
            @RequestBody HotelConsume consume){
        System.out.println(consume);
        consumeService.save(consume);
        return R.ok();
    }

    @ApiOperation(value = "根据账单ID删除收入消费报表")
    @DeleteMapping("delete/{consumeId}")
    public R removeById(
            @ApiParam(name = "consumeId", value = "账户ID", required = true)
            @PathVariable String consumeId){
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
            @PathVariable String consumeId){

        HotelConsume consume = consumeService.getById(consumeId);
        return R.ok().data("item", consume);
    }
    @ApiOperation(value = "根据客户ID查询消费报表")
    @GetMapping("customer/{customerId}")
    public R getByCustomerId(
            @ApiParam(name = "customerId", value = "客户ID", required = true)
            @PathVariable String customerId){

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
                    ConsumeQuery consumeQuery){

        Page<HotelConsume> pageParam = new Page<>(page, limit);

        consumeService.pageQuery(pageParam, consumeQuery);
        List<HotelConsume> records = pageParam.getRecords();
        long total = pageParam.getTotal();

        return  R.ok().data("total", total).data("rows", records);
    }


}


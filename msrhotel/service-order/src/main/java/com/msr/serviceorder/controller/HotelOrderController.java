package com.msr.serviceorder.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msr.common.msrUtil.R;
import com.msr.serviceorder.entity.HotelOrder;
import com.msr.serviceorder.query.HotelOrderQuery;
import com.msr.serviceorder.service.HotelOrderService;
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
@Api(description = "预订订单列表")
@CrossOrigin
@RestController
@RequestMapping("/serviceorder/order")
public class HotelOrderController {
    @Autowired
    private HotelOrderService hotelOrderService;

    @ApiOperation(value = "所有订单信息列表")
    @GetMapping("/list")
    public R list(){
        List<HotelOrder> list = hotelOrderService.list(null);
        return R.ok().data("hotelOrders", list);
    }

    @ApiOperation(value = "根据ID删除订单信息")
    @DeleteMapping("{id}")
    public  R removeById(
            @ApiParam(name = "id", value = "订单ID", required = true)
            @PathVariable String id){
        boolean result = hotelOrderService.removeById(id);
        if(result){
            return R.ok();
        }else{
            return R.error().message("删除失败");
        }
    }

    @ApiOperation(value = "分页订单列表")
    @GetMapping("{page}/{limit}")
    public R pageQuery(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,

            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit,

            @ApiParam(name = "hotelOrderQuery", value = "查询对象", required = false)
                    HotelOrderQuery hotelOrderQuery){

        Page<HotelOrder> pageParam = new Page<>(page, limit);

        hotelOrderService.pageQuery(pageParam, hotelOrderQuery);
        List<HotelOrder> records = pageParam.getRecords();
        long total = pageParam.getTotal();

        return  R.ok().data("total", total).data("rows", records);
    }

    @ApiOperation(value = "新增订单信息")
    @PostMapping("save")
    public R save(
            @ApiParam(name = "hotelOrder", value = "订单信息对象", required = true)
            @RequestBody HotelOrder hotelOrder){

        hotelOrderService.save(hotelOrder);
        return R.ok();
    }

    @ApiOperation(value = "根据ID查询订单信息")
    @GetMapping("{id}")
    public R getById(
            @ApiParam(name = "id", value = "订单ID", required = true)
            @PathVariable String id){

        HotelOrder hotelOrder = hotelOrderService.getById(id);
        return R.ok().data("item", hotelOrder);
    }

    @ApiOperation(value = "根据ID修改订单信息")
    @PostMapping ("{id}")
    public R updateById(
            //@ApiParam(name = "id", value = "订单ID", required = true)
            //@PathVariable String id,

            @ApiParam(name = "hotelOrder", value = "订单信息对象", required = true)
            @RequestBody HotelOrder hotelOrder){

        //hotelOrder.setOrderId(id);
        hotelOrderService.updateById(hotelOrder);
        return R.ok();
    }
}


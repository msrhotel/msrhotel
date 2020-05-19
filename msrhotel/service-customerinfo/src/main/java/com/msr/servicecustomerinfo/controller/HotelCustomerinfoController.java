package com.msr.servicecustomerinfo.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msr.common.msrUtil.R;
import com.msr.servicecustomerinfo.CustomerinfoApplication;
import com.msr.servicecustomerinfo.entity.HotelCustomerinfo;
import com.msr.servicecustomerinfo.service.HotelCustomerinfoService;
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
@CrossOrigin // 跨域
@Api(description="客户信息管理")
@RestController
@RequestMapping("/servicecustomerinfo/hotel-customerinfo")
public class HotelCustomerinfoController {
    @Autowired
    private HotelCustomerinfoService HotelCustomerinfoService;

    @ApiOperation(value = "所有客户信息列表")
    @GetMapping("list")
    public R list() {
        List<HotelCustomerinfo> list = HotelCustomerinfoService.list(null);
        return R.ok().data("seervicecustomerinfo", list);
    }

    @ApiOperation(value = "根据ID删除客人入住信息")
    @DeleteMapping("{id}")
    public R removeByid(
            @ApiParam(name = "id", value = "客户ID", required = true)
            @PathVariable String id) {
        boolean result = HotelCustomerinfoService.removeById(id);
        if (result) {
            return R.ok();
        } else {
            return R.error().message("删除失败");
        }
    }
    @ApiOperation(value = "分页客户列表")
    @GetMapping("{page}/{limit}")
    public R pageList(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,

            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit,

            @ApiParam(name = "HotelCustomerinfoQuery", value = "查询对象", required = false)
                    HotelCustomerinfo HotelCustomerinfo
    ){

        System.out.println("name:"+HotelCustomerinfo.getCustomerinfoInfo());
        Page<HotelCustomerinfo> pageParam = new Page<>(page, limit);

        //teacherService.page(pageParam, null);
        HotelCustomerinfoService.page(pageParam,null);

        List<HotelCustomerinfo> records = pageParam.getRecords();

        long total = pageParam.getTotal();
        return  R.ok().data("total", total).data("rows", records);
    }

    @ApiOperation(value = "新增客户信息")
    @PostMapping("save")
    public R getById(
            @ApiParam(name = "customer", value = "客人入住信息对象", required = true)
            @RequestBody HotelCustomerinfo customer) {

        HotelCustomerinfoService.save(customer);
        return R.ok();

    }

    @ApiOperation(value = "根据ID查询客户")
    @GetMapping("{id}")
    public R getById(
            @ApiParam(name = "id", value = "客户ID", required = true)
            @PathVariable String id) {

        HotelCustomerinfo customer = HotelCustomerinfoService.getById(id);
        return R.ok().data("item", customer);
    }

    @ApiOperation(value = "根据ID修改客户信息")
    @PutMapping("{id}")
    public R updateById(
            @ApiParam(name = "id", value = "客户ID", required = true)
            @PathVariable String id,

            @ApiParam(name = "customer", value = "客户入住信息对象", required = true)
            @RequestBody  HotelCustomerinfo HotelCustomerinfo) {

        HotelCustomerinfo.setCustomerId(id);
        HotelCustomerinfoService.updateById(HotelCustomerinfo);
        return R.ok();
    }

}

package com.msr.hotel.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msr.common.msrUtil.R;
import com.msr.hotel.entity.Customer;
import com.msr.hotel.entity.Customerinfo;
import com.msr.hotel.query.CustomerQuery;
import com.msr.hotel.query.CustomerinfoQuery;
import com.msr.hotel.service.CustomerService;
import com.msr.hotel.service.CustomerinfoService;
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

@Api(description = "客人信息列表")
@CrossOrigin
@RestController
@RequestMapping("/hotel/customerinfo")
public class CustomerinfoController {
    @Autowired
    private CustomerinfoService customerinfoService;

    @ApiOperation(value = "所有客人信息列表")
    @GetMapping("list")
    public R list(){
        List<Customerinfo> list = customerinfoService.list(null);
        return R.ok().data("cutomersinfo", list);
    }

    @ApiOperation(value = "根据ID删除客人信息")
    @DeleteMapping("{id}")
    public R removeById(
            @ApiParam(name = "id", value = "客人ID", required = true)
            @PathVariable String id){
        boolean result = customerinfoService.removeById(id);
        if(result){
            return R.ok();
        }else{
            return R.error().message("删除失败");
        }
    }

    @ApiOperation(value = "分页查询列表")
    @GetMapping("{page}/{limit}")
    public R pageQuery(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,

            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit,

            @ApiParam(name = "CustomerQuery", value = "查询对象", required = false)
                    CustomerinfoQuery customerinfoQuery){

        Page<Customerinfo> pageParam = new Page<>(page, limit);

        customerinfoService.pageQuery(pageParam, customerinfoQuery);
        List<Customerinfo> records = pageParam.getRecords();
        long total = pageParam.getTotal();

        return  R.ok().data("total", total).data("rows", records);
    }

    @ApiOperation(value = "新增客人信息")
    @PostMapping("save")
    public R save(
            @ApiParam(name = "customer", value = "客人入住信息对象", required = true)
            @RequestBody Customerinfo customerinfo){

        customerinfoService.save(customerinfo);
        return R.ok();
    }

    @ApiOperation(value = "根据ID查询客人信息")
    @GetMapping("{id}")
    public R getById(
            @ApiParam(name = "id", value = "客户ID", required = true)
            @PathVariable String id){

        Customerinfo customerinfo = customerinfoService.getById(id);
        return R.ok().data("item", customerinfo);
    }

    @ApiOperation(value = "根据ID修改客人信息")
    @PutMapping("{id}")
    public R updateById(
            @ApiParam(name = "id", value = "客户ID", required = true)
            @PathVariable String id,

            @ApiParam(name = "customer", value = "客户入住信息对象", required = true)
            @RequestBody Customerinfo customerinfo){

        customerinfo.setCustomerId(id);
        customerinfoService.updateById(customerinfo);
        return R.ok();
    }
}


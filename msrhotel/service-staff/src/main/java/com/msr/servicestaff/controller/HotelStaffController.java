package com.msr.servicestaff.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msr.common.msrUtil.R;
import com.msr.servicestaff.entity.HotelStaff;
import com.msr.servicestaff.query.StaffQuery;
import com.msr.servicestaff.service.HotelStaffService;
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
@CrossOrigin
@Api(description = "员工信息管理")
@RestController
@RequestMapping("/servicestaff/hotel-staff")
public class HotelStaffController {
 @Autowired
    private HotelStaffService staffService;

 @ApiOperation(value = "所有员工列表")
 @GetMapping("list")
 public R list(){
     List<HotelStaff> list = staffService.list(null);
     return R.ok().data("item", list);
 }

    @ApiOperation(value = "根据ID删除员工信息")
    @DeleteMapping("{id}")
 public R removeById(
         @ApiParam(name="id",value="员工id",required = true)
         @PathVariable String id){
     boolean result =staffService.removeById(id);
     if(result){
         return R.ok();
     }else{
         return R.error().message("删除失败");
     }
 }

    @ApiOperation(value = "新增员工信息")
    @PostMapping("save")
    public R save(
            @ApiParam(name = "staff", value = "员工信息对象", required = true)
            @RequestBody HotelStaff staff){

        staffService.save(staff);
        return R.ok();
    }

    @ApiOperation(value = "根据ID查询员工")
    @GetMapping("{id}")
    public R getById(
            @ApiParam(name = "id", value = "员工ID", required = true)
            @PathVariable String id){

        HotelStaff staff = staffService.getById(id);
        return R.ok().data("item", staff);
    }

    @ApiOperation(value = "根据ID修改员工信息")
    @PutMapping("{id}")
    public R updateById(
            @ApiParam(name = "id", value = "员工ID", required = true)
            @PathVariable String id,

            @ApiParam(name = "staff", value = "员工对象", required = true)
            @RequestBody HotelStaff staff){

        staff.setStaffId(id);
        staffService.updateById(staff);
        return R.ok();
    }

    @ApiOperation(value = "分页员工列表")
    @GetMapping("{page}/{limit}")
    public R pageQuery(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,

            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit,
            @ApiParam(name = "StaffQuery", value = "查询对象", required = false)
                    StaffQuery staffQuery){

        Page<HotelStaff> pageParam = new Page<>(page, limit);

        staffService.pageQuery(pageParam,staffQuery);
        List<HotelStaff> records = pageParam.getRecords();
        long total = pageParam.getTotal();

        return  R.ok().data("total", total).data("rows", records);
    }



}


package com.msr.serviceroom.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msr.common.msrUtil.R;
import com.msr.serviceroom.Query.RoomQuery;
import com.msr.serviceroom.entity.HotelRoom;
import com.msr.serviceroom.service.HotelRoomService;
import com.msr.serviceroom.service.HotelRoomtypeService;
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
@Api(description="客房信息管理")
@RestController

@RequestMapping("/serviceroom/hotel-room")
public class HotelRoomController {

    @Autowired
    private HotelRoomService hotelRoomService;
    @Autowired
    private HotelRoomtypeService hotelRoomtypeService;

    @ApiOperation(value = "所有房间列表")
    @GetMapping("list")
    public R list(){
        List<HotelRoom> list = hotelRoomService.list(null);
        return R.ok().data("list", list);
    }

    @ApiOperation(value = "根据ID删除客房信息")
    @DeleteMapping("{id}")
    public R removeById(
            @ApiParam(name = "id", value = "客房ID", required = true)
            @PathVariable String id){
        boolean result = hotelRoomService.removeById(id);
        if(result){
            return R.ok();
        }else{
            return R.error().message("删除失败");
        }
    }

    @ApiOperation(value = "分页客房查询列表")
    @GetMapping("{page}/{limit}")
    public R pageQuery(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,

            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit,

            @ApiParam(name = "roomQuery", value = "查询对象", required = false)
                    RoomQuery roomQuery){

        Page<HotelRoom> pageParam = new Page<>(page, limit);

        hotelRoomService.pageQuery(pageParam, roomQuery);
        List<HotelRoom> records = pageParam.getRecords();
        long total = pageParam.getTotal();

        return  R.ok().data("total", total).data("rows", records);
    }
    @ApiOperation(value = "新增客房信息")
    @PostMapping("save")
    public R save(
            @ApiParam(name = "room", value = "客房信息对象", required = true)
            @RequestBody HotelRoom room){

        hotelRoomService.save(room);
        return R.ok();
    }

    @ApiOperation(value = "根据ID查询客房信息")
    @GetMapping("{id}")
    public R getById(
            @ApiParam(name = "id", value = "客户ID", required = true)
            @PathVariable String id){

        HotelRoom room = hotelRoomService.getById(id);
        return R.ok().data("item", room);
    }

    @ApiOperation(value = "根据ID修改客房信息")
    @PutMapping("{id}")
    public R updateById(
            @ApiParam(name = "id", value = "客户ID", required = true)
            @PathVariable String id,

            @ApiParam(name = "room", value = "客户入住信息对象", required = true)
            @RequestBody HotelRoom room){

        room.setRoomNum(id);
        hotelRoomService.updateById(room);
        return R.ok();
    }

}


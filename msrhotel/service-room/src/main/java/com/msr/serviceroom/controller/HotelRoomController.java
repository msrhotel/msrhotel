package com.msr.serviceroom.controller;


import com.msr.common.msrUtil.R;
import com.msr.serviceroom.entity.HotelRoom;
import com.msr.serviceroom.service.HotelRoomService;
import com.msr.serviceroom.service.HotelRoomtypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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
        return R.ok().data("item", list);
    }

}


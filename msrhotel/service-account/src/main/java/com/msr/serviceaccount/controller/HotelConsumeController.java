package com.msr.serviceaccount.controller;


import com.msr.serviceaccount.entity.HotelConsume;
import com.msr.serviceaccount.service.HotelConsumeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author msr
 * @since 2020-05-18
 */
@Api(description = "消费信息查询")
@RestController
@RequestMapping("/serviceaccount/hotel-consume")
public class HotelConsumeController {
    @Autowired
    private HotelConsumeService consumeService;
    @ApiOperation("所有消费信息")
    @GetMapping("findAll")
    public List<HotelConsume> list(){
        return consumeService.list(null);
    }

}


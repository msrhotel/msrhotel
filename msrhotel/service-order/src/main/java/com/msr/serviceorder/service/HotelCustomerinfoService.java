package com.msr.serviceorder.service;

import com.msr.serviceorder.entity.HotelCustomerinfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author msr
 * @since 2020-05-18
 */
public interface HotelCustomerinfoService extends IService<HotelCustomerinfo> {
    HotelCustomerinfo getHotelCustomerinfoById(String customerId);
}

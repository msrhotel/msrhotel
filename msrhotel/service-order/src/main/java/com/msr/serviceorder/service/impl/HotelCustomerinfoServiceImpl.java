package com.msr.serviceorder.service.impl;

import com.msr.serviceorder.entity.HotelCustomerinfo;
import com.msr.serviceorder.mapper.HotelCustomerinfoMapper;
import com.msr.serviceorder.service.HotelCustomerinfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author msr
 * @since 2020-05-18
 */
@Service
public class HotelCustomerinfoServiceImpl extends ServiceImpl<HotelCustomerinfoMapper, HotelCustomerinfo> implements HotelCustomerinfoService {
    @Autowired
    private HotelCustomerinfoService hotelCustomerinfoService;

    @Override
    public HotelCustomerinfo getHotelCustomerinfoById(String customerId){
        return null;
    }
}

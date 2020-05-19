package com.msr.servicecustomerinfo.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msr.servicecustomerinfo.Query.CustomerinfoQuery;
import com.msr.servicecustomerinfo.entity.HotelCustomerinfo;
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
    void pageQuery(Page<HotelCustomerinfo> pageParam, CustomerinfoQuery customerinfoQuery);
}

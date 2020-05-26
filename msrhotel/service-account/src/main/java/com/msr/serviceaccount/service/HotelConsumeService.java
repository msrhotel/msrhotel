package com.msr.serviceaccount.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msr.serviceaccount.entity.HotelConsume;
import com.baomidou.mybatisplus.extension.service.IService;
import com.msr.serviceaccount.query.ConsumeQuery;
import com.msr.serviceaccount.query.CustomerIdQuery;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author msr
 * @since 2020-05-18
 */
public interface HotelConsumeService extends IService<HotelConsume> {

    void pageQuery(Page<HotelConsume> pageParam, ConsumeQuery consumeQuery);

    void getByCustomerId(Page<HotelConsume> pageParam, CustomerIdQuery customerIdQuery);

    List<HotelConsume> getByCustomerId(String customerId);
    //  List<HotelConsume> getByCustomerId(String customerId);
}

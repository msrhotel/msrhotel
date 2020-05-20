package com.msr.serviceorder.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msr.common.utils.Query;
import com.msr.serviceorder.entity.HotelOrder;
import com.baomidou.mybatisplus.extension.service.IService;
import com.msr.serviceorder.query.HotelOrderQuery;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author msr
 * @since 2020-05-18
 */
public interface HotelOrderService extends IService<HotelOrder> {
    void pageQuery(Page<HotelOrder> pageParam, HotelOrderQuery hotelOrderQuery);
}

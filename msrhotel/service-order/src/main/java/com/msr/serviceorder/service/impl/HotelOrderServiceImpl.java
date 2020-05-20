package com.msr.serviceorder.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msr.common.utils.Query;
import com.msr.serviceorder.entity.HotelOrder;
import com.msr.serviceorder.mapper.HotelOrderMapper;
import com.msr.serviceorder.query.HotelOrderQuery;
import com.msr.serviceorder.service.HotelOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.Collection;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author msr
 * @since 2020-05-18
 */
@Service
public class HotelOrderServiceImpl extends ServiceImpl<HotelOrderMapper, HotelOrder> implements HotelOrderService {


    @Override
    public void pageQuery(Page<HotelOrder> pageParam, HotelOrderQuery hotelOrderQuery) {
        QueryWrapper<HotelOrder> queryWrapper = new QueryWrapper<>();
        //queryWrapper.orderByAsc("sort");

        if (hotelOrderQuery == null) {
            baseMapper.selectPage(pageParam, queryWrapper);
            return;
        }

        String orderId = hotelOrderQuery.getOrderId();
        String customerId = hotelOrderQuery.getCustomerId();
        Integer orderType = hotelOrderQuery.getOrderType();
        String inDate = hotelOrderQuery.getInDate();
        String outDate = hotelOrderQuery.getOutDate();

        if (!StringUtils.isEmpty(orderId)) {
            queryWrapper.like("order_id", orderId);
        }

        if (!StringUtils.isEmpty(customerId)) {
            queryWrapper.like("customer_id", customerId);
        }

        if (!StringUtils.isEmpty(orderType)) {
            queryWrapper.eq("order_type", orderType);
        }

        if (!StringUtils.isEmpty(outDate)) {
            queryWrapper.ge("in_date", inDate);
        }

        if (!StringUtils.isEmpty(outDate)) {
            queryWrapper.ge("out_date", outDate);
        }

        baseMapper.selectPage(pageParam, queryWrapper);
    }

    @Override
    public boolean removeById(Serializable id) {
        Integer result = baseMapper.deleteById(id);
        return null != result && result > 0;
    }
}


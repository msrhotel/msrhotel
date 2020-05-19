package com.msr.servicecustomerinfo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msr.servicecustomerinfo.Query.customerinfoQuery;
import com.msr.servicecustomerinfo.entity.HotelCustomerinfo;
import com.msr.servicecustomerinfo.mapper.HotelCustomerinfoMapper;
import com.msr.servicecustomerinfo.service.HotelCustomerinfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.Serializable;

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
    @Override
    public void pageQuery(Page<HotelCustomerinfo> pageParam, customerinfoQuery customerinfoQuery) {
        QueryWrapper<HotelCustomerinfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("customer_id");

        if (customerinfoQuery == null) {
            baseMapper.selectPage(pageParam, queryWrapper);
            return;
        }

        String customerName = customerinfoQuery.getCustomername();
        String customerinfoTel = customerinfoQuery.getCustomerinfotel();
        String customerinfoBirthday = customerinfoQuery.getCustomerinfoBirthday();

        if (!StringUtils.isEmpty(customerName)) {
            queryWrapper.like("customer_name", customerName);
        }

        if (!StringUtils.isEmpty(customerinfoTel)) {
            queryWrapper.like("customerinfo_tel", customerinfoTel);
        }
        if (!StringUtils.isEmpty(customerinfoBirthday)) {
            queryWrapper.ge("customerinfo_birthday", customerinfoBirthday);
        }

        baseMapper.selectPage(pageParam, queryWrapper);
    }

    @Override
    public boolean removeById(Serializable id) {
        Integer result = baseMapper.deleteById(id);
        return null != result && result > 0;
    }
}

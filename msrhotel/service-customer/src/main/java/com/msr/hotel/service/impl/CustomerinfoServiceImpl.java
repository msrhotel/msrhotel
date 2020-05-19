package com.msr.hotel.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msr.hotel.entity.Customer;
import com.msr.hotel.entity.Customerinfo;
import com.msr.hotel.mapper.CustomerinfoMapper;
import com.msr.hotel.query.CustomerQuery;
import com.msr.hotel.query.CustomerinfoQuery;
import com.msr.hotel.service.CustomerinfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author msr
 * @since 2020-05-18
 */
@Service
public class CustomerinfoServiceImpl extends ServiceImpl<CustomerinfoMapper, Customerinfo> implements CustomerinfoService {


    @Override
    public void pageQuery(Page<Customerinfo> pageParam, CustomerinfoQuery customerinfoQuery) {
        QueryWrapper<Customerinfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("customer_id");

        if (customerinfoQuery == null){
            baseMapper.selectPage(pageParam, queryWrapper);
            return;
        }

        String customerName = customerinfoQuery.getCustomerName();
        String customerinfoTel = customerinfoQuery.getCustomerinfoTel();
        String customerinfoBirthday = customerinfoQuery.getCustomerinfoBirthday();

        if (!StringUtils.isEmpty(customerName)) {
            queryWrapper.like("customer_name", customerName);
        }

        if (!StringUtils.isEmpty(customerinfoTel)) {
            queryWrapper.like("customerinfo_tel", customerinfoTel);
        }
        if (!StringUtils.isEmpty(customerinfoBirthday)) {
            queryWrapper.ge("customerinfo_birthday",customerinfoBirthday);
        }

        baseMapper.selectPage(pageParam, queryWrapper);
    }
}

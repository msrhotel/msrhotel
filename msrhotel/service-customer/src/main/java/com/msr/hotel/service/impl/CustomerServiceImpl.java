package com.msr.hotel.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msr.hotel.entity.Customer;
import com.msr.hotel.mapper.CustomerMapper;
import com.msr.hotel.query.CustomerQuery;
import com.msr.hotel.service.CustomerService;
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
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {

    @Override
    public void pageQuery(Page<Customer> pageParam, CustomerQuery customerQuery) {
        QueryWrapper<Customer> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("customer_id");

        if (customerQuery == null){
            baseMapper.selectPage(pageParam, queryWrapper);
            return;
        }

        Integer inRoom = customerQuery.getInRoom();
        String inDate = customerQuery.getInDate();
        String outDate = customerQuery.getOutDate();

        if (!StringUtils.isEmpty(inRoom)) {
            queryWrapper.eq("in_room", inRoom);
        }

        if (!StringUtils.isEmpty(outDate)) {
            queryWrapper.ge("in_date", inDate);
        }
        if (!StringUtils.isEmpty(outDate)) {
            queryWrapper.ge("out_date", outDate);
        }

        baseMapper.selectPage(pageParam, queryWrapper);
    }

}

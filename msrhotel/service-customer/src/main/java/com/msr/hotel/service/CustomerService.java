package com.msr.hotel.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msr.hotel.entity.Customer;
import com.baomidou.mybatisplus.extension.service.IService;
import com.msr.hotel.query.CustomerQuery;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author msr
 * @since 2020-05-18
 */
public interface CustomerService extends IService<Customer> {

    public void pageQuery(Page<Customer> pageParam, CustomerQuery customerQuery);

    }

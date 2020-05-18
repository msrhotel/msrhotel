package com.msr.hotel.service.impl;

import com.msr.hotel.entity.Customer;
import com.msr.hotel.mapper.CustomerMapper;
import com.msr.hotel.service.CustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {

}

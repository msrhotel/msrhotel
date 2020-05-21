package com.msr.serviceaccount.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msr.serviceaccount.entity.HotelIncome;
import com.baomidou.mybatisplus.extension.service.IService;
import com.msr.serviceaccount.query.IncomeCustomerIdQuery;
import com.msr.serviceaccount.query.IncomeQuery;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author msr
 * @since 2020-05-18
 */
public interface HotelIncomeService extends IService<HotelIncome> {

    void getIncomeByCustomerId(Page<HotelIncome> pageParam, IncomeCustomerIdQuery incomeCustomerIdQuery);

    void pageQuery(Page<HotelIncome> pageParam, IncomeQuery incomeQuery);
}

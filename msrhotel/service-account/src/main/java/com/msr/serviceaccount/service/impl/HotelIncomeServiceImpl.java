package com.msr.serviceaccount.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msr.serviceaccount.entity.HotelConsume;
import com.msr.serviceaccount.entity.HotelIncome;
import com.msr.serviceaccount.mapper.HotelConsumeMapper;
import com.msr.serviceaccount.mapper.HotelIncomeMapper;
import com.msr.serviceaccount.query.IncomeCustomerIdQuery;
import com.msr.serviceaccount.query.IncomeQuery;
import com.msr.serviceaccount.service.HotelIncomeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author msr
 * @since 2020-05-18
 */
@Service
public class HotelIncomeServiceImpl extends ServiceImpl<HotelIncomeMapper, HotelIncome> implements HotelIncomeService {
    private HotelIncomeMapper incomeMapper;
    @Override
    public void getIncomeByCustomerId(Page<HotelIncome> pageParam, IncomeCustomerIdQuery incomeCustomerIdQuery) {
        QueryWrapper<HotelIncome> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc();


        String customerId = incomeCustomerIdQuery.getCustomerId();

        if (!StringUtils.isEmpty(customerId)) {
            queryWrapper.like("customer_id", customerId);
        }
        baseMapper.selectPage(pageParam, queryWrapper);
    }

    @Override
    public void pageQuery(Page<HotelIncome> pageParam, IncomeQuery incomeQuery) {
        QueryWrapper<HotelIncome> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc();

        String incomeId = incomeQuery.getIncomeId();
        String customerId = incomeQuery.getCustomerId();
        Integer incomeTypeId = incomeQuery.getIncomeTypeId();
        String incomeSatff = incomeQuery.getIncomeSatff();
        Date incomeDate = incomeQuery.getIncomeDate();
        String begin = incomeQuery.getBegin();
        String end = incomeQuery.getEnd();


        if (!StringUtils.isEmpty(incomeId)) {
            queryWrapper.eq("income_id", incomeId);
        }

        if (!StringUtils.isEmpty(customerId)) {
            queryWrapper.eq("customer_id", customerId);
        }

        if (!StringUtils.isEmpty(incomeTypeId) ) {
            queryWrapper.eq("income_type_id", incomeTypeId);
        }
        if (!StringUtils.isEmpty(incomeSatff) ) {
            queryWrapper.eq("income_satff", incomeSatff);
        }
        if (!StringUtils.isEmpty(incomeDate) ) {
            queryWrapper.like("income_date", incomeDate);
        }

        if (!StringUtils.isEmpty(begin)) {
            queryWrapper.ge("gmt_create", begin);
        }

        if (!StringUtils.isEmpty(end)) {
            queryWrapper.le("gmt_create", end);
        }

        baseMapper.selectPage(pageParam, queryWrapper);
    }

    @Override
    public List<HotelConsume> getByCustomerId(String customerId) {
        return incomeMapper.getByCustomerId(customerId);
    }
}

package com.msr.serviceaccount.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msr.serviceaccount.entity.HotelConsume;
import com.msr.serviceaccount.mapper.ConsumeExcelMapper;
import com.msr.serviceaccount.mapper.HotelConsumeMapper;
import com.msr.serviceaccount.query.ConsumeQuery;
import com.msr.serviceaccount.query.CustomerIdQuery;
import com.msr.serviceaccount.service.HotelConsumeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
public class HotelConsumeServiceImpl extends ServiceImpl<HotelConsumeMapper, HotelConsume> implements HotelConsumeService {

    private HotelConsumeMapper consumeMapper;
    @Override
    public void pageQuery(Page<HotelConsume> pageParam, ConsumeQuery consumeQuery) {
        QueryWrapper<HotelConsume> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc();
        String consumeId = consumeQuery.getConsumeId();
        String customerId = consumeQuery.getCustomerId();
        Integer consumeTypeId = consumeQuery.getConsumeTypeId();
        String consumeSatff = consumeQuery.getConsumeSatff();
        Date consumeDate = consumeQuery.getConsumeDate();
        String begin = consumeQuery.getBegin();
        String end = consumeQuery.getEnd();

        if (!StringUtils.isEmpty(consumeId)) {
            queryWrapper.like("consume_id", consumeId);
        }
        if (!StringUtils.isEmpty(customerId)) {
            queryWrapper.like("customer_id", customerId);
        }

        if (!StringUtils.isEmpty(consumeTypeId) ) {
            queryWrapper.eq("consume_type_id", consumeTypeId);
        }
        if (!StringUtils.isEmpty(consumeSatff) ) {
            queryWrapper.eq("consume_satff", consumeSatff);
        }
        if (!StringUtils.isEmpty(consumeDate) ) {
            queryWrapper.like("consume_date", consumeDate);
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
    public void getByCustomerId(Page<HotelConsume> pageParam, CustomerIdQuery customerIdQuery) {
        QueryWrapper<HotelConsume> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc();


        String customerId = customerIdQuery.getCustomerId();

        if (!StringUtils.isEmpty(customerId)) {
            queryWrapper.like("customer_id", customerId);
        }
        baseMapper.selectPage(pageParam, queryWrapper);
    }

    @Override
    public List<HotelConsume> getByCustomerId(String customerId) {
        return consumeMapper.getByCustomerId(customerId);
    }


}

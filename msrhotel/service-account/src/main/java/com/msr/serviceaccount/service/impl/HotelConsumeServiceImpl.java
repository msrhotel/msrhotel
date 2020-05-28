package com.msr.serviceaccount.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msr.serviceaccount.entity.HotelConsume;
import com.msr.serviceaccount.listener.ConsumeExcelListener;
import com.msr.serviceaccount.mapper.ConsumeExcelMapper;
import com.msr.serviceaccount.mapper.HotelConsumeMapper;
import com.msr.serviceaccount.query.ConsumeQuery;
import com.msr.serviceaccount.query.CustomerIdQuery;
import com.msr.serviceaccount.service.HotelConsumeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
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
@Slf4j
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

    @Override
    public void importConsumeData(MultipartFile file, HotelConsumeService consumeService) {
        try {
            // 文件输入流
            InputStream in = file.getInputStream();
            // 调用方法进行读取
            EasyExcel.read(in, HotelConsume.class,new ConsumeExcelListener(consumeService)).sheet().doRead();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean saveData(List<HotelConsume> consume) {
        log.info("UserService {}条数据，开始存储数据库！", consume.size());
        log.info(JSON.toJSONString(consume));
        log.info("UserService 存储数据库成功！");
        System.out.println(consume);
//        this.save(consume);
        return true;
    }

//    @Override
//    public void importConsumeData(List<HotelConsume> consumeList) {
//        try {
//            //文件输入流
//            InputStream in = file.getInputStream();
//            //调用方法进行读取
//            EasyExcel.read(in,HotelConsume.class,new ConsumeExcelListener(subjectService)).sheet().doRead();
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//    }


}

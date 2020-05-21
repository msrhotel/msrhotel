package com.msr.serviceaccount.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.msr.serviceaccount.entity.excel.ConsumeExcelEntity;
import com.msr.serviceaccount.mapper.ConsumeExcelMapper;
import com.msr.serviceaccount.service.ConsumeExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service()
// @Configuration
public class ConsumeExcelServiceImpl extends ServiceImpl<ConsumeExcelMapper, ConsumeExcelEntity> implements ConsumeExcelService {

    @Autowired
    private ConsumeExcelMapper consumeExcelMapper;
    @Override
    public List<ConsumeExcelEntity> getConsumes(String customerId) {
        List<ConsumeExcelEntity> consumeList = consumeExcelMapper.getConsumes(customerId);
        return consumeList;
    }

    @Override
    public void insertConsumeData(List<ConsumeExcelEntity> consumeList) {
        for (ConsumeExcelEntity consumeExcelEntity : consumeList) {
            consumeExcelMapper.insertConsumeData(consumeExcelEntity);
            System.out.println("数据 【" + consumeExcelEntity.getConsumeId() + "】插入成功！");
        }
    }
}

package com.msr.serviceaccount.service.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.msr.serviceaccount.entity.excel.ConsumeExcelEntity;
import com.msr.serviceaccount.listener.ConsumeExcelListener;
import com.msr.serviceaccount.mapper.ConsumeExcelMapper;
import com.msr.serviceaccount.service.ConsumeExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

@Service
// @Configuration
public class ConsumeExcelServiceImpl extends ServiceImpl<ConsumeExcelMapper, ConsumeExcelEntity> implements ConsumeExcelService {

    @Autowired
    private ConsumeExcelMapper consumeExcelMapper;
    @Override
    public List<ConsumeExcelEntity> getConsumes(String customerId) {
        List<ConsumeExcelEntity> consumeList = consumeExcelMapper.getConsumes(customerId);
        return consumeList;
    }
//
//    @Override
//    public void importConsumeData(List<ConsumeExcelEntity> consumeList) {
//        for (ConsumeExcelEntity consumeExcelEntity : consumeList) {
//            consumeExcelMapper.importConsumeData(consumeExcelEntity);
//            System.out.println("数据 【" + consumeExcelEntity.getCustomerId() + "】插入成功！");
//        }
//    }

//    @Override
//    public void importConsumeData(MultipartFile file, ConsumeExcelService consumeExcelService) {
//        try {
//            //文件输入流
//            InputStream in = file.getInputStream();
//            //调用方法进行读取
//            EasyExcel.read(in, ConsumeExcelEntity.class,new ConsumeExcelListener(consumeExcelService)).sheet().doRead();
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//
//    }



//    }

//    @Override
//    public void insertConsumeData(List<ConsumeExcelEntity> consumeList) {
//        for (ConsumeExcelEntity consumeExcelEntity : consumeList) {
//            consumeExcelMapper.insertConsumeData(consumeExcelEntity);
//            System.out.println("数据 【" + consumeExcelEntity.getConsumeId() + "】插入成功！");
//        }
//    }
}

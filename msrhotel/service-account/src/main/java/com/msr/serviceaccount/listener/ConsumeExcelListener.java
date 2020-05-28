package com.msr.serviceaccount.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.msr.serviceaccount.entity.HotelConsume;
import com.msr.serviceaccount.service.HotelConsumeService;
import org.springframework.beans.factory.annotation.Autowired;
import servicebase.exception.MSRException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ConsumeExcelListener extends AnalysisEventListener<HotelConsume> {
    @Autowired
    public HotelConsumeService consumeService;
    List<HotelConsume> list = new ArrayList<>();
    public ConsumeExcelListener(HotelConsumeService consumeService) {
        this.consumeService = consumeService;
    }

    public ConsumeExcelListener() {

    }

    @Override
    public void invoke(HotelConsume consume, AnalysisContext analysisContext) {
        if(consume == null) {
            throw new MSRException(20001,"文件数据为空");
        }
        System.out.println(consume);
        list.add(consume);
        consumeService.save((HotelConsume) list);

    }


    // 读取excel表头信息
    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {

    }



    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}

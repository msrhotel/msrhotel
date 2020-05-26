package com.msr.serviceaccount.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.msr.serviceaccount.entity.excel.ConsumeExcelEntity;
import com.msr.serviceaccount.service.ConsumeExcelService;
import servicebase.exception.MSRException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ConsumeExcelListener extends AnalysisEventListener<ConsumeExcelEntity> {
    public ConsumeExcelService consumeExcelService;
//    public ConsumeExcelListener() {}
    public ConsumeExcelListener(ConsumeExcelService consumeExcelService) {
        this.consumeExcelService = consumeExcelService;
    }
   List<ConsumeExcelEntity> consumeList = new ArrayList<>();
    @Override
    public void invoke(ConsumeExcelEntity consumeExcelEntity, AnalysisContext analysisContext) {
        if(consumeExcelEntity == null) {
            throw new MSRException(20001,"文件数据为空");
        }
        consumeList.add(consumeExcelEntity);
        System.out.println(consumeList);

    }
    //读取excel表头信息
    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {

    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}

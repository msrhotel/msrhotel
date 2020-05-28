package com.msr.serviceaccount.util;


import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import com.msr.serviceaccount.entity.HotelConsume;
import com.msr.serviceaccount.service.HotelConsumeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ExcelListener extends AnalysisEventListener {


    /**
     * 批处理阈值
     */
    private static final int BATCH_COUNT = 2;
    List<Object> list = new ArrayList<>(BATCH_COUNT);


    @Override
    public void invoke(Object o, AnalysisContext analysisContext) {
        log.info("解析到一条数据:{}", JSON.toJSONString(o));
        list.add( o);
        System.out.println(list);
        if (list.size() >= BATCH_COUNT) {
            saveData();
            list.clear();
        }
    }


    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        saveData();
        log.info("所有数据解析完成！");
    }
@Autowired
private HotelConsumeService consumeService;
    private void saveData(){
        consumeService.save((HotelConsume) list);
        log.info("{}条数据，开始存储数据库！", list.size());
        log.info("存储数据库成功！");
    }
}


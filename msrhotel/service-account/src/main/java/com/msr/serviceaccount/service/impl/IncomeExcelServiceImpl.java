package com.msr.serviceaccount.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.msr.serviceaccount.entity.excel.ConsumeExcelEntity;
import com.msr.serviceaccount.entity.excel.IncomeExcelEntity;
import com.msr.serviceaccount.mapper.ConsumeExcelMapper;
import com.msr.serviceaccount.mapper.IncomeExcelMapper;
import com.msr.serviceaccount.service.IncomeExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IncomeExcelServiceImpl extends ServiceImpl<IncomeExcelMapper, IncomeExcelEntity> implements IncomeExcelService {
    @Autowired
    private IncomeExcelMapper incomeExcelMapper;
    @Override
    public List<IncomeExcelEntity> getIncomes(String customerId) {
        List<IncomeExcelEntity> incomeList = incomeExcelMapper.getIncomes(customerId);
        return incomeList;
    }

}

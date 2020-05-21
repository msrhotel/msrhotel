package com.msr.serviceaccount.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.msr.serviceaccount.entity.excel.ConsumeExcelEntity;
import com.msr.serviceaccount.entity.excel.IncomeExcelEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author msr
 * @since 2020-05-18
 */
@Mapper
@Repository
public interface IncomeExcelMapper extends BaseMapper<IncomeExcelEntity> {

    List<IncomeExcelEntity> getIncomes(String customerId);
}

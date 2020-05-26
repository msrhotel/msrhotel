package com.msr.serviceaccount.mapper;

import com.msr.serviceaccount.entity.HotelConsume;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.msr.serviceaccount.entity.excel.ConsumeExcelEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.sql.SQLOutput;
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
public interface ConsumeExcelMapper extends BaseMapper<ConsumeExcelEntity> {
    List<ConsumeExcelEntity> getConsumes(String customerId);
    void importConsumeData(ConsumeExcelEntity consumeExcelEntity);

}
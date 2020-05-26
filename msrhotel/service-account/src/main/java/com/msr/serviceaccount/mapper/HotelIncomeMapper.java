package com.msr.serviceaccount.mapper;

import com.msr.serviceaccount.entity.HotelConsume;
import com.msr.serviceaccount.entity.HotelIncome;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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
public interface HotelIncomeMapper extends BaseMapper<HotelIncome> {
    @Select("select * from hotel_income where customer_id = #{customerId}")
    List<HotelConsume> getByCustomerId(String customerId);
}

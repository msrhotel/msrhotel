package com.msr.servicestaff.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msr.servicestaff.entity.HotelStaff;
import com.baomidou.mybatisplus.extension.service.IService;
import com.msr.servicestaff.query.StaffQuery;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author msr
 * @since 2020-05-18
 */

public interface HotelStaffService extends IService<HotelStaff> {
    void pageQuery(Page<HotelStaff> pageParam, StaffQuery teacherQuery);
}

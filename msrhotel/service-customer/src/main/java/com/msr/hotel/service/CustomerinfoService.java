package com.msr.hotel.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msr.hotel.entity.Customerinfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.msr.hotel.query.CustomerinfoQuery;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author msr
 * @since 2020-05-18
 */
public interface CustomerinfoService extends IService<Customerinfo> {

    void pageQuery(Page<Customerinfo> pageParam, CustomerinfoQuery customerinfoQuery);
}

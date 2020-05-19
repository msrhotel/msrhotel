package com.msr.serviceroom.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msr.serviceroom.Query.RoomQuery;
import com.msr.serviceroom.entity.HotelRoom;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author msr
 * @since 2020-05-18
 */
public interface HotelRoomService extends IService<HotelRoom> {

    void pageQuery(Page<HotelRoom> pageParam, RoomQuery roomQuery);

}

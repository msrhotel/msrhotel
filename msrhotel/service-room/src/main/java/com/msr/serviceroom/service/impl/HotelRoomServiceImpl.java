package com.msr.serviceroom.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.msr.serviceroom.Query.RoomQuery;
import com.msr.serviceroom.entity.HotelRoom;
import com.msr.serviceroom.mapper.HotelRoomMapper;
import com.msr.serviceroom.service.HotelRoomService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.Serializable;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author msr
 * @since 2020-05-18
 */
@Service
public class HotelRoomServiceImpl extends ServiceImpl<HotelRoomMapper, HotelRoom> implements HotelRoomService {
    @Override
    public void pageQuery(Page<HotelRoom> pageParam, RoomQuery roomQuery) {
        QueryWrapper<HotelRoom> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc();

        if (roomQuery == null){
            baseMapper.selectPage(pageParam, queryWrapper);
            return;
        }

        String roomPrice = roomQuery.getRoomPrice();
        String roomType = roomQuery.getRoomType();
        String roomState=roomQuery.getRoomState();
        String begin = roomQuery.getBegin();
        String end = roomQuery.getEnd();

        if (!StringUtils.isEmpty(roomPrice)) {
            queryWrapper.like("room_price", roomPrice);
        }

        if (!StringUtils.isEmpty(roomType) ) {
            queryWrapper.eq("room_type", roomType);
        }

        if (!StringUtils.isEmpty(roomState) ) {
            queryWrapper.eq("room_state", roomState);
        }

        if (!StringUtils.isEmpty(begin)) {
            queryWrapper.ge("gmt_create", begin);
        }

        if (!StringUtils.isEmpty(end)) {
            queryWrapper.le("gmt_create", end);
        }

        baseMapper.selectPage(pageParam, queryWrapper);
    }

    @Override
    public boolean removeById(Serializable id) {
        Integer result = baseMapper.deleteById(id);
        return null != result && result > 0;
    }

}

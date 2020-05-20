package com.msr.servicestaff.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msr.servicestaff.entity.HotelStaff;
import com.msr.servicestaff.mapper.HotelStaffMapper;
import com.msr.servicestaff.query.StaffQuery;
import com.msr.servicestaff.service.HotelStaffService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class HotelStaffServiceImpl extends ServiceImpl<HotelStaffMapper, HotelStaff> implements HotelStaffService {
    @Override
    public boolean removeById(Serializable id) {
        Integer result = baseMapper.deleteById(id);
        return null != result && result > 0;
    }

    @Override
    public void pageQuery(Page<HotelStaff> pageParam, StaffQuery staffQuery) {
        QueryWrapper<HotelStaff> queryWrapper = new QueryWrapper<>();

        if (staffQuery == null){
            baseMapper.selectPage(pageParam, queryWrapper);
            return;
        }

        String name = staffQuery.getName();
        Integer emp = staffQuery.getEmp();
        Integer position = staffQuery.getPosition();
        String begin = staffQuery.getBegin();
        String end = staffQuery.getEnd();

        if (!StringUtils.isEmpty(name)) {
            queryWrapper.like("name", name);
        }

        if (!StringUtils.isEmpty(emp) ) {
            queryWrapper.eq("emp", emp);
        }

        if (!StringUtils.isEmpty(position) ) {
            queryWrapper.eq("position", position);
        }

        if (!StringUtils.isEmpty(begin)) {
            queryWrapper.ge("gmt_create", begin);
        }

        if (!StringUtils.isEmpty(end)) {
            queryWrapper.le("gmt_create", end);
        }

        baseMapper.selectPage(pageParam, queryWrapper);
    }
}

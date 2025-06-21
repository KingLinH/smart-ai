package com.kinglin.smart.ai.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kinglin.smart.ai.mapper.AppointmentMapper;
import com.kinglin.smart.ai.model.entity.Appointment;
import com.kinglin.smart.ai.service.AppointmentService;
import org.springframework.stereotype.Service;

/**
 * @author HJinLin
 * @description
 * @date 2025-06-21 12:11
 */
@Service
public class AppointmentServiceImpl extends ServiceImpl<AppointmentMapper, Appointment> implements AppointmentService {

    @Override
    public Appointment getOne(Appointment appointment) {
        LambdaQueryWrapper<Appointment> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Appointment::getUsername, appointment.getUsername());
        wrapper.eq(Appointment::getIdCard, appointment.getIdCard());
        wrapper.eq(Appointment::getDepartment, appointment.getDepartment());
        wrapper.eq(Appointment::getDate, appointment.getDate());
        wrapper.eq(Appointment::getTime, appointment.getTime());

        return baseMapper.selectOne(wrapper);
    }
}

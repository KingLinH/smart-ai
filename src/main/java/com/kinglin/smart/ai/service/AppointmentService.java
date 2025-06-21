package com.kinglin.smart.ai.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kinglin.smart.ai.model.entity.Appointment;

/**
 * @author HJinLin
 * @description
 * @date 2025-06-21 12:11
 */
public interface AppointmentService extends IService<Appointment> {

    Appointment getOne(Appointment appointment);

}

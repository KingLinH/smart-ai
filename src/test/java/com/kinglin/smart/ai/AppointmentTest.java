package com.kinglin.smart.ai;

import com.kinglin.smart.ai.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author HJinLin
 * @description
 * @date 2025-06-21 12:18
 */
@SpringBootTest
public class AppointmentTest {

    @Autowired
    private AppointmentService appointmentService;

    /*@Test
    public void testGet() {
        Appointment appointment = new Appointment();
        appointment.setUsername("张三");
        appointment.setIdCard("123456789098765432");
        appointment.setDepartment("内科");
        appointment.setDate("2025-06-23");
        appointment.setTime("上午");
        appointment.setDoctorName("张医生");
        Appointment one = appointmentService.getOne(appointment);
        System.out.println(one);
    }

    @Test
    public void testSave() {
        Appointment appointment = new Appointment();
        appointment.setUsername("张三");
        appointment.setIdCard("123456789098765432");
        appointment.setDepartment("内科");
        appointment.setDate("2025-06-23");
        appointment.setTime("上午");
        appointment.setDoctorName("张医生");
        appointmentService.save(appointment);
    }*/

}

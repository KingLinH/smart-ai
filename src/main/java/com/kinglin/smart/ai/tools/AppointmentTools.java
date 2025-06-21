package com.kinglin.smart.ai.tools;

import com.kinglin.smart.ai.model.entity.Appointment;
import com.kinglin.smart.ai.service.AppointmentService;
import dev.langchain4j.agent.tool.P;
import dev.langchain4j.agent.tool.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author HJinLin
 * @description 预约工具
 * @date 2025-06-21 12:23
 */
@Component
public class AppointmentTools {

    @Autowired
    private AppointmentService appointmentService;

    @Tool(name = "预约挂号", value = "根据参数，先执行工具方法queryDepartment查询是否可以预约，并直接给用户回答是否可预约，并让用户确认所有预约信息，用户确认以后再进行预约。" +
            "如果用户没有提供具体的医生姓名，请从向量存储中找到一名医生。")
    public String bookAppointment(Appointment appointment) {
        Appointment one = appointmentService.getOne(appointment);
        if (one == null) {
            appointment.setId(null);
            if (appointmentService.save(appointment)) {
                return "预约成功，并返回预约详情";
            } else {
                return "预约失败";
            }
        }
        return "您在相同的科室和时间已有预约";
    }

    @Tool(name = "取消预约挂号", value = "根据参数，查询预约是否存在，如果存在则删除预约记录并返回true，否则返回false")
    public String cancelAppointment(Appointment appointment) {
        Appointment one = appointmentService.getOne(appointment);
        if (one != null) {
            if (appointmentService.removeById(one.getId())) {
                return "取消预约成功";
            } else {
                return "取消预约失败";
            }
        }
        return "您没有预约记录，请核对预约科室和时间";
    }

    @Tool(name = "查询是否有号源", value = "根据科室名称、日期、时间和医生查询是否有号源，并返回给用户")
    public boolean queryDepartment(@P("科室名称") String name,
                                   @P("日期") String date,
                                   @P("时间，可选值：上午、下午") String time,
                                   @P(value = "医生名称", required = false) String doctorName) {
        System.out.println("查询是否有号源");
        System.out.println("科室名称：" + name);
        System.out.println("日期：" + date);
        System.out.println("时间：" + time);
        System.out.println("医生名称：" + doctorName);

        // TODO 结合其实科室排班。。。

        return true;
    }

}

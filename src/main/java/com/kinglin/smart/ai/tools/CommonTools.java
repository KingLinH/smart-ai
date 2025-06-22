package com.kinglin.smart.ai.tools;

import dev.langchain4j.agent.tool.Tool;
import io.micrometer.observation.annotation.Observed;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author HJinLin
 * @description 通用工具类
 * @date 2025-06-22 12:23
 */
@Component
public class CommonTools {

    @Tool
    @Observed
    public String currentTime() {
        return LocalDateTime.now().toString();
    }

}

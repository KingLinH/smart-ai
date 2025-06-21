package com.kinglin.smart.ai.assistant;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;

import static dev.langchain4j.service.spring.AiServiceWiringMode.EXPLICIT;

/**
 * @author HJinLin
 * @description
 * @date 2025-06-21 0:51
 */
@AiService(
        wiringMode = EXPLICIT,
        chatModel = "qwenChatModel",
        chatMemoryProvider = "huaxiaotuoChatMemoryProvider",
        tools = "appointmentTools"
)
public interface HuaxiaotuoAgent {

    @SystemMessage(fromResource = "huaxiaotuo-prompt-template.txt")
    String chat(@MemoryId Long memoryId, @UserMessage String userMessage);

}

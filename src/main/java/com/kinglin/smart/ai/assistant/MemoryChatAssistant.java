package com.kinglin.smart.ai.assistant;

import dev.langchain4j.service.spring.AiService;

import static dev.langchain4j.service.spring.AiServiceWiringMode.EXPLICIT;

/**
 * 包含上下文记忆的聊天助手
 *
 * @author HJinLin
 * @date 2025-06-20 21:59
 */
@AiService(
        wiringMode = EXPLICIT,
        chatModel = "qwenChatModel",
        chatMemory = "chatMemory"
)
public interface MemoryChatAssistant {

    String chat(String userMessage);

}

package com.kinglin.smart.ai.assistant;

import dev.langchain4j.service.spring.AiService;

import static dev.langchain4j.service.spring.AiServiceWiringMode.EXPLICIT;

/**
 * 普通聊天助手
 * 无上下文记录
 * 无对话隔离
 *
 * @author HJinLin
 * @date 2025-06-20 21:59
 */
@AiService(wiringMode = EXPLICIT, chatModel = "qwenChatModel")
public interface Assistant {

    String chat(String userMessage);

}

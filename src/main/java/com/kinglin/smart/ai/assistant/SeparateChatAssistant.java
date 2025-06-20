package com.kinglin.smart.ai.assistant;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import dev.langchain4j.service.spring.AiService;

import static dev.langchain4j.service.spring.AiServiceWiringMode.EXPLICIT;

/**
 * 独立对话的聊天助手
 *
 * @author HJinLin
 * @date 2025-06-20 21:59
 */
@AiService(
        wiringMode = EXPLICIT,
        chatModel = "qwenChatModel",
        chatMemoryProvider = "chatMemoryProvider",
        tools = "calculatorTools"
)
public interface SeparateChatAssistant {

    // 系统提示词
    /*@SystemMessage("你是我的好朋友，请用北京话回答问题，回答的时候可以适当添加表情符号\n" +
            "今天是{{current_date}}")*/
    @SystemMessage(fromResource = "prompt-template.txt")
    String chat(@MemoryId int memoryId, @UserMessage String userMessage);

    @SystemMessage(fromResource = "prompt-template-withV.txt")
    String chatWithV(@MemoryId int memoryId,
                     @UserMessage String userMessage,
                     @V("username") String username,
                     @V("age") int age);

}

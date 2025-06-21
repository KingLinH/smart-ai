package com.kinglin.smart.ai.assistant;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;
import reactor.core.publisher.Flux;

import static dev.langchain4j.service.spring.AiServiceWiringMode.EXPLICIT;

/**
 * @author HJinLin
 * @description
 * @date 2025-06-21 0:51
 */
@AiService(
        wiringMode = EXPLICIT,
        /*chatModel = "qwenChatModel",*/
        streamingChatModel = "qwenStreamingChatModel",
        chatMemoryProvider = "huaxiaotuoChatMemoryProvider",
        tools = "appointmentTools",
        contentRetriever = "huaxiaotuoContentRetrieverPinecone"
)
public interface HuaxiaotuoAgent {

    /*@SystemMessage(fromResource = "huaxiaotuo-prompt-template.txt")
    String chat(@MemoryId Long memoryId, @UserMessage String userMessage);*/

    /**
     * 流式输出
     */
    @SystemMessage(fromResource = "huaxiaotuo-prompt-template.txt")
    Flux<String> chat(@MemoryId Long memoryId, @UserMessage String userMessage);

}

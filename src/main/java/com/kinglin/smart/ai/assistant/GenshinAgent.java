package com.kinglin.smart.ai.assistant;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;
import reactor.core.publisher.Flux;

import static dev.langchain4j.service.spring.AiServiceWiringMode.EXPLICIT;

/**
 * 原小神智能体
 *
 * @author HJinLin
 * @date 2025-06-22 0:51
 */
@AiService(
        wiringMode = EXPLICIT,
        streamingChatModel = "qwenStreamingChatModel",
        chatMemoryProvider = "genshinChatMemoryProvider",
        tools = {"genshinTools", "commonTools"},
        contentRetriever = "genshinContentRetrieverPinecone"
)
public interface GenshinAgent {
    /**
     * 流式输出
     */
    @SystemMessage(fromResource = "genshin-prompt-template.txt")
    Flux<String> chat(@MemoryId Long memoryId, @UserMessage String userMessage);
}

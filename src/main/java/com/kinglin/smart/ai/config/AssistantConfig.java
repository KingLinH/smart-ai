package com.kinglin.smart.ai.config;

import com.kinglin.smart.ai.store.MongoChatMemoryStore;
import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.ChatMemoryProvider;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author HJinLin
 * @date 2025-06-20 22:28
 */
@Configuration
public class AssistantConfig {

    @Bean
    public ChatMemory chatMemory() {
        return MessageWindowChatMemory.withMaxMessages(10);
    }

    @Bean
    public ChatMemoryProvider chatMemoryProvider(MongoChatMemoryStore mongoChatMemoryStore) {
        return memoryId -> MessageWindowChatMemory.builder()
                .id(memoryId)
                .maxMessages(10)
                .chatMemoryStore(mongoChatMemoryStore)
                .build();
    }

    @Bean
    public ChatMemoryProvider huaxiaotuoChatMemoryProvider(MongoChatMemoryStore mongoChatMemoryStore) {
        return memoryId ->
                MessageWindowChatMemory.builder()
                        .id(memoryId)
                        .maxMessages(20)
                        .chatMemoryStore(mongoChatMemoryStore)
                        .build();
    }

}

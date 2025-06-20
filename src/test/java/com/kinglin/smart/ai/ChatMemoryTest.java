package com.kinglin.smart.ai;

import com.kinglin.smart.ai.assistant.Assistant;
import com.kinglin.smart.ai.assistant.MemoryChatAssistant;
import com.kinglin.smart.ai.assistant.SeparateChatAssistant;
import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.service.AiServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author HJinLin
 * @description 聊天记忆
 * @date 2025-06-20 22:14
 */
@SpringBootTest
public class ChatMemoryTest {
    @Autowired
    private MemoryChatAssistant memoryChatAssistant;
    @Autowired
    private SeparateChatAssistant separateChatAssistant;
    @Autowired
    private QwenChatModel qwenChatModel;

    @Test
    public void testChatMemory() {
        MessageWindowChatMemory messageWindowChatMemory = MessageWindowChatMemory.withMaxMessages(10);
        Assistant build = AiServices.builder(Assistant.class).chatLanguageModel(qwenChatModel).chatMemory(messageWindowChatMemory).build();
        String chat = build.chat("我是线条");
        System.out.println(chat);
        String chat1 = build.chat("我是谁");
        System.out.println(chat1);
    }

    @Test
    public void testChatMemoryByAnnotation() {
        String chat = memoryChatAssistant.chat("我是线条小狗");
        System.out.println(chat);
        String chat1 = memoryChatAssistant.chat("我是谁");
        System.out.println(chat1);
    }

    @Test
    public void testSeparateChat() {
        String chat = separateChatAssistant.chat(1, "我是线条小狗");
        System.out.println(chat);
        String chat1 = separateChatAssistant.chat(1, "我是谁");
        System.out.println(chat1);
        String chat2 = separateChatAssistant.chat(2, "我是谁");
        System.out.println(chat2);
    }

    @Test
    public void testSeparateChatWithSystemMessage() {
        String chat = separateChatAssistant.chat(4, "我是线条小狗");
        System.out.println(chat);
    }

    @Test
    public void testSeparateChatWithSystemMessageV() {
        // 模拟数据库查询
        String username = "tom";
        int age = 18;
        String chat = separateChatAssistant.chatWithV(5, "我是谁", username, age);
        System.out.println(chat);
    }

    @Test
    public void testTools() {
        String chat = separateChatAssistant.chat(1, "1+3等于多少？123456开平方呢");
        System.out.println(chat);
    }
}

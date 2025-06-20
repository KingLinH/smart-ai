package com.kinglin.smart.ai;

import dev.langchain4j.model.chat.ChatLanguageModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * LLM测试
 *
 * @author HJinLin
 * @date 2025-06-20 20:55
 */
@SpringBootTest
public class LLMTest {

    @Autowired
    private ChatLanguageModel openAiChatModel;
    @Autowired
    private ChatLanguageModel ollamaChatModel;
    @Autowired
    private ChatLanguageModel qwenChatModel;

    @Test
    public void testOpenAiGPT() {
        String chat = openAiChatModel.chat("你是谁");
        System.out.println(chat);
    }

    @Test
    public void testOllamaGPT() {
        String chat = ollamaChatModel.chat("你是谁");
        System.out.println(chat);
    }

    @Test
    public void testQwenGPT() {
        String chat = qwenChatModel.chat("你是谁");
        System.out.println(chat);
    }

}

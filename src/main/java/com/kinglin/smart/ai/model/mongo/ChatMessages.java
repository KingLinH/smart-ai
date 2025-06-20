package com.kinglin.smart.ai.model.mongo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author HJinLin
 * @description 聊天记录
 * @date 2025-06-20 23:20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("chat_messages")
public class ChatMessages {
    // mongodb文档id
    @Id
    private ObjectId messageId;

    private String memoryId;
    // 聊天记录
    private String content;
}

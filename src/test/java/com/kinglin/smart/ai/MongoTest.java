package com.kinglin.smart.ai;

import com.kinglin.smart.ai.model.mongo.ChatMessages;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

/**
 * @author HJinLin
 * @description
 * @date 2025-06-20 23:24
 */
@SpringBootTest
public class MongoTest {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void testInsert() {
        mongoTemplate.insert(new ChatMessages(new ObjectId(), "", "测试插入"));
    }

    @Test
    public void testInsert2() {
        ChatMessages chatMessages = new ChatMessages();
        chatMessages.setContent("测试自动生成id");
        mongoTemplate.insert(chatMessages);
    }

    @Test
    public void testUpdate() {
        Criteria criteria = Criteria.where("_id").is("68557ef60b4df33312edc574");
        Query query = new Query(criteria);
        Update update = new Update();
        update.set("content", "更新内容");
        mongoTemplate.upsert(query, update, ChatMessages.class);
    }

    @Test
    public void testUpdate2() {
        Criteria criteria = Criteria.where("_id").is("68557ef60b4df33312edc579");
        Query query = new Query(criteria);
        Update update = new Update();
        update.set("content", "测试upsert插入");
        mongoTemplate.upsert(query, update, ChatMessages.class);
    }

    @Test
    public void testDelete() {
        Criteria criteria = Criteria.where("_id").is("68557ef60b4df33312edc579");
        Query query = new Query(criteria);
        mongoTemplate.remove(query, ChatMessages.class);
    }
}

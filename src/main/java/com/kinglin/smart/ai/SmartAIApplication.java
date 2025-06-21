package com.kinglin.smart.ai;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.kinglin.smart.ai.mapper"})
public class SmartAIApplication {
    public static void main(String[] args) {
        SpringApplication.run(SmartAIApplication.class, args);
    }
}


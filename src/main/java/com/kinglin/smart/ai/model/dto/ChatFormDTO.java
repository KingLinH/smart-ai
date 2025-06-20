package com.kinglin.smart.ai.model.dto;

import lombok.Data;

/**
 * @author HJinLin
 * @description 用户对话 DTO
 * @date 2025-06-21 1:11
 */
@Data
public class ChatFormDTO {
    /**
     * 对话id
     */
    private Long memoryId;
    /**
     * 用户对话内容
     */
    private String message;
}

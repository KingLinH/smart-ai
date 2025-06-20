package com.kinglin.smart.ai.controller;

import com.kinglin.smart.ai.assistant.HuaxiaotuoAgent;
import com.kinglin.smart.ai.model.dto.ChatFormDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @author HJinLin
 * @description
 * @date 2025-06-21 1:13
 */
@Tag(name = "华小佗")
@RestController
@RequestMapping("/huaxiaotuo")
@RequiredArgsConstructor
public class HuaxiaotuoController {

    private final HuaxiaotuoAgent huaxiaotuoAgent;

    @PostMapping("/chat")
    public String chat(@RequestBody ChatFormDTO chatFormDTO) {
        return huaxiaotuoAgent.chat(chatFormDTO.getMemoryId(), chatFormDTO.getMessage());
    }

}

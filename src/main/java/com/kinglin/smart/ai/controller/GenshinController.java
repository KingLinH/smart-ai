package com.kinglin.smart.ai.controller;

import com.kinglin.smart.ai.assistant.GenshinAgent;
import com.kinglin.smart.ai.model.dto.ChatFormDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * 原神智能助手
 *
 * @author HJinLin
 * @date 2025-06-22 1:13
 */
@Tag(name = "原小神")
@RestController
@RequestMapping("/genshin")
@RequiredArgsConstructor
public class GenshinController {

    private final GenshinAgent genshinAgent;

    @PostMapping("/chat")
    public Flux<String> chat(@RequestBody ChatFormDTO chatFormDTO) {
        return genshinAgent.chat(chatFormDTO.getMemoryId(), chatFormDTO.getMessage());
    }

}

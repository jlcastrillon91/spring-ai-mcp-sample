package com.example.mcp_client.controller;

import com.example.mcp_client.dto.PromptRequest;
import com.example.mcp_client.service.PromptService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/prompt")
public class PromptController {

    private final PromptService promptService;

    public PromptController(PromptService promptService) {
        this.promptService = promptService;
    }

    @PostMapping
    public Flux<String> prompt(@RequestBody PromptRequest request) {
        return promptService.prompt(request.message());
    }
}
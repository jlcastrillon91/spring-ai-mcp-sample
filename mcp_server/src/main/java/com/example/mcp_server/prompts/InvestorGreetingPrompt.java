package com.example.mcp_server.prompts;

import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.spec.McpSchema.TextContent;
import io.modelcontextprotocol.spec.McpSchema.Role;
import org.springframework.ai.mcp.annotation.McpArg;
import org.springframework.ai.mcp.annotation.McpPrompt;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InvestorGreetingPrompt {
    @McpPrompt(
            name = "investor_greeting",
            description = "Greet the investor interested in investment opportunities in simple language")
    public McpSchema.GetPromptResult investorGreeting(
            @McpArg(name = "name", description = "User's name", required = true)
            String name) {

        String message = "Hello, " + name + "! How can I help you today?";

        return new McpSchema.GetPromptResult(
                "Greeting",
                List.of(new McpSchema.PromptMessage(Role.ASSISTANT, new TextContent(message)))
        );
    }
}

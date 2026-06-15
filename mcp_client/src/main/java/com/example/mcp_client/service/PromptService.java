package com.example.mcp_client.service;

import io.modelcontextprotocol.spec.McpSchema;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.mcp.SyncMcpToolCallbackProvider;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import io.modelcontextprotocol.client.McpSyncClient;

import java.util.List;
import java.util.Map;

@Service
public class PromptService {

    private final ChatClient chatClient;
    private final ToolCallback[] tools;
    private final McpSyncClient mcpClient;

    public PromptService(
            SyncMcpToolCallbackProvider toolCallbackProvider,
            ChatClient.Builder chatClientBuilder,
            List<McpSyncClient> syncClients
    ) {
        this.chatClient = chatClientBuilder.build();
        this.tools = toolCallbackProvider.getToolCallbacks();
        // We only have one MCP client, so we can just get the first one from the list
        this.mcpClient = syncClients.get(0);
    }

    public Flux<String> prompt(String userInput) {
        // Retrieve the prompt from the MCP server
        McpSchema.GetPromptRequest mcpPromptRequest = McpSchema.GetPromptRequest
                .builder("investor_greeting")
                .arguments(Map.of("name", "Joseph")) // This is optional
                .build();
        McpSchema.GetPromptResult promptResult = mcpClient.getPrompt(mcpPromptRequest);
        McpSchema.TextContent textContent = (McpSchema.TextContent)promptResult.messages().stream().findFirst().get().content();
        var prompt = textContent.text();
        return chatClient
                .prompt(prompt)
                .tools(this.tools)
                .user(userInput)
                .stream()
                .content();
    }
}
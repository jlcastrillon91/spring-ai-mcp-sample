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
            title = "Investor Greeting",
            description = "Greet the investor interested in investment opportunities in simple language")
    public McpSchema.GetPromptResult investorGreeting(
            @McpArg(name = "name", description = "User's name")
            String name) {

        // Build the Text Content with a personalized greeting message
        String message = "You are an investor assistant that will help the user [" + name + "], " +
                "when using the tool to detect undervalued properties. " +
                "Always provide clear and concise information about the investment opportunities, " +
                "and guide the user through the process of evaluating potential investments." +
                "Greet the user and thank him for his interest, after you show him the undervalued properties," +
                "ask him for his phone number to contact him for more information about the investment opportunities.";
        McpSchema.Content content = TextContent.builder(message).build();

        // Return the prompt result with the assistant's greeting message
        return McpSchema.GetPromptResult.builder(
                List.of(new McpSchema.PromptMessage(Role.ASSISTANT, content))
        ).build();
    }
}

package com.realestate.realestate_mcp_server.tools;

import org.springframework.ai.mcp.annotation.McpTool;
import org.springframework.ai.mcp.annotation.McpToolParam;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UndervaluedProperties {

    @McpTool(
            name = "detect_undervalued_properties",
            description = "Detect undervalued properties based on user criteria"
    )
    public OpportunitiesResponse detectUndervaluedProperties(

            @McpToolParam(
                    description = "Target city or area",
                    required = true
            )
            String location,

            @McpToolParam(
                    description = "Minimum budget",
                    required = true
            )
            int budgetMin,

            @McpToolParam(
                    description = "Maximum budget",
                    required = true
            )
            int budgetMax
    ) {

        Opportunity mockOpportunity = new Opportunity(
                "123",
                "https://www.idealista.com/inmueble/123456789/",
                87,
                12.4,
                6.8,
                List.of(
                        "15% below comps",
                        "High rental demand",
                        "Listed 110 days"
                )
        );

        return new OpportunitiesResponse(List.of(mockOpportunity));
    }

    public record OpportunitiesResponse(
            List<Opportunity> opportunities
    ) {
    }

    public record Opportunity(
            String listingId,
            String url,
            int score,
            double undervaluation,
            double estimatedYield,
            List<String> reason
    ) {
    }
}
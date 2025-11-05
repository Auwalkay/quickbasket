package com.quickbasket.quickbasket.shop.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AssignAgentRequest {
    @NotBlank(message = "Shop id is required")
    private String shopId;

    @NotBlank(message = "Agent id is required")
    private String agentId;
}

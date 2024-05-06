package com.sopt.carrotmarket.common.dto;

import com.sopt.carrotmarket.common.dto.message.SuccessMessage;

public record SuccessStatusResponse(
        int status,
        String message
) {

    public static SuccessStatusResponse from(SuccessMessage successMessage) {
        return new SuccessStatusResponse(successMessage.getStatus(), successMessage.getMessage());
    }
}
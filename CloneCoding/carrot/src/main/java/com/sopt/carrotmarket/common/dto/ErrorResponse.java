package com.sopt.carrotmarket.common.dto;

import com.sopt.carrotmarket.common.dto.message.ErrorMessage;

public record ErrorResponse(
        int status,
        String message
) {
    public static ErrorResponse from(ErrorMessage errorMessage) {
        return new ErrorResponse(errorMessage.getStatus(), errorMessage.getMessage());
    }
}

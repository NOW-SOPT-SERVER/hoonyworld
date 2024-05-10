package com.sopt.org.common.dto;

import com.sopt.org.common.dto.message.SuccessMessage;

public record SuccessStatusResponse(
        int status,
        String message
) {

    public static SuccessStatusResponse of(SuccessMessage successMessage) {
        return new SuccessStatusResponse(successMessage.getStatus(), successMessage.getMessage());
    }
}
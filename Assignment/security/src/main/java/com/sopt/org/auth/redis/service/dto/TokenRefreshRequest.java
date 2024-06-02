package com.sopt.org.auth.redis.service.dto;

public record TokenRefreshRequest(
        String refreshToken
) {
}

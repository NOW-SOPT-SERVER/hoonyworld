package com.sopt.org.auth.redis.service.dto;

public record LoginRequest(
        String name,
        String password
) {
}

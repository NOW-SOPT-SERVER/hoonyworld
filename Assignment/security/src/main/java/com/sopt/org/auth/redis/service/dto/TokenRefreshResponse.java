package com.sopt.org.auth.redis.service.dto;

public record TokenRefreshResponse(String newAccessToken, String newRefreshToken) {

    public static TokenRefreshResponse of(String newAccessToken, String newRefreshToken) {
        return new TokenRefreshResponse(newAccessToken, newRefreshToken);
    }
}
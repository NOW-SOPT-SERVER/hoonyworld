package com.sopt.carrotmarket.service.dto;

public record LikeCreateRequest(
        Long memberId,
        Long itemId
) {
}
package com.sopt.carrotmarket.service.dto;

import com.sopt.carrotmarket.domain.constant.Location;

public record MemberCreateRequest(
        String username,
        String email,
        String password,
        Location location
) {
}
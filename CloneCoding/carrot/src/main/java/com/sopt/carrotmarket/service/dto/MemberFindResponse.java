package com.sopt.carrotmarket.service.dto;

import com.sopt.carrotmarket.domain.Member;
import com.sopt.carrotmarket.domain.constant.Location;

public record MemberFindResponse(
        String username,
        Location location
) {
    public static MemberFindResponse from(
            Member member
    ) {
        return new MemberFindResponse(member.getUsername(), member.getLocation());
    }
}
package com.sopt.org.service.dto;

import com.sopt.org.domain.Member;
import com.sopt.org.domain.Part;

public record MemberFindDto(
        String name,
        Part part,
        int age
) {

    public static MemberFindDto of(
            Member member
    ) {
        return new MemberFindDto(member.getName(), member.getPart(), member.getAge());
    }
}

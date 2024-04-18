package com.sopt.org.service.dto;

import com.sopt.org.domain.Member;
import com.sopt.org.domain.Part;

import java.util.List;

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

    public static List<MemberFindDto> listOf(
            List<Member> members
    ) {
        return members.stream()
                .map(MemberFindDto::of)
                .toList();
    }
}

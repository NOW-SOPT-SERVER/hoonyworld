package com.sopt.org.service.dto;

import com.sopt.org.domain.Part;

public record MemberCreateDto(
        String name,
        Part part,
        int age
) {

}

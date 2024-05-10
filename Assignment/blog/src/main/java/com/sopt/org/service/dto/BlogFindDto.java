package com.sopt.org.service.dto;

import com.sopt.org.domain.Blog;

public record BlogFindDto(
        Long memberId,
        String title,
        String description
) {
    public static BlogFindDto from(Blog blog) {
        return new BlogFindDto(
                blog.getMember().getId(), // 프록시 초기화 없이 ID 접근
                blog.getTitle(),
                blog.getDescription());
    }
}
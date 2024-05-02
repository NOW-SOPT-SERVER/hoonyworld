package com.sopt.org.service.dto;

import com.sopt.org.domain.Blog;
import com.sopt.org.domain.Member;

public record BlogFindDto(
        Member member,
        String title,
        String description
) {
    public static BlogFindDto from(Blog blog) {
        return new BlogFindDto(blog.getMember(), blog.getTitle(), blog.getDescription());
    }
}
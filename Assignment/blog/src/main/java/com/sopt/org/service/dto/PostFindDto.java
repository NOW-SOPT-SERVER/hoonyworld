package com.sopt.org.service.dto;

import com.sopt.org.domain.Post;

public record PostFindDto(
        String title,
        String content,
        Long blogId,  // Blog 객체 대신 Blog의 ID만 포함
        Long memberId // Member 객체 대신 Member의 ID만 포함
) {
    public static PostFindDto from(Post post) {
        return new PostFindDto(
                post.getTitle(),
                post.getContent(),
                post.getBlog().getId(),
                post.getBlog().getMember().getId()
        );
    }
}
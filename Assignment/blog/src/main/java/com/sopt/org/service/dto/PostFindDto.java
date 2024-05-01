package com.sopt.org.service.dto;

import com.sopt.org.domain.Blog;
import com.sopt.org.domain.Post;

public record PostFindDto(
        String title,
        String content,
        Blog blog
) {
    public static PostFindDto from(Post post) {
        return new PostFindDto(post.getTitle(), post.getContent(), post.getBlog());
    }
}

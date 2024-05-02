package com.sopt.org.service.dto;

import com.sopt.org.domain.Blog;
import com.sopt.org.domain.Member;
import com.sopt.org.domain.Post;

public record PostFindDto(
        String title,
        String content,
        Blog blog,
        Member member
) {
    public static PostFindDto from(Post post) {
        return new PostFindDto(post.getTitle(), post.getContent(), post.getBlog(), post.getBlog().getMember());
    }
}

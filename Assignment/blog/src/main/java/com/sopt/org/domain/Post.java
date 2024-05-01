package com.sopt.org.domain;

import com.sopt.org.service.dto.PostCreateRequest;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Post extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private Blog blog;

    public static Post create(final PostCreateRequest postCreateRequest, final Blog blog) {
        return Post.builder()
                .title(postCreateRequest.title())
                .content(postCreateRequest.content())
                .blog(blog)
                .build();
    }

    @Builder
    public Post(final Blog blog, final String title, final String content) {
        this.blog = blog;
        this.title = title;
        this.content = content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

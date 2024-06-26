package com.sopt.org.domain;

import com.sopt.org.service.dto.PostCreateRequestDto;
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
    @JoinColumn(name = "blog_id")
    private Blog blog;

    public static Post create(final PostCreateRequestDto postCreateRequestDto, final Blog blog) {
        return Post.builder()
                .title(postCreateRequestDto.title())
                .content(postCreateRequestDto.content())
                .blog(blog)
                .build();
    }

    @Builder
    public Post(final Blog blog, final String title, final String content) {
        this.blog = blog;
        this.title = title;
        this.content = content;
    }

    public void setPostContent(String content) {
        this.content = content;
    }
}

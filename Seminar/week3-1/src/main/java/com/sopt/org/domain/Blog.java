package com.sopt.org.domain;

import com.sopt.org.service.dto.BlogCreateRequest;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Blog extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    private Member member;

    @Column(length = 200)
    private String title;

    private String description;

    public static Blog create(final Member member, final BlogCreateRequest blogCreateRequest) {
        return Blog.builder()
                .member(member)
                .title(blogCreateRequest.title())
                .description(blogCreateRequest.description())
                .build();
    }

    @Builder
    public Blog(Member member, String title, String description) {
        this.member = member;
        this.title = title;
        this.description = description;
    }

    public void updateTitle(String title) {
        this.title = title;
    }
}

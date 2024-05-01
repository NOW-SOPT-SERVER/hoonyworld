package com.sopt.org.service;

import com.sopt.org.domain.Blog;
import com.sopt.org.domain.Member;
import com.sopt.org.repository.BlogRepository;
import com.sopt.org.service.dto.BlogCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;
    private final MemberService memberService;

    public String create(Long memberId, BlogCreateRequest blogCreateRequest) {
        Member member = memberService.findById(memberId);
        Blog blog = blogRepository.save(Blog.create(member, blogCreateRequest));
        return blog.getId().toString();
    }
}
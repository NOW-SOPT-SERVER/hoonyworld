package com.sopt.org.service;

import com.sopt.org.domain.Blog;
import com.sopt.org.domain.Member;
import com.sopt.org.exception.NotFoundException;
import com.sopt.org.common.dto.message.ErrorMessage;
import com.sopt.org.repository.BlogRepository;
import com.sopt.org.service.dto.BlogCreateRequest;
import com.sopt.org.service.dto.BlogFindDto;
import com.sopt.org.service.dto.BlogTitleUpdateRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;
    private final MemberService memberService;

    public String createBlog(Long memberId, BlogCreateRequest blogCreateRequest) {
        Member member = memberService.findById(memberId);
        Blog blog = blogRepository.save(Blog.create(member, blogCreateRequest));
        return blog.getId().toString();
    }

    // GET 요청을 위한 DTO
    public BlogFindDto findBlogDtoById(Long blogId) {
        Blog blog = blogRepository.findById(blogId).orElseThrow(
                () -> new NotFoundException(ErrorMessage.BLOG_NOT_FOUND_BY_ID_EXCEPTION));
        return BlogFindDto.from(blog);
    }

    public Blog findBlogById(Long blogId) {
        Blog blog = blogRepository.findById(blogId).orElseThrow(
                () -> new NotFoundException(ErrorMessage.BLOG_NOT_FOUND_BY_ID_EXCEPTION));
        return blog;
    }

    @Transactional
    public void updateBlogTitle(Long blogId, BlogTitleUpdateRequest blogTitleUpdateRequest) {
        Blog blog = blogRepository.findById(blogId).orElseThrow(
                () -> new NotFoundException(ErrorMessage.BLOG_NOT_FOUND_BY_ID_EXCEPTION));
        blog.setBlogTitle(blogTitleUpdateRequest.title());
    }
}
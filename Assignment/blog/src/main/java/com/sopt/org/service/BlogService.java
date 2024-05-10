package com.sopt.org.service;

import com.sopt.org.domain.Blog;
import com.sopt.org.domain.Member;
import com.sopt.org.exception.NotFoundException;
import com.sopt.org.common.dto.message.ErrorMessage;
import com.sopt.org.exception.ForbiddenBlogAccessException;
import com.sopt.org.repository.BlogRepository;
import com.sopt.org.service.dto.BlogCreateRequestDto;
import com.sopt.org.service.dto.BlogFindDto;
import com.sopt.org.service.dto.BlogTitleUpdateRequestDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;
    private final MemberService memberService;

    public String createBlog(Long memberId, BlogCreateRequestDto blogCreateRequestDto) {
        Member member = memberService.findById(memberId);
        Blog blog = blogRepository.save(Blog.create(member, blogCreateRequestDto));
        return blog.getId().toString();
    }

    // GET 요청을 위한 DTO
    public BlogFindDto findBlogDtoById(Long blogId) {
        Blog blog = findBlogAndValidate(blogId);
        return BlogFindDto.from(blog);
    }

    public Blog findBlogById(Long blogId) {
        Blog blog = findBlogAndValidate(blogId);
        return blog;
    }

    @Transactional
    public void updateBlogTitle(Long memberId, Long blogId, BlogTitleUpdateRequestDto blogTitleUpdateRequestDto) {
        Blog blog = findBlogAndValidate(blogId);
        validateBlogOwner(blog, memberId);
        blog.setBlogTitle(blogTitleUpdateRequestDto.title());
    }

    // Blog 존재 확인 메서드
    private Blog findBlogAndValidate(Long blogId) {
        return blogRepository.findById(blogId).orElseThrow(
                () -> new NotFoundException(ErrorMessage.BLOG_NOT_FOUND_BY_ID_EXCEPTION));
    }

    // Blog 소유권 검증 메서드
    public void validateBlogOwner(Blog blog, Long memberId) {
        if (!blog.getMember().getId().equals(memberId)) {
            throw new ForbiddenBlogAccessException(ErrorMessage.NOT_OWNER_OF_THIS_BLOG);
        }
    }
}
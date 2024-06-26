package com.sopt.org.service;

import com.sopt.org.domain.Blog;
import com.sopt.org.domain.Post;
import com.sopt.org.exception.NotFoundException;
import com.sopt.org.common.dto.message.ErrorMessage;
import com.sopt.org.exception.ForbiddenBlogAccessException;
import com.sopt.org.exception.ForbiddenPostAccessException;
import com.sopt.org.repository.PostRepository;
import com.sopt.org.service.dto.PostCreateRequestDto;
import com.sopt.org.service.dto.PostContentUpdateRequestDto;
import com.sopt.org.service.dto.PostFindDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final BlogService blogService;

    public String createPost(Long memberId, Long blogId, PostCreateRequestDto postCreateRequestDto) {
        Blog blog = blogService.findBlogById(blogId);
        blogService.validateBlogOwner(blog, memberId);
        Post post = Post.create(postCreateRequestDto, blog);
        postRepository.save(post);
        return post.getId().toString();
    }

    // GET 요청을 위한 DTO
    public PostFindDto findPostDtoById(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new NotFoundException(ErrorMessage.POST_NOT_FOUND_BY_ID_EXCEPTION));
        return PostFindDto.from(post);
    }

    @Transactional
    public void updatePostContent(Long memberId, Long blogId, Long postId, PostContentUpdateRequestDto postContentUpdateRequestDto) {
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new NotFoundException(ErrorMessage.POST_NOT_FOUND_BY_ID_EXCEPTION));

        // 포스트가 속한 블로그의 ID와 요청된 blogId가 일치하는지 확인
        if (!post.getBlog().getId().equals(blogId)) {
            throw new ForbiddenPostAccessException(ErrorMessage.POST_DOES_NOT_BELONG_TO_BLOG);
        }

        // 블로그 소유주 확인
        if (!post.getBlog().getMember().getId().equals(memberId)) {
            throw new ForbiddenBlogAccessException(ErrorMessage.NOT_OWNER_OF_THIS_BLOG);
        }

        post.setPostContent(postContentUpdateRequestDto.content());
    }
}
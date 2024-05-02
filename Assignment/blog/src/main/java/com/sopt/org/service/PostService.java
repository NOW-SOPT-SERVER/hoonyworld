package com.sopt.org.service;

import com.sopt.org.domain.Blog;
import com.sopt.org.domain.Post;
import com.sopt.org.exception.NotFoundException;
import com.sopt.org.common.dto.message.ErrorMessage;
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

    public String createPost(Long blogId, PostCreateRequestDto postCreateRequestDto) {
        Blog blog = blogService.findBlogById(blogId);
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
    public void updatePostContent(Long blogId, Long postId, PostContentUpdateRequestDto postContentUpdateRequestDto) {
        blogService.findBlogById(blogId); // 블로그 존재 확인
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new NotFoundException(ErrorMessage.POST_NOT_FOUND_BY_ID_EXCEPTION));
        post.setPostContent(postContentUpdateRequestDto.content());
    }
}
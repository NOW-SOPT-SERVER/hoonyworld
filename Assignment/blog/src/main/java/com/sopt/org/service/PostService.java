package com.sopt.org.service;

import com.sopt.org.domain.Blog;
import com.sopt.org.domain.Post;
import com.sopt.org.exception.NotFoundException;
import com.sopt.org.exception.message.ErrorMessage;
import com.sopt.org.repository.PostRepository;
import com.sopt.org.service.dto.PostCreateRequest;
import com.sopt.org.service.dto.PostUpdateRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final BlogService blogService;

    public String create(Long blogId, PostCreateRequest postCreateRequest) {
        Blog blog = blogService.findBlogById(blogId);
        Post post = Post.create(postCreateRequest, blog);
        postRepository.save(post);
        return post.getId().toString();
    }

    @Transactional
    public void updateContent(Long postId, PostUpdateRequest postUpdateRequest) {
        Post post = findPostById(postId);
        post.updateContent(postUpdateRequest.content());
    }

    public Post findPostById(Long postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new NotFoundException(ErrorMessage.POST_NOT_FOUND));
    }
}
package com.sopt.org.controller;

import com.sopt.org.common.dto.message.SuccessMessage;
import com.sopt.org.domain.Blog;
import com.sopt.org.service.BlogService;
import com.sopt.org.service.PostService;
import com.sopt.org.service.dto.PostCreateRequest;
import com.sopt.org.common.dto.SuccessStatusResponse;
import com.sopt.org.service.dto.PostContentUpdateRequest;
import com.sopt.org.service.dto.PostFindDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    private final BlogService blogService;

    @PostMapping("/blog/{blogId}/post")
    public ResponseEntity<SuccessStatusResponse> createPost(
            @PathVariable Long blogId,
            @Valid @RequestBody PostCreateRequest postCreateRequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Location",
                        postService.createPost(blogId, postCreateRequest))
                .body(SuccessStatusResponse.of(SuccessMessage.POST_CREATE_SUCCESS));
    }

    @GetMapping("/blog/{blogId}/post/{postId}")
    public ResponseEntity<PostFindDto> getPost(
            @PathVariable Long blogId,
            @PathVariable Long postId) {
        blogService.findBlogById(blogId); // 블로그 존재 확인
        return ResponseEntity.ok(postService.findPostDtoById(postId));
    }

    @PatchMapping("/blog/{blogId}/post/{postId}/content")
    public ResponseEntity<SuccessStatusResponse> updatePostContent(
            @PathVariable Long blogId,
            @PathVariable Long postId,
            @Valid @RequestBody PostContentUpdateRequest postContentUpdateRequest) { // 내용이 50자 이상 넘을 경우 400 Bad Request
        postService.updatePostContent(blogId, postId, postContentUpdateRequest);
        return ResponseEntity.ok()
                .body(SuccessStatusResponse.of(SuccessMessage.POST_CONTENT_UPDATE_SUCCESS));
    }
}
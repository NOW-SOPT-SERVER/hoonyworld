package com.sopt.org.controller;

import com.sopt.org.common.dto.SuccessMessage;
import com.sopt.org.domain.Post;
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

    @PostMapping("/blog/{blogId}/post")
    public ResponseEntity<SuccessStatusResponse> createPost(
            @PathVariable Long blogId,
            @Valid @RequestBody PostCreateRequest postCreateRequest) {
        String postId = postService.createPost(blogId, postCreateRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Location", "/api/v1/blog/" + blogId + "/post/" + postId)
                .body(SuccessStatusResponse.of(SuccessMessage.POST_CREATE_SUCCESS));
    }

    @GetMapping("/blog/{blogId}/post/{postId}")
    public ResponseEntity<PostFindDto> getPost(
            @PathVariable Long blogId,
            @PathVariable Long postId) {
        Post post = postService.findPostById(postId);
        PostFindDto postFindDto = PostFindDto.from(post);
        return ResponseEntity.ok(postFindDto);
    }

    @PatchMapping("/blog/{blogId}/post/{postId}")
    public ResponseEntity updatePostContent(
            @RequestHeader Long blogId,
            @PathVariable Long postId,
            @Valid @RequestBody PostContentUpdateRequest postContentUpdateRequest) {
        postService.updateContent(postId, postContentUpdateRequest);
        return ResponseEntity.ok().body(SuccessMessage.POST_UPDATE_SUCCESS);
    }
}
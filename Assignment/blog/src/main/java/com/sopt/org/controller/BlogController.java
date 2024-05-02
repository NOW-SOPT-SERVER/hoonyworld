package com.sopt.org.controller;

import com.sopt.org.common.dto.message.SuccessMessage;
import com.sopt.org.common.dto.SuccessStatusResponse;
import com.sopt.org.service.BlogService;
import com.sopt.org.service.dto.BlogCreateRequest;
import com.sopt.org.service.dto.BlogFindDto;
import com.sopt.org.service.dto.BlogTitleUpdateRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class BlogController {

    private final BlogService blogService;

    @PostMapping("/blog")
    public ResponseEntity<SuccessStatusResponse> createBlog(
            @RequestHeader Long memberId,
            @Valid @RequestBody BlogCreateRequest blogCreateRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).header(
                        "Location",
                        blogService.createBlog(memberId, blogCreateRequest))
                .body(SuccessStatusResponse.of(SuccessMessage.BLOG_CREATE_SUCCESS));
    }

    @GetMapping("blog/{blogId}")
    public ResponseEntity<BlogFindDto> getBlog(
            @PathVariable Long blogId) {
        return ResponseEntity.ok(blogService.findBlogDtoById(blogId));
    }

    @PatchMapping("/blog/{blogId}/title")
    public ResponseEntity<SuccessStatusResponse> updateBlogTitle(
            @PathVariable Long blogId,
            @Valid @RequestBody BlogTitleUpdateRequest blogTitleUpdateRequest // 블로그 글이 5
    ) {
        blogService.updateBlogTitle(blogId, blogTitleUpdateRequest);
        return ResponseEntity.ok()
                .body(SuccessStatusResponse.of(SuccessMessage.BLOG_TITLE_UPDATE_SUCCESS));
    }
}


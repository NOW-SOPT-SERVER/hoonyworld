package com.sopt.org.controller;

import com.sopt.org.common.dto.message.SuccessMessage;
import com.sopt.org.common.dto.SuccessStatusResponse;
import com.sopt.org.service.BlogService;
import com.sopt.org.service.dto.BlogCreateRequestDto;
import com.sopt.org.service.dto.BlogFindDto;
import com.sopt.org.service.dto.BlogTitleUpdateRequestDto;
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
            @RequestHeader Long memberId, // 보안상의 이유로 인해 사용자의 식별 정보는 URL에 노출되지 않도록 헤더로 처리
            @Valid @RequestBody BlogCreateRequestDto blogCreateRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).header(
                        "Location",
                        blogService.createBlog(memberId, blogCreateRequestDto))
                .body(SuccessStatusResponse.of(SuccessMessage.BLOG_CREATE_SUCCESS));
    }

    @GetMapping("/blog/{blogId}")
    public ResponseEntity<BlogFindDto> getBlog(
            @PathVariable Long blogId) {
        return ResponseEntity.ok(blogService.findBlogDtoById(blogId));
    }

    @PatchMapping("/blog/{blogId}/title")
    public ResponseEntity<SuccessStatusResponse> updateBlogTitle(
            @RequestHeader Long memberId,
            @PathVariable Long blogId,
            @Valid @RequestBody BlogTitleUpdateRequestDto blogTitleUpdateRequestDto // 블로그 글이 5자 이상이면 400 Bad Request
    ) {
        blogService.updateBlogTitle(memberId, blogId, blogTitleUpdateRequestDto);
        return ResponseEntity.ok()
                .body(SuccessStatusResponse.of(SuccessMessage.BLOG_TITLE_UPDATE_SUCCESS));
    }
}


package com.sopt.org.service.dto;

import jakarta.validation.constraints.Size;

public record PostUpdateRequest(
        @Size(max = 1000, message = "게시글 내용은 최대 1000자까지 가능합니다.")
        String content
) {
}



package com.sopt.org.service.dto;

import jakarta.validation.constraints.Size;

public record PostContentUpdateRequestDto(
        @Size(max = 50, message = "게시글 내용은 최대 50자까지 가능합니다.")
        String content
) {
}
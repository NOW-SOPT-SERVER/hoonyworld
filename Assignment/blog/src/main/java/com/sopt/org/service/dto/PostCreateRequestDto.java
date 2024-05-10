package com.sopt.org.service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record PostCreateRequestDto(
        @NotBlank(message = "게시글 제목은 필수로 입력해야 합니다.")
        @Size(min = 1, max = 15, message = "게시글 제목은 1자 이상 15자 이하로 설정해야 합니다.")
        String title,

        @NotBlank(message = "게시글 내용은 필수로 입력해야 합니다")
        @Size(max = 50, message = "게시글 내용은 최대 50자까지 가능합니다.")
        String content
) {
}
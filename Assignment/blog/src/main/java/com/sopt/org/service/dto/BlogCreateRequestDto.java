package com.sopt.org.service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record BlogCreateRequestDto(
        @NotBlank(message = "블로그 제목은 필수로 입력해야 합니다.")
        @Size(min = 1, max = 15, message = "블로그 제목은 1자 이상 15자 이하로 설정해야 합니다.")
        String title,

        @NotBlank(message = "블로그 설명은 필수로 입력해야 합니다.")
        String description
) {
}
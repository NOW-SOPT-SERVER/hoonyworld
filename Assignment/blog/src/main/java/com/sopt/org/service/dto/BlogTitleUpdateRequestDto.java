package com.sopt.org.service.dto;

import jakarta.validation.constraints.Size;

public record BlogTitleUpdateRequestDto(
        @Size(max = 15 , message = "블로그 제목이 최대 글자 수(15자)를 초과했습니다.")
        String title
) {
}
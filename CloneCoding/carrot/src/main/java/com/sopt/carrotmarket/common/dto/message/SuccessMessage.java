package com.sopt.carrotmarket.common.dto.message;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum SuccessMessage {
    ITEM_REGISTER_SUCCESS(HttpStatus.CREATED.value(), "[SUCCESS] 내 물건 등록이 완료되었습니다");

    private final int status;
    private final String message;
}

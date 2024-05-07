package com.sopt.carrotmarket.common.dto.message;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum SuccessMessage {
    MEMBER_CREATE_SUCCESS(HttpStatus.CREATED.value(),"[SUCCESS] 회원가입이 완료되었습니다."),
    ITEM_REGISTER_SUCCESS(HttpStatus.CREATED.value(), "[SUCCESS] 내 물건 등록이 완료되었습니다."),
    EXTRA_LIKE_BUTTON(HttpStatus.CREATED.value(), "[SUCCESS] 좋아요 버튼을 누르셨습니다."),
    DELETE_LIKE_BUTTON(HttpStatus.CREATED.value(), "[SUCCESS] 좋아요 버튼을 취소하셨습니다.");

    private final int status;
    private final String message;
}

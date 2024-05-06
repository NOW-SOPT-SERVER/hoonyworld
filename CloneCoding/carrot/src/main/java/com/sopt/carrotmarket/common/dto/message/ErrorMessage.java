package com.sopt.carrotmarket.common.dto.message;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorMessage {
    MEMBER_NOT_FOUND_BY_ID_EXCEPTION(HttpStatus.NOT_FOUND.value(), "[ERROR] ID에 해당하는 사용자가 존재하지 않습니다."),
    ITEM_NOT_FOUND_BY_ID_EXCEPTION(HttpStatus.NOT_FOUND.value(), "[ERROR] ID에 해당하는 물건이 존재하지 않습니다.");

    private final int status;
    private final String message;
}
package com.sopt.org.exception.message;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorMessage {
    MEMBER_NOT_FOUND_BY_ID_EXCEPTION(HttpStatus.NOT_FOUND.value(), "ID에 해당하는 사용자가 존재하지 않습니다."),
    BLOG_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "타이틀 오류"),
    JWT_UNAUTHORIZED_EXCEPTION(HttpStatus.UNAUTHORIZED.value(), "사용자의 로그인 검증을 실패했습니다."),
    REFRESH_TOKEN_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "유효한 리프레시 토큰을 찾을 수 없습니다."),
    INVALID_USERNAME_OR_PASSWORD(HttpStatus.UNAUTHORIZED.value(), "유효하지 않은 이름 혹은 비밀번호 입니다.");

    private final int status;
    private final String message;
}
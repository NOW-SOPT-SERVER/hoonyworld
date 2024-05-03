package com.sopt.org.common.dto.message;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorMessage {
    MEMBER_NOT_FOUND_BY_ID_EXCEPTION(HttpStatus.NOT_FOUND.value(), "ID에 해당하는 사용자가 존재하지 않습니다."),
    BLOG_NOT_FOUND_BY_ID_EXCEPTION(HttpStatus.NOT_FOUND.value(), "ID에 해당하는 블로그가 존재하지 않습니다"),
    POST_NOT_FOUND_BY_ID_EXCEPTION(HttpStatus.NOT_FOUND.value(), "ID에 해당하는 포스트가 존재하지 않습니다"),
    NOT_OWNER_OF_THIS_BLOG(HttpStatus.FORBIDDEN.value(), "해당 블로그의 소유자가 아닙니다."),
    POST_DOES_NOT_BELONG_TO_BLOG(HttpStatus.FORBIDDEN.value(), "해당 포스트는 지정된 블로그에 속하지 않습니다.");

    private final int status;
    private final String message;
}
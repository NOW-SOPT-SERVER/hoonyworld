package com.sopt.org.common.dto.message;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum SuccessMessage {

    BLOG_CREATE_SUCCESS(HttpStatus.CREATED.value(),"블로그 생성이 완료되었습니다."),
    POST_CREATE_SUCCESS(HttpStatus.CREATED.value(),"게시글 생성이 완료되었습니다."),
    BLOG_TITLE_UPDATE_SUCCESS(HttpStatus.OK.value(),"블로그 제목이 성공적으로 업데이트되었습니다."),
    POST_CONTENT_UPDATE_SUCCESS(HttpStatus.OK.value(),"게시글 내용이 성공적으로 업데이트되었습니다."),
    POST_RETRIEVED_SUCCESS(HttpStatus.OK.value(),"게시글 조회 성공");
    private final int status;
    private final String message;
}

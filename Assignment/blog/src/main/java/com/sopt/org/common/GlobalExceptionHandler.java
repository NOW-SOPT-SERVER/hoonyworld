package com.sopt.org.common;

import com.sopt.org.common.dto.ErrorResponse;
import com.sopt.org.exception.NotFoundException;
import com.sopt.org.exception.ForbiddenBlogAccessException;
import com.sopt.org.exception.ForbiddenPostAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // 커스텀한 NotFoundException
    @ExceptionHandler(NotFoundException.class)
    protected ResponseEntity<ErrorResponse> handleNotFoundException(NotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ErrorResponse.of(e.getErrorMessage().getStatus(), e.getMessage()));
    }

    // @Valid 어노테이션 유효성 검사 -> 에러 시 MethodArgumentNotValidException
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ErrorResponse.of(HttpStatus.BAD_REQUEST.value(), Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage()));
    }

    // 커스텀한 UnauthorizedBlogAccessException
    @ExceptionHandler(ForbiddenBlogAccessException.class)
    protected ResponseEntity<ErrorResponse> handleUnauthorizedBlogAccessException(ForbiddenBlogAccessException e) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .body(ErrorResponse.of(e.getErrorMessage().getStatus(), e.getMessage()));
    }

    @ExceptionHandler(ForbiddenPostAccessException.class)
    protected ResponseEntity<ErrorResponse> handleUnauthorizedPostAccessException(ForbiddenPostAccessException e) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .body(ErrorResponse.of(e.getErrorMessage().getStatus(), e.getMessage()));
    }
}
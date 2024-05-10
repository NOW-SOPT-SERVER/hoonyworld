package com.sopt.org.exception;

import com.sopt.org.common.dto.message.ErrorMessage;
import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {
    private ErrorMessage errorMessage;

    public BusinessException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
        this.errorMessage = errorMessage;
    }
}
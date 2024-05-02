package com.sopt.org.exception;

import com.sopt.org.common.dto.message.ErrorMessage;

public class NotFoundException extends BusinessException {
    public NotFoundException(ErrorMessage errorMessage) {
        super(errorMessage);
    }
}
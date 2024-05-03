package com.sopt.org.exception;

import com.sopt.org.common.dto.message.ErrorMessage;

public class UnauthorizedPostAccessException extends BusinessException {
    public UnauthorizedPostAccessException(ErrorMessage errorMessage) {
        super(errorMessage);
    }
}

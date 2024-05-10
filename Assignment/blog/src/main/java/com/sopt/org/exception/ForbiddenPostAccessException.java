package com.sopt.org.exception;

import com.sopt.org.common.dto.message.ErrorMessage;

public class ForbiddenPostAccessException extends BusinessException {
    public ForbiddenPostAccessException(ErrorMessage errorMessage) {
        super(errorMessage);
    }
}

package com.sopt.carrotmarket.exception;

import com.sopt.carrotmarket.common.dto.message.ErrorMessage;

public class NotFoundException extends BusinessException {
    public NotFoundException(ErrorMessage errorMessage) {
        super(errorMessage);
    }
}

package com.sopt.org.exception;

import com.sopt.org.common.dto.message.ErrorMessage;

public class ForbiddenBlogAccessException extends BusinessException{
    public ForbiddenBlogAccessException(ErrorMessage errorMessage) {
        super(errorMessage);
    }
}

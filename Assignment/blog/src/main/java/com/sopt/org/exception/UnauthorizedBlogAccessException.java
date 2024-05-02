package com.sopt.org.exception;

import com.sopt.org.common.dto.message.ErrorMessage;

public class UnauthorizedBlogAccessException extends BusinessException{
    public UnauthorizedBlogAccessException(ErrorMessage errorMessage) {
        super(errorMessage);
    }
}

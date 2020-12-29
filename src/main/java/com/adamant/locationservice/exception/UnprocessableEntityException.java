package com.adamant.locationservice.exception;

import com.adamant.locationservice.exception.enums.ErrorCode;

public class UnprocessableEntityException extends DetailAddableException {

    public UnprocessableEntityException() {
        super(ErrorCode.UNPROCESSABLE_ENTITY);
    }
}

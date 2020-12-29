package com.adamant.locationservice.exception;

import com.adamant.locationservice.exception.enums.ErrorCode;
import lombok.Getter;

@Getter
public class ValidationException extends DetailAddableException {

    public ValidationException(String message) {
        super(message, ErrorCode.VALIDATION_ERROR);
    }
}


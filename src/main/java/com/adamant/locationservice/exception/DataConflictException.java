package com.adamant.locationservice.exception;

import com.adamant.locationservice.exception.enums.ErrorCode;

public class DataConflictException extends DetailAddableException {

    public DataConflictException() {
        super(ErrorCode.CONFLICT);
    }
}

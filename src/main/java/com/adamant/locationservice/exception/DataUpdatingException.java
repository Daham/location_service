package com.adamant.locationservice.exception;

import com.adamant.locationservice.exception.enums.ErrorCode;

public class DataUpdatingException extends DetailAddableException {

    public DataUpdatingException() {
        super(ErrorCode.INTERNAL_SERVER_ERROR);
    }
}

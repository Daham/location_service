package com.adamant.locationservice.exception;

import com.adamant.locationservice.exception.enums.ErrorCode;

public class DataSavingException extends DetailAddableException {

    public DataSavingException() {
        super(ErrorCode.INTERNAL_SERVER_ERROR);
    }
}

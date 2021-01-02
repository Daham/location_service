package com.adamant.locationservice.exception;

import com.adamant.locationservice.exception.enums.ErrorCode;

public class DataRemovalException extends DetailAddableException {

    public DataRemovalException() {
        super(ErrorCode.INTERNAL_SERVER_ERROR);
    }
}

package com.adamant.locationservice.exception;

import com.adamant.locationservice.exception.enums.ErrorCode;

public class ResourceNotFoundException extends DetailAddableException {

    public ResourceNotFoundException() {
        super(ErrorCode.RESOURCE_NOT_FOUND);
    }

}


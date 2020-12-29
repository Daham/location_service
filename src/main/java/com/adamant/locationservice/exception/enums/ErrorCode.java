package com.adamant.locationservice.exception.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Getter
@ToString
@RequiredArgsConstructor
public enum ErrorCode {

    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR.value(),
            "internal.server.error",
            "Internal server error occurred"),
    BAD_REQUEST(HttpStatus.BAD_REQUEST.value(),
            "bad.request",
            "Invalid request"),
    VALIDATION_ERROR(HttpStatus.BAD_REQUEST.value(),
            "validation.error",
            "Invalid data provided"),
    RESOURCE_NOT_FOUND(HttpStatus.NOT_FOUND.value(),
            "resource.not.found",
            "Requested resource not found"),
    UNPROCESSABLE_ENTITY(HttpStatus.UNPROCESSABLE_ENTITY.value(),
            "unprocessable.entity",
            "Failure due to unprocessable entity"),
    EXTERNAL_SERVICE_ERROR(HttpStatus.SERVICE_UNAVAILABLE.value(),
            "external.service.failure",
            "External service failure");

    private final int code;
    private final String name;
    private final String message;
}

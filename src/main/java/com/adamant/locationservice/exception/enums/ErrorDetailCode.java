package com.adamant.locationservice.exception.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import util.ErrorConstants;

@Getter
@ToString
@RequiredArgsConstructor
public enum ErrorDetailCode {

    USER_ID_INVALID(
            ErrorConstants.USER_ID_INVALID,
            "user_id",
            "path");

    private final String code;
    private final String field;
    private final String location;
}

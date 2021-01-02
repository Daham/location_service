package com.adamant.locationservice.exception.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import com.adamant.locationservice.util.ErrorConstants;

@Getter
@ToString
@RequiredArgsConstructor
public enum ErrorDetailCode {

    ERROR_SAVING_USER(
            ErrorConstants.ERROR_SAVING_USER,
            "",
            "body"),
    ERROR_UPDATING_USER(
            ErrorConstants.ERROR_UPDATING_USER,
            "",
            "body"),
    ERROR_REMOVING_USER(
            ErrorConstants.ERROR_REMOVING_USER,
            "id",
            "path"),
    USER_ALREADY_EXISTS(
            ErrorConstants.USER_ALREADY_EXISTS,
            "id",
            "body"),
    USER_NOT_FOUND(
            ErrorConstants.USER_NOT_FOUND,
            "id",
            "path"),
    GROUP_NOT_FOUND(
            ErrorConstants.GROUP_NOT_FOUND,
            "id",
                    "path"),
    ERROR_SAVING_GROUP(
            ErrorConstants.ERROR_SAVING_GROUP,
            "",
            "body"),
    GROUP_ALREADY_EXISTS(
            ErrorConstants.GROUP_ALREADY_EXISTS,
            "id",
            "body"),
    ERROR_UPDATING_GROUP(
            ErrorConstants.ERROR_UPDATING_GROUP,
            "",
            "body"),
    ERROR_REMOVING_GROUP(
            ErrorConstants.ERROR_REMOVING_GROUP,
            "id",
            "path"),
    ROLE_NOT_FOUND(
            ErrorConstants.ROLE_NOT_FOUND,
            "id",
            "path"),
    ERROR_SAVING_ROLE(
            ErrorConstants.ERROR_SAVING_ROLE,
            "",
            "body"),
    ROLE_ALREADY_EXISTS(
            ErrorConstants.ROLE_ALREADY_EXISTS,
            "id",
            "body"),
    ERROR_UPDATING_ROLE(
            ErrorConstants.ERROR_UPDATING_ROLE,
            "",
            "body"),
    ERROR_REMOVING_ROLE(
            ErrorConstants.ERROR_REMOVING_ROLE,
            "id",
            "path");

    private final String code;
    private final String field;
    private final String location;
}

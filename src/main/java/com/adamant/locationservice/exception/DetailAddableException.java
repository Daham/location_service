package com.adamant.locationservice.exception;

import com.adamant.locationservice.entity.error_data.ErrorData;
import com.adamant.locationservice.entity.error_data.ErrorDetail;
import com.adamant.locationservice.exception.enums.ErrorCode;
import com.adamant.locationservice.exception.enums.ErrorDetailCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public abstract class DetailAddableException extends RuntimeException {

    private final transient ErrorData errorData;

    public DetailAddableException(String message, ErrorCode errorCode) {
        super(message);
        this.errorData = ErrorData.from(errorCode);
    }

    public DetailAddableException(ErrorCode errorCode) {
        this.errorData = ErrorData.from(errorCode);
    }

    public DetailAddableException addDetail(String message, Object value, ErrorDetailCode errorDetailCode) {
        this.errorData.getDetails().add(ErrorDetail.builder()
                .code(errorDetailCode.getCode())
                .message(message)
                .value(value)
                .field(errorDetailCode.getField())
                .location(errorDetailCode.getLocation())
                .build());
        return this;
    }
}

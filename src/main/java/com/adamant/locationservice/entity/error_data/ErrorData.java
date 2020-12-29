package com.adamant.locationservice.entity.error_data;



import com.adamant.locationservice.exception.enums.ErrorCode;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class ErrorData {

    private String code;

    private String message;

    private List<ErrorDetail> details;

    private String link;

    public static ErrorData from(ErrorCode errorCode) {
        return ErrorData.builder()
                .code(errorCode.getName())
                .message(errorCode.getMessage())
                .details(new ArrayList<>())
                .build();
    }
}


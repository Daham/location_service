package com.adamant.locationservice.entity.error_data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetail {

    private String code;

    private String message;

    private Object value;

    private String field;

    private String location;

}
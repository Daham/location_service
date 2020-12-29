package com.adamant.locationservice.entity.error_data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BulkResponseErrorDetail extends ErrorDetail{

    @JsonProperty("information_link")
    private String informationLink;
}

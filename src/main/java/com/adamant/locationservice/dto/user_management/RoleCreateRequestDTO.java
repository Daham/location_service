package com.adamant.locationservice.dto.user_management;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleCreateRequestDTO {

    private String name;

    @JsonProperty("allowed_operations")
    private List<String> allowedOperations;

    @JsonProperty("created_by")
    private String createdBy;
}

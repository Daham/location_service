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
public class GroupsResponseDTO {

    @JsonProperty("is_has_previous")
    private boolean isHasPrevious;

    @JsonProperty("is_has_next")
    private boolean isHasNext;

    @JsonProperty("total")
    private long totalResults;

    @JsonProperty("page_number")
    private int pageNumber;

    @JsonProperty("next_param")
    private String nextParam;

    @JsonProperty("previous_param")
    private String previousParam;

    private List<GroupResponseDTO> items;
}

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
public class UserCreateRequestDTO {

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("email")
    private String email;

    @JsonProperty("password")
    private String password;

    @JsonProperty("avatar_url")
    private String avatarUrl;

    private boolean activated;

    @JsonProperty("assigned_groups")
    private List<String> assignedGroups;

    @JsonProperty("assigned_roles")
    private List<String> assignedRoles;

    @JsonProperty("created_by")
    private String createdBy;
}

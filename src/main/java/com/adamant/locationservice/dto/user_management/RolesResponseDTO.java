package com.adamant.locationservice.dto.user_management;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RolesResponseDTO {

    private int total;

    private List<RoleResponseDTO> items;
}

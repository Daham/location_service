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
public class UsersResponseDTO {

    private int total;

    private List<UsersResponseDTO> items;
}

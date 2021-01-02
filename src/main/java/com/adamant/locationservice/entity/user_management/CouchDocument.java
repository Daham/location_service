package com.adamant.locationservice.entity.user_management;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CouchDocument {

    private String _id;

    private String _rev;

    private String type;
}

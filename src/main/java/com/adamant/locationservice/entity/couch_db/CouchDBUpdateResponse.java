package com.adamant.locationservice.entity.couch_db;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CouchDBUpdateResponse {

    private String id;

    private String revision;

    private String error;

    private String reason;
}

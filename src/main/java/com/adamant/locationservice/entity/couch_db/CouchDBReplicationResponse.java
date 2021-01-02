package com.adamant.locationservice.entity.couch_db;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CouchDBReplicationResponse {

    private String localId;

    private String sessionId;

    private String sourceLastSequence;

    private boolean isOk;
}

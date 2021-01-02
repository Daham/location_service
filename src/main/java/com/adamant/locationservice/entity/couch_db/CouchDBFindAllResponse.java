package com.adamant.locationservice.entity.couch_db;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CouchDBFindAllResponse<T> {

    private boolean isHasPrevious;

    private boolean isHasNext;

    private List<T> resultList;

    private long totalResults;

    private int pageNumber;

    private String nextParam;

    private String previousParam;
}

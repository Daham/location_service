package com.adamant.locationservice.repository;

import com.adamant.locationservice.entity.couch_db.CouchDBFindAllResponse;
import com.adamant.locationservice.entity.couch_db.CouchDBReplicationResponse;
import com.adamant.locationservice.entity.couch_db.CouchDBSaveResponse;
import com.adamant.locationservice.entity.couch_db.CouchDBUpdateResponse;

public interface CouchDBRepository {

    <T> CouchDBSaveResponse save(T t);

    <T> CouchDBUpdateResponse update(T t);

    <T> T find(Class<T> classType, String id);

    <T> CouchDBFindAllResponse<T> findAll(Class<T> classType, String key, int rowsPerPage, String param);

    CouchDBSaveResponse remove(String id, String rev);

    CouchDBReplicationResponse replicate(String source, String target);
}

package com.adamant.locationservice.repository;

import com.adamant.locationservice.entity.couch_db.CouchDBFindAllResponse;
import com.adamant.locationservice.entity.couch_db.CouchDBReplicationResponse;
import com.adamant.locationservice.entity.couch_db.CouchDBSaveResponse;
import com.adamant.locationservice.entity.couch_db.CouchDBUpdateResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.lightcouch.*;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.adamant.locationservice.util.CouchDocumentConstants.*;

@Repository
@Slf4j
@RequiredArgsConstructor
public class CouchDBRepository {

    private final CouchDbClient couchDbClient;

    /**
     * Save given object in the database.
     *
     * @param t   - Object to save
     * @param <T> - Type of the object to save
     * @return An object of type CouchDBSaveResponse
     */
    public <T> CouchDBSaveResponse save(T t) {

        Response response = couchDbClient.save(t);

        return CouchDBSaveResponse.builder()
                .id(response.getId())
                .revision(response.getRev())
                .error(response.getError())
                .reason(response.getReason())
                .build();
    }

    /**
     * Update given object in the database.
     *
     * @param t   - Object to update
     * @param <T> - Type of the object to update
     * @return An object of type CouchDBUpdateResponse
     */
    public <T> CouchDBUpdateResponse update(T t) {

        Response response = couchDbClient.update(t);

        return CouchDBUpdateResponse.builder()
                .id(response.getId())
                .revision(response.getRev())
                .error(response.getError())
                .reason(response.getReason())
                .build();
    }

    /**
     * Find an object with given class type with the document id.
     *
     * @param classType - The class of type T.
     * @param id        - Document id
     * @param <T>       - Object type
     * @return An object of type T.
     */
    public <T> T find(Class<T> classType, String id) {
        try {
            return couchDbClient.find(classType, id);
        } catch (NoDocumentException e) {
            log.error("No document found for the id: {}", id);
            return null;
        }
    }

    /**
     * Find all objects with given class type.
     *
     * @param classType- The class of type T.
     * @param <T>        - Object type
     * @return An object of type CouchDBFindAllResponse
     */
    public <T> CouchDBFindAllResponse<T> findAll(Class<T> classType, String key, int rowsPerPage, String param) {

        Page<T> page;

        try {
            page = couchDbClient.view(FIND_BY_TYPE_VIEW_ID)
                    .key(key)
                    .queryPage(rowsPerPage, param, classType);
        } catch (IndexOutOfBoundsException e) {
            return CouchDBFindAllResponse.<T>builder()
                    .resultList(List.of())
                    .build();
        }

        return CouchDBFindAllResponse.<T>builder()
                .isHasNext(page.isHasNext())
                .isHasPrevious(page.isHasPrevious())
                .resultList(page.getResultList())
                .nextParam(page.getNextParam())
                .previousParam(page.getPreviousParam())
                .totalResults(page.getTotalResults())
                .pageNumber(page.getPageNumber())
                .build();
    }

    /**
     * Remove a given object from the database.
     *
     * @param id  - id
     * @param rev - revision
     * @return An object of type CouchDBSaveResponse
     */
    public CouchDBSaveResponse remove(String id, String rev) {
        Response response = couchDbClient.remove(id, rev);

        return CouchDBSaveResponse.builder()
                .id(response.getId())
                .revision(response.getRev())
                .error(response.getError())
                .reason(response.getReason())
                .build();
    }

    /**
     * Trigger a replication between source database and a target.
     *
     * @param source - Source database
     * @param target - Target database
     * @return An object of type CouchDBReplicationResponse
     */
    public CouchDBReplicationResponse replicate(String source, String target) {
        ReplicationResult result = couchDbClient.replication()
                .source(source).target(target)
                .createTarget(true)
                .trigger();

        return CouchDBReplicationResponse.builder()
                .isOk(result.isOk())
                .localId(result.getLocalId())
                .sessionId(result.getSessionId())
                .sourceLastSequence(result.getSourceLastSeq())
                .build();

    }


}

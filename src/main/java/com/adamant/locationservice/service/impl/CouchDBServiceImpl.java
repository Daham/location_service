package com.adamant.locationservice.service.impl;

import com.adamant.locationservice.entity.couch_db.CouchDBFindAllResponse;
import com.adamant.locationservice.entity.couch_db.CouchDBReplicationResponse;
import com.adamant.locationservice.entity.couch_db.CouchDBSaveResponse;
import com.adamant.locationservice.entity.couch_db.CouchDBUpdateResponse;
import com.adamant.locationservice.entity.user_management.CouchDocument;
import com.adamant.locationservice.repository.CouchDBRepository;
import com.adamant.locationservice.service.CouchDBService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Locale;

@Service
@Slf4j
@RequiredArgsConstructor
public class CouchDBServiceImpl implements CouchDBService {

    private final CouchDBRepository couchDBRepository;

    /**
     * Save object in the database.
     *
     * @param t   - Object to save
     * @param <T> - Type of the object to save.
     * @return Is the save success
     */
    @Override
    public <T extends CouchDocument> boolean save(T t) {
        t.setType(t.getClass().getSimpleName().toLowerCase(Locale.ENGLISH));
        CouchDBSaveResponse response = couchDBRepository.save(t);

        if (ObjectUtils.isEmpty(response.getError()) && !ObjectUtils.isEmpty(response.getId())) {
            return true;
        }
        log.error("Error occurred in saving the object: {} error: {} reason: {}", t.toString(), response.getError(), response.getReason());
        return false;
    }

    /**
     * Update object in the database.
     *
     * @param t   - Object to update
     * @param <T> - Type of the object to update.
     * @return Is the update success
     */
    @Override
    public <T> boolean update(T t) {
        CouchDBUpdateResponse response = couchDBRepository.update(t);

        if (ObjectUtils.isEmpty(response.getError()) && !ObjectUtils.isEmpty(response.getId())) {
            return true;
        }
        log.error("Error occurred in updating the object: {} error: {} reason: {}", t.toString(), response.getError(), response.getReason());
        return false;
    }

    /**
     * Find an object with given class type with the document id.
     *
     * @param classType - The class of type T
     * @param id        - Document id
     * @param <T>       - Object type
     * @return An object of type T.
     */
    @Override
    public <T> T find(Class<T> classType, String id) {
        return couchDBRepository.find(classType, id);
    }

    /**
     * @param classType   - The class of type T
     * @param rowsPerPage - rows per page
     * @param param       - param to search page
     * @param <T>         - Object type
     * @return An object of type CouchDBFindAllResponse
     */
    @Override
    public <T> CouchDBFindAllResponse<T> findAll(Class<T> classType, int rowsPerPage, String param) {
        return couchDBRepository.findAll(classType, classType.getSimpleName().toLowerCase(Locale.ENGLISH), rowsPerPage, param);
    }

    /**
     * Remove a given object from the database.
     *
     * @param id  - id
     * @param rev - revision
     * @return Is the removal success
     */
    @Override
    public boolean remove(String id, String rev) {
        CouchDBSaveResponse response = couchDBRepository.remove(id, rev);

        if (ObjectUtils.isEmpty(response.getError()) && !ObjectUtils.isEmpty(response.getId())) {
            return true;
        }
        log.error("Error occurred in removing the object with id: {} and rev: {} error: {} reason: {}", id, rev, response.getError(), response.getReason());
        return false;
    }

    /**
     * Trigger a replication between source database and a target.
     *
     * @param source - Source database
     * @param target - Target database
     * @return Is the replication success
     */
    @Override
    public boolean replicate(String source, String target) {

        CouchDBReplicationResponse response = couchDBRepository.replicate(source, target);

        if (response.isOk()) {
            return true;
        }
        log.error("Error occurred in replicating with target: {}", target);
        return false;

    }
}

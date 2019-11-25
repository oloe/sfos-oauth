package com.sfos.oauth.service;

import com.sfos.oauth.base.AlreadyExistsException;
import com.sfos.oauth.base.EntityNotFoundException;
import com.sfos.oauth.base.JsonObjects;
import com.sfos.oauth.base.NotImplementException;

public interface CommonServiceInterface<T> {


    default JsonObjects<T> list(int pageNum,
                                int pageSize,
                                String sortField,
                                String sortOrder) {
        throw new NotImplementException();
    }

    default T create(T t) throws AlreadyExistsException {
        throw new NotImplementException();
    }

    default T retrieveById(long id) throws EntityNotFoundException {
        throw new NotImplementException();
    }

    default T updateById(T t) throws EntityNotFoundException {
        throw new NotImplementException();
    }

    default void deleteById(long id) {
        throw new NotImplementException();
    }

    default void updateRecordStatus(long id, int recordStatus) {
        throw new NotImplementException();
    }
}

package com.sfos.oauth.service;

import com.sfos.oauth.base.EntityNotFoundException;
import com.sfos.oauth.base.JsonObjects;
import com.sfos.oauth.base.UserAccount;
import com.sfos.oauth.model.EbpOprinfo;

public interface UserAccountService extends CommonServiceInterface<UserAccount> {
    JsonObjects<UserAccount> listByUsername(String username,
                                            int pageNum,
                                            int pageSize,
                                            String sortField,
                                            String sortOrder);

    EbpOprinfo findByUsername(String username) throws EntityNotFoundException;

    boolean existsByUsername(String username);

    void loginSuccess(String username) throws EntityNotFoundException;

    void loginFailure(String username);
}

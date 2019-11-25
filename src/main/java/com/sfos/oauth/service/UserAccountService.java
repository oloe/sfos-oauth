package com.sfos.oauth.service;

import com.sfos.oauth.base.EntityNotFoundException;
import com.sfos.oauth.base.UserAccount;

public interface UserAccountService extends CommonServiceInterface<UserAccount> {
//    JsonObjects<UserAccount> listByUsername(String username,
//                                            int pageNum,
//                                            int pageSize,
//                                            String sortField,
//                                            String sortOrder);

    UserAccount findByUsername(String username) throws EntityNotFoundException;

    boolean existsByUsername(String username);

    void loginSuccess(String username) throws EntityNotFoundException;

    void loginFailure(String username);
}

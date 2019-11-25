package com.sfos.oauth.service;

import com.sfos.oauth.base.JsonObjects;
import com.sfos.oauth.base.LoginHistory;

public interface LoginHistoryService extends CommonServiceInterface<LoginHistory> {
    JsonObjects<LoginHistory> listByUsername(String username, int pageNum,
                                             int pageSize,
                                             String sortField,
                                             String sortOrder);
    
    void asyncCreate(LoginHistory loginHistory);

}

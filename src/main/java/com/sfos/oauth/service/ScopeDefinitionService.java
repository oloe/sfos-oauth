package com.sfos.oauth.service;

import com.sfos.oauth.base.NotImplementException;
import com.sfos.oauth.base.ScopeDefinition;

public interface ScopeDefinitionService extends CommonServiceInterface<ScopeDefinition> {
    default ScopeDefinition findByScope(String scope) throws NotImplementException {
        throw new NotImplementException();
    }
}

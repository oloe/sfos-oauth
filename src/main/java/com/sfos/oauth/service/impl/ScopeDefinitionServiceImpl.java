package com.sfos.oauth.service.impl;

import com.github.dozermapper.core.Mapper;
import com.sfos.oauth.base.NotImplementException;
import com.sfos.oauth.base.ScopeDefinition;
import com.sfos.oauth.mapper.ScopeDefinitionEntityMapper;
import com.sfos.oauth.service.ScopeDefinitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScopeDefinitionServiceImpl implements ScopeDefinitionService {

    @Autowired
    ScopeDefinitionEntityMapper scopeDefinitionEntityMapper;

    @Autowired
    Mapper dozerMapper;

    @Override
    public ScopeDefinition findByScope(String scope) throws NotImplementException {
        ScopeDefinitionEntity scopeDefinitionEntity = scopeDefinitionEntityMapper.selectByScope(scope);
        if (scopeDefinitionEntity != null) {
            return dozerMapper.map(scopeDefinitionEntity, ScopeDefinition.class);
        } else {
            return null;
        }
    }

}

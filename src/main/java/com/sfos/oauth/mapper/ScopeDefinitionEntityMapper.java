package com.sfos.oauth.mapper;

import com.sfos.oauth.model.ScopeDefinitionEntity;

public interface ScopeDefinitionEntityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ScopeDefinitionEntity record);

    int insertSelective(ScopeDefinitionEntity record);

    ScopeDefinitionEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ScopeDefinitionEntity record);

    int updateByPrimaryKey(ScopeDefinitionEntity record);
}
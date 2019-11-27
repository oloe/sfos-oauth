package com.sfos.oauth.mapper;

import com.sfos.oauth.model.ScopeDefinitionEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface ScopeDefinitionEntityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ScopeDefinitionEntity record);

    int insertSelective(ScopeDefinitionEntity record);

    ScopeDefinitionEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ScopeDefinitionEntity record);

    int updateByPrimaryKey(ScopeDefinitionEntity record);

    ScopeDefinitionEntity selectByScope(String scope);
}
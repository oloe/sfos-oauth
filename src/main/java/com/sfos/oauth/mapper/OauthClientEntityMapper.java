package com.sfos.oauth.mapper;

import com.sfos.oauth.model.OauthClientEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface OauthClientEntityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OauthClientEntity record);

    int insertSelective(OauthClientEntity record);

    OauthClientEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OauthClientEntity record);

    int updateByPrimaryKey(OauthClientEntity record);

    OauthClientEntity selectByClientId(String clientId);
}
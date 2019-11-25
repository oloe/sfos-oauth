package com.sfos.oauth.service;

import com.sfos.oauth.base.NotImplementException;
import com.sfos.oauth.base.OauthClient;

public interface OauthClientService extends CommonServiceInterface<OauthClient> {
    default OauthClient findByClientId(String clientId){
        throw new NotImplementException();
    }
}

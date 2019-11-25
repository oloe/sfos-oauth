package com.sfos.oauth.service;

import com.sfos.oauth.base.NotImplementException;
import com.sfos.oauth.base.Role;

public interface RoleService extends CommonServiceInterface<Role> {
    default Role findByRoleName(String roleName) throws NotImplementException {
        throw new NotImplementException();
    }
}

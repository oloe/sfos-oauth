package com.sfos.oauth.service.impl;

import com.github.dozermapper.core.Mapper;
import com.sfos.oauth.base.NotImplementException;
import com.sfos.oauth.base.Role;
import com.sfos.oauth.mapper.RoleEntityMapper;
import com.sfos.oauth.model.RoleEntity;
import com.sfos.oauth.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleEntityMapper roleEntityMapper;

    @Autowired
    Mapper dozerMapper;

    @Override
    public Role findByRoleName(String roleName) throws NotImplementException {
        RoleEntity roleEntity = roleEntityMapper.selectByRoleName(roleName);
        if (roleEntity != null) {
            return dozerMapper.map(roleEntity, Role.class);
        } else {
            return null;
        }
    }

}

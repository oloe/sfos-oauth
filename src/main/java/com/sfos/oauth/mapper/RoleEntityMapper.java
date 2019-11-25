package com.sfos.oauth.mapper;

import com.sfos.oauth.model.RoleEntity;

public interface RoleEntityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RoleEntity record);

    int insertSelective(RoleEntity record);

    RoleEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RoleEntity record);

    int updateByPrimaryKey(RoleEntity record);

    RoleEntity selectByRoleName(String roleName);
}
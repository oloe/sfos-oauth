package com.sfos.oauth.mapper;

import com.sfos.oauth.model.UserAccountEntityRoles;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccountEntityRolesMapper {
    int insert(UserAccountEntityRoles record);

    int insertSelective(UserAccountEntityRoles record);
}
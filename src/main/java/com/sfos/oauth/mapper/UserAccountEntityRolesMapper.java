package com.sfos.oauth.mapper;

import com.sfos.oauth.model.UserAccountEntityRoles;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserAccountEntityRolesMapper {
    int insert(UserAccountEntityRoles record);

    int insertSelective(UserAccountEntityRoles record);
}
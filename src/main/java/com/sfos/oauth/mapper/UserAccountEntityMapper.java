package com.sfos.oauth.mapper;

import com.sfos.oauth.model.UserAccountEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserAccountEntityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserAccountEntity record);

    int insertSelective(UserAccountEntity record);

    UserAccountEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserAccountEntity record);

    int updateByPrimaryKey(UserAccountEntity record);

    UserAccountEntity selectByUsername(String username);

    boolean checkByUsername(String username);
}
package com.sfos.oauth.mapper;

import com.sfos.oauth.model.LoginHistoryEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginHistoryEntityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(LoginHistoryEntity record);

    int insertSelective(LoginHistoryEntity record);

    LoginHistoryEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LoginHistoryEntity record);

    int updateByPrimaryKey(LoginHistoryEntity record);

    LoginHistoryEntity selectByUserName(String username);
}
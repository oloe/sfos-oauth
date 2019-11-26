package com.sfos.oauth.mapper;

import com.sfos.oauth.model.EbpOprinfo;
import com.sfos.oauth.model.EbpOprinfoKey;

public interface EbpOprinfoMapper {
    int deleteByPrimaryKey(EbpOprinfoKey key);

    int insert(EbpOprinfo record);

    int insertSelective(EbpOprinfo record);

    EbpOprinfo selectByPrimaryKey(EbpOprinfoKey key);

    EbpOprinfo selectByUsername(String name);

    boolean checkByUsername(String username);

    int updateByPrimaryKeySelective(EbpOprinfo record);

    int updateByPrimaryKey(EbpOprinfo record);

}
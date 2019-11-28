package com.sfos.oauth.mapper;

import com.sfos.oauth.model.EbpOprinfo;
import com.sfos.oauth.model.EbpOprinfoKey;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EbpOprinfoMapper {
    int deleteByPrimaryKey(EbpOprinfoKey key);

    int insert(EbpOprinfo record);

    int insertSelective(EbpOprinfo record);

    EbpOprinfo selectByPrimaryKey(EbpOprinfoKey key);

    EbpOprinfo selectByUsername(String name);

    boolean checkByUsername(String username);

    int updateByPrimaryKeySelective(EbpOprinfo record);

    Page<EbpOprinfo> findByUsernameLike(String username, Pageable page);

    int updateByPrimaryKey(EbpOprinfo record);

    Page<EbpOprinfo> findAll(Pageable pageable);
}
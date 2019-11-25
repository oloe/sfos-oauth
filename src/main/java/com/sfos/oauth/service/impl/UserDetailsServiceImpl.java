package com.sfos.oauth.service.impl;

import com.sfos.oauth.base.UserInfo;
import com.sfos.oauth.mapper.UserAccountEntityMapper;
import com.sfos.oauth.model.UserAccountEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserAccountEntityMapper userAccountEntityMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAccountEntity userAccountEntity = userAccountEntityMapper.selectByUsername(username);
        // todo 获取规则
        if (userAccountEntity != null) {
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
//            if (userAccountEntity.getRoles() != null && userAccountEntity.getRoles().size() > 0) {
//                for (RoleEntity temp : userAccountEntity.getRoles()) {
//                    GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(temp.getRoleName());
//                    grantedAuthorities.add(grantedAuthority);
//                }
//            }
            return new UserInfo(userAccountEntity.getAccountOpenCode(), userAccountEntity.getUsername(), userAccountEntity.getPassword(),
                userAccountEntity.getRecordStatus() >= 0, true, true, userAccountEntity.getRecordStatus() != -2, grantedAuthorities);
        } else {
            throw new UsernameNotFoundException(username + " not found!");
        }
    }
}

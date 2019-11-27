package com.sfos.oauth.service.impl;

import com.sfos.oauth.base.UserInfo;
import com.sfos.oauth.model.EbpOprinfo;
import com.sfos.oauth.model.UserAccountEntity;
import org.springframework.beans.factory.annotation.Autowired;
import com.sfos.oauth.mapper.EbpOprinfoMapper;
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
    EbpOprinfoMapper ebpOprinfoMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        EbpOprinfo ebpOprinfo = ebpOprinfoMapper.selectByUsername(username);
        // todo 获取规则
        if (ebpOprinfoMapper != null) {
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
//            if (userAccountEntity.getRoles() != null && userAccountEntity.getRoles().size() > 0) {
//                for (RoleEntity temp : userAccountEntity.getRoles()) {
//                    GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(temp.getRoleName());
//                    grantedAuthorities.add(grantedAuthority);
//                }
//            }
            return new UserInfo(ebpOprinfo.getEoiOprrole(), ebpOprinfo.getEoiAlias(), ebpOprinfo.getEoiPassword(), grantedAuthorities);
        } else {
            throw new UsernameNotFoundException(username + " not found!");
        }
    }
}

package com.sfos.oauth.service.impl;

import com.github.dozermapper.core.Mapper;
import com.sfos.oauth.base.EntityNotFoundException;
import com.sfos.oauth.base.JsonObjects;
import com.sfos.oauth.base.UserAccount;
import com.sfos.oauth.mapper.EbpOprinfoMapper;
import com.sfos.oauth.mapper.RoleEntityMapper;
import com.sfos.oauth.model.EbpOprinfo;
import com.sfos.oauth.service.UserAccountService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserAccountServiceImpl implements UserAccountService {


    @Autowired
    EbpOprinfoMapper EbpOprinfoMapper;

    @Autowired
    RoleEntityMapper roleEntityMapper;

    @Autowired
    Mapper dozerMapper;

    @Value("${signin.failure.max:5}")
    private int failureMax;

    @Override
    public JsonObjects<UserAccount> listByUsername(String username, int pageNum, int pageSize, String sortField, String sortOrder) {
        JsonObjects<UserAccount> jsonObjects = new JsonObjects<>();
        Sort sort;
        if (StringUtils.equalsIgnoreCase(sortOrder, "asc")) {
            sort = Sort.by(Sort.Direction.ASC, sortField);
        } else {
            sort = Sort.by(Sort.Direction.DESC, sortField);
        }
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize, sort);
        Page<EbpOprinfo> page;
        if (StringUtils.isBlank(username)) {
            page = EbpOprinfoMapper.findAll(pageable);
        } else {
            page = EbpOprinfoMapper.findByUsernameLike(username + "%", pageable);
        }
        if (page.getContent() != null && page.getContent().size() > 0) {
            jsonObjects.setRecordsTotal(page.getTotalElements());
            jsonObjects.setRecordsFiltered(page.getTotalElements());
            page.getContent().forEach(u -> jsonObjects.getData().add(dozerMapper.map(u, UserAccount.class)));
        }
        return jsonObjects;

    }

//    @Override
//    @Transactional(rollbackFor = Exception.class)
//    public EbpOprinfo create(UserAccount userAccount) throws AlreadyExistsException {
//        UserAccountEntity exist = userAccountEntityMapper.selectByUsername(userAccount.getUsername());
//        if (exist != null) {
//            throw new AlreadyExistsException(userAccount.getUsername() + " already exists!");
//        }
//        UserAccountEntity userAccountEntity = dozerMapper.map(userAccount, UserAccountEntity.class);
//        userAccountEntity.getRoles().clear();
//        if (userAccount.getRoles() != null && userAccount.getRoles().size() > 0) {
//            userAccount.getRoles().forEach(e -> {
//                RoleEntity roleEntity = roleRepository.findByRoleName(e.getRoleName());
//                if (roleEntity != null) {
//                    userAccountEntity.getRoles().add(roleEntity);
//                }
//            });
//        }
//        userAccountEntityMapper.save(userAccountEntity);
//        return dozerMapper.map(userAccountEntity, UserAccount.class);
//    }

//    @Override
//    public EbpOprinfo retrieveById(long id) throws EntityNotFoundException {
//        Optional<UserAccountEntity> entityOptional = userAccountEntityMapper.selectByPrimaryKey(id);
//        return dozerMapper.map(entityOptional.orElseThrow(EntityNotFoundException::new), UserAccount.class);
//    }

//    @Override
//    @Transactional(rollbackFor = Exception.class)
//    public EbpOprinfo updateById(UserAccount userAccount) throws EntityNotFoundException {
//        Optional<UserAccountEntity> entityOptional = userAccountEntityMapper.selectByPrimaryKey(Long.parseLong(userAccount.getId()));
//        UserAccountEntity e = entityOptional.orElseThrow(EntityNotFoundException::new);
//        if (StringUtils.isNotEmpty(userAccount.getPassword())) {
//            e.setPassword(userAccount.getPassword());
//        }
//        e.setNickName(userAccount.getNickName());
//        e.setBirthday(userAccount.getBirthday());
//        e.setMobile(userAccount.getMobile());
//        e.setProvince(userAccount.getProvince());
//        e.setCity(userAccount.getCity());
//        e.setAddress(userAccount.getAddress());
//        e.setAvatarUrl(userAccount.getAvatarUrl());
//        e.setEmail(userAccount.getEmail());
//
//        userAccountEntityMapper.insert(e);
//        return dozerMapper.map(e, UserAccount.class);
//    }

//    @Override
//    @Transactional(rollbackFor = Exception.class)
//    public void updateRecordStatus(long id, int recordStatus) {
//        Optional<UserAccountEntity> entityOptional = userAccountEntityMapper.selectByPrimaryKey(id);
//        UserAccountEntity e = entityOptional.orElseThrow(EntityNotFoundException::new);
//        e.setRecordStatus(recordStatus);
//        userAccountEntityMapper.insert(e);
//    }

    @Override
    public EbpOprinfo findByUsername(String username) throws EntityNotFoundException {
        EbpOprinfo ebpOprinfo = EbpOprinfoMapper.selectByUsername(username);
        if (ebpOprinfo != null) {
            return dozerMapper.map(ebpOprinfo, EbpOprinfo.class);
        } else {
            throw new EntityNotFoundException(username + " not found!");
        }
    }

    @Override
    public boolean existsByUsername(String username) {
        return EbpOprinfoMapper.checkByUsername(username);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @Async
    public void loginSuccess(String username) throws EntityNotFoundException {
        EbpOprinfo ebpOprinfo = EbpOprinfoMapper.selectByUsername(username);
        if (ebpOprinfo != null) {
//            ebpOprinfo.setFailureCount(0);
//            ebpOprinfo.setFailureTime(null);
//            EbpOprinfoMapper.insert(ebpOprinfo);
        } else {
            throw new EntityNotFoundException(username + " not found!");
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void loginFailure(String username) {
        EbpOprinfo userAccount = EbpOprinfoMapper.selectByUsername(username);
        if (userAccount != null) {
//            if (ebpOprinfo.getFailureTime() == null) {
//                ebpOprinfo.setFailureCount(1);
//            } else {
//                if (DateUtil.beforeToday(ebpOprinfo.getFailureTime())) {
//                    ebpOprinfo.setFailureCount(0);
//                } else {
//                    ebpOprinfo.setFailureCount(ebpOprinfo.getFailureCount() + 1);
//                }
//            }
//            ebpOprinfo.setFailureTime(LocalDateTime.now());
//            if (ebpOprinfo.getFailureCount() >= failureMax && ebpOprinfo.getRecordStatus() >= 0) {
//                ebpOprinfo.setRecordStatus(-1);
//            }
            EbpOprinfoMapper.insert(userAccount);
        }
    }
}

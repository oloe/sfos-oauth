package com.sfos.oauth.service.impl;

import com.github.dozermapper.core.Mapper;
import com.sfos.oauth.base.AlreadyExistsException;
import com.sfos.oauth.base.LoginHistory;
import com.sfos.oauth.mapper.LoginHistoryEntityMapper;
import com.sfos.oauth.model.LoginHistoryEntity;
import com.sfos.oauth.service.LoginHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LoginHistoryServiceImpl implements LoginHistoryService {
    @Autowired
    LoginHistoryEntityMapper loginHistoryEntityMapper;

    @Autowired
    Mapper dozerMapper;

//    @Override
//    public JsonObjects<LoginHistory> listByUsername(String username, int pageNum, int pageSize, String sortField, String sortOrder) {
//        JsonObjects<LoginHistory> jsonObjects = new JsonObjects<>();
//        Sort sort;
//        if (StringUtils.equalsIgnoreCase(sortOrder, "asc")) {
//            sort = Sort.by(Sort.Direction.ASC, sortField);
//        } else {
//            sort = Sort.by(Sort.Direction.DESC, sortField);
//        }
//        Pageable pageable = PageRequest.of(pageNum - 1, pageSize, sort);
//        Page<LoginHistoryEntity> page = loginHistoryEntityMapper.selectByUserName(username, pageable);
//        if (page.getContent() != null && page.getContent().size() > 0) {
//            jsonObjects.setRecordsTotal(page.getTotalElements());
//            jsonObjects.setRecordsFiltered(page.getTotalElements());
//            page.getContent().forEach(u -> jsonObjects.getData().add(dozerMapper.map(u, LoginHistory.class)));
//        }
//        return jsonObjects;
//    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @Async
    public void asyncCreate(LoginHistory loginHistory) throws AlreadyExistsException {
        LoginHistoryEntity entity = dozerMapper.map(loginHistory, LoginHistoryEntity.class);
        loginHistoryEntityMapper.insert(entity);
    }
}

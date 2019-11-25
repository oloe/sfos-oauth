package com.sfos.oauth.service.impl;

import com.github.dozermapper.core.Mapper;
import com.sfos.oauth.base.AlreadyExistsException;
import com.sfos.oauth.base.OauthClient;
import com.sfos.oauth.mapper.OauthClientEntityMapper;
import com.sfos.oauth.model.OauthClientEntity;
import com.sfos.oauth.service.OauthClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OauthClientServiceImpl implements OauthClientService {

    @Autowired
    OauthClientEntityMapper oauthClientEntityMapper;

    @Autowired
    Mapper dozerMapper;

    @Override
    public OauthClient findByClientId(String clientId) {
        OauthClientEntity oauthClientEntity = oauthClientEntityMapper.selectByClientId(clientId);
        if (oauthClientEntity != null) {
            return dozerMapper.map(oauthClientEntity, OauthClient.class);
        } else {
            return null;
        }
    }

//    @Override
//    public JsonObjects<OauthClient> list(int pageNum, int pageSize, String sortField, String sortOrder) {
//        JsonObjects<OauthClient> jsonObjects = new JsonObjects<>();
//        Sort sort;
//        if (StringUtils.equalsIgnoreCase(sortOrder, "asc")) {
//            sort = Sort.by(Sort.Direction.ASC, sortField);
//        } else {
//            sort = Sort.by(Sort.Direction.DESC, sortField);
//        }
//        Pageable pageable = PageRequest.of(pageNum - 1, pageSize, sort);
//        Page<OauthClientEntity> page = oauthClientEntityMapper.findAll(pageable);
//        if (page.getContent() != null && page.getContent().size() > 0) {
//            jsonObjects.setRecordsTotal(page.getTotalElements());
//            jsonObjects.setRecordsFiltered(page.getTotalElements());
//            page.getContent().forEach(u -> jsonObjects.getData().add(dozerMapper.map(u, OauthClient.class)));
//        }
//        return jsonObjects;
//    }

    @Override
    public OauthClient create(OauthClient oauthClient) throws AlreadyExistsException {
        OauthClientEntity exist = oauthClientEntityMapper.selectByClientId(oauthClient.getClientId());
        if (exist != null) {
            throw new AlreadyExistsException(oauthClient.getClientId() + " already exists!");
        }
        OauthClientEntity oauthClientEntity = dozerMapper.map(oauthClient, OauthClientEntity.class);
        oauthClientEntityMapper.insert(oauthClientEntity);
        return dozerMapper.map(oauthClientEntity, OauthClient.class);
    }

//    @Override
//    public OauthClient retrieveById(long id) throws EntityNotFoundException {
//        Optional<OauthClientEntity> entityOptional = oauthClientEntityMapper.selectByPrimaryKey(id);
//        return dozerMapper.map(entityOptional.orElseThrow(EntityNotFoundException::new), OauthClient.class);
//    }

//    @Override
//    public OauthClient updateById(OauthClient oauthClient) throws EntityNotFoundException {
//        Optional<OauthClientEntity> entityOptional = oauthClientEntityMapper.selectByPrimaryKey(Long.parseLong(oauthClient.getId()));
//        OauthClientEntity e = entityOptional.orElseThrow(EntityNotFoundException::new);
//        if (StringUtils.isNotEmpty(oauthClient.getClientSecret())) {
//            e.setClientSecret(oauthClient.getClientSecret());
//        }
//        e.setAuthorities(oauthClient.getAuthorities());
//        e.setScope(oauthClient.getScope());
//        e.setAuthorizedGrantTypes(oauthClient.getAuthorizedGrantTypes());
//        e.setWebServerRedirectUri(oauthClient.getWebServerRedirectUri());
//
//        if (StringUtils.isNotEmpty(oauthClient.getRemarks())) {
//            e.setRemarks(oauthClient.getRemarks());
//        }
//
//        oauthClientEntityMapper.updateByPrimaryKey(e);
//        return dozerMapper.map(e, OauthClient.class);
//    }

//    @Override
//    @Transactional(rollbackFor = Exception.class)
//    public void updateRecordStatus(long id, int recordStatus) {
//        Optional<OauthClientEntity> entityOptional = oauthClientEntityMapper.selectByPrimaryKey(id);
//        OauthClientEntity e = entityOptional.orElseThrow(EntityNotFoundException::new);
//        e.setRecordStatus(recordStatus);
//        oauthClientRepository.save(e);
//    }
}

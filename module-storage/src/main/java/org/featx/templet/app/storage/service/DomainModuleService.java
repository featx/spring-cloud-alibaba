package org.featx.templet.app.storage.service;

import org.featx.spec.model.QuerySection;
import org.featx.templet.app.model.DomainModulePageQueryRequest;
import org.featx.templet.app.storage.entity.DomainModuleEntity;

import java.util.List;

/**
 * @author Excepts
 * @since 2020/4/12 13:57
 */
public interface DomainModuleService {

    void save(DomainModuleEntity domainModuleEntity);

    void update(DomainModuleEntity domainModuleEntity);

    void delete(String code);

    DomainModuleEntity findOne(String code);

    List<DomainModuleEntity> listByCodes(List<String> codes);

    QuerySection<DomainModuleEntity> page(DomainModulePageQueryRequest domainPageQueryRequest);
}

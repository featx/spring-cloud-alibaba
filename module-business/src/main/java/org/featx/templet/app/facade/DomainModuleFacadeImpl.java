package org.featx.templet.app.facade;

import org.featx.spec.model.Coded;
import org.featx.spec.model.QuerySection;
import org.featx.spec.util.CollectionUtil;
import org.featx.templet.app.model.DomainModuleInfo;
import org.featx.templet.app.model.DomainModuleItem;
import org.featx.templet.app.model.DomainModulePageQueryRequest;
import org.featx.templet.app.model.DomainModuleSaveRequest;
import org.featx.templet.app.storage.entity.DomainModuleEntity;
import org.featx.templet.app.storage.service.DomainModuleService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Excepts
 * @since 2020/4/13 0:09
 */
@Component
public class DomainModuleFacadeImpl implements DomainModuleFacade {

    @Resource
    private DomainModuleService domainModuleService;

    @Override
    public Coded save(DomainModuleSaveRequest saveRequest) {
        final DomainModuleEntity domainModuleEntity = toDomainModuleEntity(saveRequest);
        domainModuleService.save(domainModuleEntity);
        return domainModuleEntity::getCode;
    }

    DomainModuleEntity toDomainModuleEntity(DomainModuleSaveRequest domainModuleSaveRequest) {
        DomainModuleEntity domainModuleEntity = new DomainModuleEntity();
        domainModuleEntity.setCode(domainModuleSaveRequest.getCode());
        domainModuleEntity.setName(domainModuleSaveRequest.getName());
        domainModuleEntity.setType(domainModuleSaveRequest.getType());
        return domainModuleEntity;
    }

    @Override
    public Coded update(DomainModuleSaveRequest saveRequest) {
        final DomainModuleEntity domainModuleEntity = toDomainModuleEntity(saveRequest);
        domainModuleService.update(domainModuleEntity);
        return domainModuleEntity::getCode;
    }

    @Override
    public void delete(String domainCode) {
        domainModuleService.delete(domainCode);
    }

    @Override
    public DomainModuleInfo getByCode(String code) {
        return Optional.of(domainModuleService.findOne(code))
                .map(this::toDomainModuleInfo)
                .orElse(null);
    }

    DomainModuleInfo toDomainModuleInfo(DomainModuleEntity entity) {
        DomainModuleInfo info = new DomainModuleInfo();
        info.setCode(entity.getCode());
        info.setName(entity.getName());
        info.setType(entity.getType());
        return info;
    }

    @Override
    public List<DomainModuleInfo> listByCodes(List<String> codes) {
        return Optional.of(domainModuleService.listByCodes(codes))
                .filter(CollectionUtil::isNotEmpty)
                .map(l -> l.stream().map(this::toDomainModuleInfo).collect(Collectors.toList()))
                .orElse(null);
    }

    @Override
    public QuerySection<DomainModuleItem> page(DomainModulePageQueryRequest pageQueryRequest) {
        return domainModuleService.page(pageQueryRequest)
                .convertAsList(this::toDomainModuleItem);
    }

    DomainModuleItem toDomainModuleItem(DomainModuleEntity domainModuleEntity) {
        DomainModuleItem domainModuleItem = new DomainModuleItem();
        domainModuleItem.setCode(domainModuleEntity.getCode());
        domainModuleItem.setName(domainModuleEntity.getName());
        domainModuleItem.setType(domainModuleEntity.getType());
        return domainModuleItem;
    }
}

package org.featx.templet.app.facade;

import org.featx.spec.feature.ModelConvert;
import org.featx.spec.model.Coded;
import org.featx.spec.model.QuerySection;
import org.featx.spec.util.CollectionUtil;
import org.featx.templet.app.model.DomainModuleInfo;
import org.featx.templet.app.model.DomainModuleItem;
import org.featx.templet.app.model.DomainModulePageQueryRequest;
import org.featx.templet.app.model.DomainModuleSaveRequest;
import org.featx.templet.app.storage.entity.DomainModuleEntity;
import org.featx.templet.app.storage.query.DomainModuleCriteria;
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

    @Resource
    private ModelConvert modelConvert;

    @Override
    public Coded save(DomainModuleSaveRequest saveRequest) {
        final DomainModuleEntity domainModuleEntity = modelConvert.convert(saveRequest, DomainModuleEntity.class);
        domainModuleService.save(domainModuleEntity);
        return domainModuleEntity::getCode;
    }

    @Override
    public Coded update(DomainModuleSaveRequest saveRequest) {
        final DomainModuleEntity domainModuleEntity = modelConvert.convert(saveRequest, DomainModuleEntity.class);
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
                .map(entity -> modelConvert.convert(entity, DomainModuleInfo.class))
                .orElse(null);
    }

    @Override
    public List<DomainModuleInfo> listByCodes(List<String> codes) {
        return Optional.of(domainModuleService.listByCodes(codes))
                .filter(CollectionUtil::isNotEmpty)
                .map(l -> l.stream().map(e->modelConvert.convert(e, DomainModuleInfo.class))
                                    .collect(Collectors.toList()))
                .orElse(null);
    }

    @Override
    public QuerySection<DomainModuleItem> page(DomainModulePageQueryRequest pageQueryRequest) {
        return domainModuleService
                .page(modelConvert.convert(pageQueryRequest, DomainModuleCriteria.class), pageQueryRequest)
                .convertAsList(e->modelConvert.convert(e, DomainModuleItem.class));
    }
}

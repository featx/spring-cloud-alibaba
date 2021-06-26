package org.featx.templet.app.service;

import org.featx.spec.model.QuerySection;
import org.featx.templet.app.criteria.DomainFeatureModuleCriteria;
import org.featx.templet.app.entity.DomainFeatureModuleEntity;
import org.featx.templet.app.model.DomainFeatureModuleInfo;
import org.featx.templet.app.model.DomainFeatureModuleItem;
import org.featx.templet.app.model.DomainFeatureModulePageQuery;
import org.featx.templet.app.model.DomainFeatureModuleSave;

import java.util.List;

/**
 * @author Excepts
 * @since 2020/4/12 13:57
 */
public interface DomainFeatureModuleService {

    DomainFeatureModuleItem save(DomainFeatureModuleSave domainFeatureModuleSave);

    DomainFeatureModuleItem update(DomainFeatureModuleSave domainFeatureModuleSave);

    void delete(String code);

    DomainFeatureModuleInfo findOne(String code);

    List<DomainFeatureModuleItem> listByCodes(List<String> codes);

    QuerySection<DomainFeatureModuleItem> page(DomainFeatureModulePageQuery pageQuery);

    default DomainFeatureModuleEntity toEntity(DomainFeatureModuleSave domainFeatureModuleSave) {
        DomainFeatureModuleEntity domainFeatureModuleEntity = new DomainFeatureModuleEntity();
        domainFeatureModuleEntity.setCode(domainFeatureModuleSave.getCode());
        domainFeatureModuleEntity.setName(domainFeatureModuleSave.getName());
        domainFeatureModuleEntity.setType(domainFeatureModuleSave.getType());
        domainFeatureModuleEntity.setDescription(domainFeatureModuleSave.getDescription());
        return domainFeatureModuleEntity;
    }

    default DomainFeatureModuleInfo toInfo(DomainFeatureModuleEntity entity) {
        DomainFeatureModuleInfo info = new DomainFeatureModuleInfo();
        info.setCode(entity.getCode());
        info.setName(entity.getName());
        info.setType(entity.getType());
        info.setDescription(entity.getDescription());
        return info;
    }

    default DomainFeatureModuleItem toItem(DomainFeatureModuleEntity entity) {
        DomainFeatureModuleItem item = new DomainFeatureModuleItem();
        item.setCode(entity.getCode());
        item.setName(entity.getName());
        item.setType(entity.getType());
        item.setDescription(entity.getDescription());
        return item;
    }

    default DomainFeatureModuleCriteria toCriteria(DomainFeatureModulePageQuery pageQuery) {
        DomainFeatureModuleCriteria criteria = new DomainFeatureModuleCriteria();
//        criteria.setCode(pageQuery.getCode());
        return criteria;
    }
}

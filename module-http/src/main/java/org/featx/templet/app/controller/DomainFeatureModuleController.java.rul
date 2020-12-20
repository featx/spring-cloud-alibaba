package org.featx.templet.app.controller;

import org.featx.spec.model.*;
import org.featx.templet.app.endpoint.DomainFeatureModuleEndpoint;
import org.featx.templet.app.model.DomainModuleInfo;
import org.featx.templet.app.model.DomainModuleItem;
import org.featx.templet.app.model.DomainModulePageQueryRequest;
import org.featx.templet.app.model.DomainModuleSaveRequest;
import org.featx.templet.app.storage.entity.DomainModuleEntity;
import org.featx.templet.app.storage.query.DomainModuleCriteria;
import org.featx.templet.app.storage.service.DomainModuleService;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Excepts
 * @since 2020/4/12 13:54
 */
@RestController
public class DomainFeatureModuleController implements DomainFeatureModuleEndpoint {

    @Resource
    private DomainModuleService domainModuleService;

    private DomainModuleEntity toEntity(DomainModuleSaveRequest saveRequest) {
        DomainModuleEntity domainModuleEntity = new DomainModuleEntity();
        domainModuleEntity.setName(saveRequest.getName());
        return domainModuleEntity;
    }

    @Override
    public BaseResponse<Coded> save(final DomainModuleSaveRequest saveRequest) {
        DomainModuleEntity entity = toEntity(saveRequest);
        domainModuleService.save(entity);
        return BaseResponse.succeeded(entity::getCode);
    }

    @Override
    public BaseResponse<Coded> put(DomainModuleSaveRequest saveRequest) {
        DomainModuleEntity entity = toEntity(saveRequest);
        domainModuleService.update(entity);
        return BaseResponse.succeeded(entity::getCode);
    }

    @Override
    public BaseResponse<Void> delete(String code) {
        domainModuleService.delete(code);
        return BaseResponse.succeeded();
    }

    private DomainModuleInfo toInfo(DomainModuleEntity entity) {
        DomainModuleInfo info = new DomainModuleInfo();
        info.setCode(entity.getCode());
        info.setName(entity.getName());
        info.setType(entity.getType());
        return info;
    }

    @Override
    public BaseResponse<DomainModuleInfo> getByCode(String code) {
        DomainModuleEntity domainModuleEntity = domainModuleService.findOne(code);
        return BaseResponse.succeeded(toInfo(domainModuleEntity));
    }

    @Override
    public ListResponse<DomainModuleInfo> listByCode(List<String> codes) {
        List<DomainModuleEntity> entities = domainModuleService.listByCodes(codes);
        return ListResponse.succeeded(entities.stream().map(this::toInfo).collect(Collectors.toList()));
    }

    private DomainModuleCriteria toCriteria(DomainModulePageQueryRequest pageQueryRequest) {
        DomainModuleCriteria criteria = new DomainModuleCriteria();
        return criteria;
    }

    private DomainModuleItem toItem(DomainModuleEntity entity) {
        DomainModuleItem item = new DomainModuleItem();
        item.setCode(entity.getCode());
        item.setName(entity.getName());
        item.setType(entity.getType());
        return item;
    }

    @Override
    public PageResponse<DomainModuleItem> page(DomainModulePageQueryRequest pageQueryRequest) {
        QuerySection<DomainModuleEntity> querySection =
                domainModuleService.page(toCriteria(pageQueryRequest), pageQueryRequest);
        return PageResponse.succeeded(querySection.list().stream().map(this::toItem).collect(Collectors.toList()))
                .page(pageQueryRequest.getPage())
                .total(querySection.getTotal());
    }

}

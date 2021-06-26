package org.featx.templet.app.controller;

import org.featx.spec.model.BaseResponse;
import org.featx.spec.model.PageResponse;
import org.featx.spec.model.QuerySection;
import org.featx.templet.app.endpoint.DomainFeatureModuleEndpoint;
import org.featx.templet.app.model.DomainFeatureModuleInfo;
import org.featx.templet.app.model.DomainFeatureModuleItem;
import org.featx.templet.app.model.DomainFeatureModulePageQuery;
import org.featx.templet.app.model.DomainFeatureModuleSave;
import org.featx.templet.app.service.DomainFeatureModuleService;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class DomainFeatureModuleController implements DomainFeatureModuleEndpoint {
    @Resource
    private DomainFeatureModuleService domainFeatureModuleService;
    @Override
    public BaseResponse<DomainFeatureModuleItem> save(DomainFeatureModuleSave domainFeatureModuleSave) {
        return BaseResponse.succeeded(domainFeatureModuleService.save(domainFeatureModuleSave));
    }

    @Override
    public BaseResponse<DomainFeatureModuleItem> update(DomainFeatureModuleSave domainFeatureModuleSave) {
        return BaseResponse.succeeded(domainFeatureModuleService.update(domainFeatureModuleSave));
    }

    @Override
    public BaseResponse<Boolean> delete(String domainFeatureModuleCode) {
        domainFeatureModuleService.delete(domainFeatureModuleCode);
        return BaseResponse.succeeded(true);
    }

    @Override
    public BaseResponse<DomainFeatureModuleInfo> get(String domainFeatureModuleCode) {
        return BaseResponse.succeeded(domainFeatureModuleService.findOne(domainFeatureModuleCode));
    }

    @Override
    public PageResponse<DomainFeatureModuleItem> page(DomainFeatureModulePageQuery pageQuery) {
        QuerySection<DomainFeatureModuleItem> section = domainFeatureModuleService.page(pageQuery);
        return PageResponse.succeeded(section.list()).page(pageQuery.getPage()).total(section.getTotal());
    }
}

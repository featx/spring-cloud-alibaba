package org.featx.templet.app.controller;

import org.featx.spec.model.*;
import org.featx.templet.app.endpoint.DomainFeatureModuleEndpoint;
import org.featx.templet.app.facade.DomainModuleFacade;
import org.featx.templet.app.model.*;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Excepts
 * @since 2020/4/12 13:54
 */
@RestController
public class DomainFeatureModuleController implements DomainFeatureModuleEndpoint {

    @Resource
    private DomainModuleFacade domainModuleFacade;

    @Override
    public BaseResponse<Coded> save(DomainModuleSaveRequest saveRequest) {
        return BaseResponse.succeeded(domainModuleFacade.save(saveRequest));
    }

    @Override
    public BaseResponse<Coded> put(DomainModuleSaveRequest saveRequest) {
        return BaseResponse.succeeded(domainModuleFacade.update(saveRequest));
    }

    @Override
    public BaseResponse<Void> delete(String code) {
        domainModuleFacade.delete(code);
        return BaseResponse.succeeded();
    }

    @Override
    public BaseResponse<DomainModuleInfo> getByCode(String code) {
        return BaseResponse.succeeded(domainModuleFacade.getByCode(code));
    }

    @Override
    public ListResponse<DomainModuleInfo> listByCode(List<String> codes) {
        return ListResponse.succeeded(domainModuleFacade.listByCodes(codes));
    }

    @Override
    public PageResponse<DomainModuleItem> page(DomainModulePageQueryRequest pageQueryRequest) {
        QuerySection<DomainModuleItem> querySection = domainModuleFacade.page(pageQueryRequest);
        return PageResponse.succeeded(querySection.list())
                .page(pageQueryRequest.getPage())
                .total(querySection.getTotal());
    }

}

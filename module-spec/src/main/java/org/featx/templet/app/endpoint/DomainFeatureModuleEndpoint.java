package org.featx.templet.app.endpoint;

import org.featx.spec.model.BaseResponse;
import org.featx.spec.model.PageResponse;
import org.featx.templet.app.model.DomainFeatureModuleInfo;
import org.featx.templet.app.model.DomainFeatureModuleItem;
import org.featx.templet.app.model.DomainFeatureModulePageQuery;
import org.featx.templet.app.model.DomainFeatureModuleSave;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "module-core", fallbackFactory = DomainFeatureModuleFallbackFactory.class)
@RequestMapping("/domain-feature-module")
public interface DomainFeatureModuleEndpoint {

    @PostMapping
    @ResponseBody
    BaseResponse<DomainFeatureModuleItem> save(@RequestBody DomainFeatureModuleSave domainFeatureModuleSave);

    @PutMapping
    @ResponseBody
    BaseResponse<DomainFeatureModuleItem> update(@RequestBody DomainFeatureModuleSave domainFeatureModuleSave);

    @DeleteMapping
    @ResponseBody
    BaseResponse<Boolean> delete(@RequestParam("code") String domainFeatureModuleCode);


    @GetMapping
    @ResponseBody
    BaseResponse<DomainFeatureModuleInfo> get(@RequestParam("code") String domainFeatureModuleCode);

    @GetMapping("page")
    @ResponseBody
    PageResponse<DomainFeatureModuleItem> page(@RequestBody DomainFeatureModulePageQuery pageQuery);
}
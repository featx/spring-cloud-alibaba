package org.featx.templet.app.endpoint;


import org.featx.spec.model.BaseResponse;
import org.featx.spec.model.Coded;
import org.featx.spec.model.ListResponse;
import org.featx.spec.model.PageResponse;
import org.featx.templet.app.model.DomainModuleInfo;
import org.featx.templet.app.model.DomainModuleItem;
import org.featx.templet.app.model.DomainModulePageQueryRequest;
import org.featx.templet.app.model.DomainModuleSaveRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Excepts
 * @since 2020/4/11 22:23
 */
@RequestMapping("/domain/feature-module")
public interface DomainFeatureModuleEndpoint {
    /**
     * Create or update a domain module,
     * if code not provided, persistent this module with all of the properties
     * else if code existed, update all of the properties as saveRequest provided
     * else Error entity not found
     * @param saveRequest DomainModuleSaveRequest domain module with all properties
     * @return BaseResponse<Coded> The Base response structure with saved module's business code
     */
    @PostMapping
    @ResponseBody
    BaseResponse<Coded> save(@RequestBody DomainModuleSaveRequest saveRequest);

    @PutMapping
    @ResponseBody
    BaseResponse<Coded> put(@RequestBody DomainModuleSaveRequest saveRequest);

    @DeleteMapping
    @ResponseBody
    BaseResponse<Void> delete(@RequestParam String code);

    @GetMapping
    @ResponseBody
    BaseResponse<DomainModuleInfo> getByCode(@RequestParam("code") String code);

    @GetMapping("/list")
    @ResponseBody
    ListResponse<DomainModuleInfo> listByCode(@RequestParam("codes") List<String> codes);

    @GetMapping("/page")
    @ResponseBody
    PageResponse<DomainModuleItem> page(@RequestBody DomainModulePageQueryRequest pageQueryRequest);

//    @GetMapping("/flow")
//    @ResponseBody
//    FlowResponse<DomainModuleItem> flow(@RequestBody DomainModuleFlowQueryRequest flowQueryRequest);
//
//    @GetMapping("/roll")
//    @ResponseBody
//    RollResponse<DomainModuleItem> scroll(@RequestBody DomainModuleFlowQueryRequest flowQueryRequest);
}

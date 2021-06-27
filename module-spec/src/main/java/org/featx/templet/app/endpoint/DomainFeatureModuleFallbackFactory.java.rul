package org.featx.templet.app.endpoint;

import lombok.extern.slf4j.Slf4j;
import org.featx.spec.model.BaseResponse;
import org.featx.spec.model.PageResponse;
import org.featx.templet.app.model.DomainFeatureModuleInfo;
import org.featx.templet.app.model.DomainFeatureModuleItem;
import org.featx.templet.app.model.DomainFeatureModulePageQuery;
import org.featx.templet.app.model.DomainFeatureModuleSave;
import org.springframework.cloud.openfeign.FallbackFactory;

import java.util.Collections;

import static org.featx.spec.enums.BusinessError.SERVER_REMOTE_PROCEDURE_CALL;

@Slf4j
public class DomainFeatureModuleFallbackFactory implements FallbackFactory<DomainFeatureModuleEndpoint> {
    @Override
    public DomainFeatureModuleEndpoint create(Throwable cause) {
        return new DomainFeatureModuleEndpoint() {
            @Override
            public BaseResponse<DomainFeatureModuleItem> save(DomainFeatureModuleSave domainFeatureModuleSave) {
                log.error("Rpc domainFeatureModule save error", cause);
                return BaseResponse.occur(SERVER_REMOTE_PROCEDURE_CALL, cause.getMessage()).of(DomainFeatureModuleItem.class);
            }

            @Override
            public BaseResponse<DomainFeatureModuleItem> update(DomainFeatureModuleSave domainFeatureModuleSave) {
                log.error("Rpc domainFeatureModule update error", cause);
                return BaseResponse.occur(SERVER_REMOTE_PROCEDURE_CALL, cause.getMessage()).of(DomainFeatureModuleItem.class);
            }

            @Override
            public BaseResponse<Boolean> delete(String domainFeatureModuleCode) {
                log.error("Rpc domainFeatureModule delete error", cause);
                return BaseResponse.occur(SERVER_REMOTE_PROCEDURE_CALL, cause.getMessage()).of(Boolean.class);
            }

            @Override
            public BaseResponse<DomainFeatureModuleInfo> get(String domainFeatureModuleCode) {
                log.error("Rpc domainFeatureModule retrieve error", cause);
                return BaseResponse.occur(SERVER_REMOTE_PROCEDURE_CALL, cause.getMessage()).of(DomainFeatureModuleInfo.class);
            }

            @Override
            public PageResponse<DomainFeatureModuleItem> page(DomainFeatureModulePageQuery pageQuery) {
                log.error("Rpc page domainFeatureModule retrieve error", cause);
                return PageResponse.occur(SERVER_REMOTE_PROCEDURE_CALL, Collections.singletonList(cause.getMessage()))
                        .ofList(DomainFeatureModuleItem.class);
            }
        };
    }
}

package org.featx.templet.app.convert;

import org.featx.templet.app.model.DomainModuleInfo;
import org.featx.templet.app.storage.entity.DomainModuleEntity;
import org.springframework.core.convert.converter.Converter;

public class DomainFeatureModuleConverter implements Converter<DomainModuleEntity, DomainModuleInfo> {

    @Override
    public DomainModuleInfo convert(DomainModuleEntity entity) {

        return null;
    }

}

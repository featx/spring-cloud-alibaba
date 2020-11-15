package org.featx.templet.app.facade;

import org.featx.spec.model.Coded;
import org.featx.spec.model.QuerySection;
import org.featx.templet.app.model.DomainModuleInfo;
import org.featx.templet.app.model.DomainModuleItem;
import org.featx.templet.app.model.DomainModulePageQueryRequest;
import org.featx.templet.app.model.DomainModuleSaveRequest;

import java.util.List;

/**
 * @author Excepts
 * @since 2020/4/12 13:56
 */
public interface DomainModuleFacade {

    Coded save(DomainModuleSaveRequest saveRequest);

    Coded update(DomainModuleSaveRequest saveRequest);

    void delete(String domainCode);

    DomainModuleInfo getByCode(String code);

    List<DomainModuleInfo> listByCodes(List<String> codes);

    QuerySection<DomainModuleItem> page(DomainModulePageQueryRequest pageQueryRequest);
}

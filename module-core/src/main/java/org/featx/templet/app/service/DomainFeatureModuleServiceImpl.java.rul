package org.featx.templet.app.service;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.featx.spec.feature.IdGenerate;
import org.featx.spec.model.QuerySection;
import org.featx.spec.util.CollectionUtil;
import org.featx.spec.util.StringUtil;
import org.featx.templet.app.criteria.DomainFeatureModuleCriteria;
import org.featx.templet.app.entity.DomainFeatureModuleEntity;
import org.featx.templet.app.mapper.DomainFeatureModuleMapper;
import org.featx.templet.app.model.DomainFeatureModuleInfo;
import org.featx.templet.app.model.DomainFeatureModuleItem;
import org.featx.templet.app.model.DomainFeatureModulePageQuery;
import org.featx.templet.app.model.DomainFeatureModuleSave;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Excepts
 * @since 2020/4/12 14:27
 */
@Slf4j
@Service
public class DomainFeatureModuleServiceImpl implements DomainFeatureModuleService {

    @Resource
    private DomainFeatureModuleMapper domainFeatureModuleMapper;

    @Resource
    private IdGenerate idGenerate;

    @Override
    @Transactional
    public DomainFeatureModuleItem save(DomainFeatureModuleSave domainFeatureModuleSave) {
        DomainFeatureModuleEntity entity = toEntity(domainFeatureModuleSave);
        if (StringUtil.isBlank(entity.getCode())) {
            entity.setCode(String.format("%s%s", "DFM", Long.toString(idGenerate.nextId(), 36)));
            domainFeatureModuleMapper.insert(entity);
        } else {
            domainFeatureModuleMapper.upsert(entity);
        }
        return toItem(entity);
    }

    @Override
    @Transactional
    public DomainFeatureModuleItem update(DomainFeatureModuleSave domainFeatureModuleSave) {
        DomainFeatureModuleEntity entity = toEntity(domainFeatureModuleSave);
        domainFeatureModuleMapper.update(entity);
        return toItem(entity);
    }

    @Override
    public void delete(String code) {
        domainFeatureModuleMapper.delete(code, true);
    }

    @Override
    public DomainFeatureModuleInfo findOne(String code) {
        return toInfo(domainFeatureModuleMapper.selectByCode(code));
    }

    @Override
    public List<DomainFeatureModuleItem> listByCodes(List<String> codes) {
        return Optional.ofNullable(codes)
                .map(list -> list.stream().filter(StringUtil::isNotBlank).collect(Collectors.toList()))
                .filter(CollectionUtil::isNotEmpty)
                .map(list -> domainFeatureModuleMapper.selectByCodes(list))
                .filter(CollectionUtil::isNotEmpty)
                .map(list -> list.stream()
                        .map(this::toItem)
                        .sorted(Comparator.comparingInt(dme -> codes.indexOf(dme.getCode())))
                        .collect(Collectors.toList()))
                .orElseGet(Lists::newArrayList);
    }

    @Override
    @Transactional(readOnly = true)
    public QuerySection<DomainFeatureModuleItem> page(DomainFeatureModulePageQuery pageQuery) {
        DomainFeatureModuleCriteria criteria = toCriteria(pageQuery);
        long count = domainFeatureModuleMapper.countByQuery(criteria);
        if(count <= 0) {
            return QuerySection.of(Lists.newArrayList());
        }
        List<DomainFeatureModuleEntity> moduleEntities =
                domainFeatureModuleMapper.selectByPage(criteria, pageQuery.correctProperties());
        return QuerySection.of(moduleEntities.stream().map(this::toItem).collect(Collectors.toList()))
                .total(count);
    }

}

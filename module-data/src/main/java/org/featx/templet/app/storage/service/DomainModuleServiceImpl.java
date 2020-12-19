package org.featx.templet.app.storage.service;

import com.google.common.collect.Lists;
import org.featx.spec.feature.IdGenerate;
import org.featx.spec.model.PageRequest;
import org.featx.spec.model.QuerySection;
import org.featx.spec.util.CollectionUtil;
import org.featx.spec.util.StringUtil;
import org.featx.templet.app.storage.entity.DomainModuleEntity;
import org.featx.templet.app.storage.mapper.DomainModuleMapper;
import org.featx.templet.app.storage.query.DomainModuleCriteria;
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
@Service
public class DomainModuleServiceImpl implements DomainModuleService {

    @Resource
    private DomainModuleMapper domainModuleMapper;

    @Resource
    private IdGenerate idGenerate;

    @Override
    @Transactional
    public void save(DomainModuleEntity domainModuleEntity) {
        if (StringUtil.isBlank(domainModuleEntity.getCode())) {
            domainModuleEntity.setCode(String.format("%s%s", "DFM", Long.toString(idGenerate.nextId(), 36)));
            domainModuleMapper.insert(domainModuleEntity);
        } else {
            domainModuleMapper.upsert(domainModuleEntity);
        }
    }

    @Override
    @Transactional
    public void update(DomainModuleEntity domainModuleEntity) {
        domainModuleMapper.update(domainModuleEntity);
    }

    @Override
    public void delete(String code) {
        domainModuleMapper.delete(code, true);
    }

    @Override
    public DomainModuleEntity findOne(String code) {
        return domainModuleMapper.selectByCode(code);
    }

    @Override
    public List<DomainModuleEntity> listByCodes(final List<String> codes) {
        return Optional.ofNullable(codes)
                .map(list -> list.stream().filter(StringUtil::isNotBlank).collect(Collectors.toList()))
                .filter(CollectionUtil::isNotEmpty)
                .map(list -> domainModuleMapper.selectByCodes(list))
                .filter(CollectionUtil::isNotEmpty)
                .map(list -> list.stream().sorted(Comparator.comparingInt(dme -> codes.indexOf(dme.getCode()))).collect(Collectors.toList()))
                .orElseGet(Lists::newArrayList);
    }

    @Override
    @Transactional(readOnly = true)
    public QuerySection<DomainModuleEntity> page(DomainModuleCriteria criteria, PageRequest pageRequest) {
        long count = domainModuleMapper.countByQuery(criteria);
        if(count <= 0) {
            return QuerySection.of(Lists.newArrayList());
        }
        List<DomainModuleEntity> moduleEntities = domainModuleMapper.selectByPage(criteria, pageRequest);
        return QuerySection.of(moduleEntities).total(count);
    }
}
package org.featx.templet.app.storage.service;

import com.google.common.collect.Lists;
import org.featx.spec.entity.AbstractUnified;
import org.featx.spec.model.QuerySection;
import org.featx.spec.util.CollectionUtil;
import org.featx.spec.util.StringUtil;
import org.featx.templet.app.model.DomainModulePageQueryRequest;
import org.featx.templet.app.storage.entity.DomainModuleEntity;
import org.featx.templet.app.storage.mapper.DomainModuleMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Excepts
 * @since 2020/4/12 14:27
 */
@Service
public class DomainModuleServiceImpl implements DomainModuleService {

    @Resource
    private DomainModuleMapper domainModuleMapper;

    @Override
    @Transactional
    public void save(DomainModuleEntity domainModuleEntity) {
        if (StringUtil.isBlank(domainModuleEntity.getCode())) {
            domainModuleMapper.insert(domainModuleEntity);
        } else {
            domainModuleMapper.update(domainModuleEntity);
        }
    }

    @Override
    @Transactional
    public void update(DomainModuleEntity domainModuleEntity) {
//        domainModuleMapper.update(domainModuleEntity);?
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
        final List<DomainModuleEntity> result = Lists.newArrayList();
        if (CollectionUtil.isEmpty(codes)) {
            return result;
        }
        return Optional.of(domainModuleMapper.selectByCodes(codes))
                .filter(CollectionUtil::isNotEmpty)
                .map(entities -> entities.stream()
                        .collect(Collectors.toMap(AbstractUnified::getCode, Function.identity())))
                .map(map -> {
                    codes.forEach(c -> Optional.of(map.get(c)).ifPresent(result::add));
                    return result;
                }).orElse(result);
    }

    @Override
    @Transactional(readOnly = true)
    public QuerySection<DomainModuleEntity> page(DomainModulePageQueryRequest domainPageQueryRequest) {
        List<DomainModuleEntity> moduleEntities = domainModuleMapper.selectByPage(domainPageQueryRequest);
        long count = domainModuleMapper.countByQuery(domainPageQueryRequest);
        return QuerySection.of(moduleEntities).total(count);
    }
}
package org.featx.templet.app.mapper;

import lombok.extern.slf4j.Slf4j;
import org.featx.templet.app.SpringDataTestSuit;
import org.featx.templet.app.entity.DomainFeatureModuleEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
@Slf4j
@Transactional
@EnableAutoConfiguration
@DisplayName("Mapper: DomainFeatureModule")
public class DomainFeatureModuleMapperTest extends SpringDataTestSuit {

    @Resource
    private DomainFeatureModuleMapper domainFeatureModuleMapper;

    private DomainFeatureModuleEntity domainFeatureModuleEntity;

    private DomainFeatureModuleEntity generate() {
        DomainFeatureModuleEntity entity = generate(DomainFeatureModuleEntity.class);
        entity.setCode(entity.getCode().length() > 32 ? entity.getCode().substring(0, 32) : entity.getCode());
        entity.setName(entity.getName().length() > 32 ? entity.getName().substring(0, 32) : entity.getName());
        entity.setDescription(entity.getDescription().length() > 255 ? entity.getDescription().substring(0, 255) :
                entity.getDescription());
        return entity;
    }

    @BeforeEach
    void prepare() {
        domainFeatureModuleEntity = generate();
        domainFeatureModuleMapper.insert(domainFeatureModuleEntity);
        DomainFeatureModuleEntity retrieveEntity = domainFeatureModuleMapper.selectByCode(domainFeatureModuleEntity.getCode());
        domainFeatureModuleEntity.setDeleted(retrieveEntity.getDeleted());
        domainFeatureModuleEntity.setCreatedAt(retrieveEntity.getCreatedAt());
        domainFeatureModuleEntity.setUpdatedAt(retrieveEntity.getUpdatedAt());
    }

    @Test
    void testUpdate() {
        DomainFeatureModuleEntity newEntity = new DomainFeatureModuleEntity();
        newEntity.setName("name");
        newEntity.setType(2);
        newEntity.setDescription("description");
        assertEquals(0, domainFeatureModuleMapper.update(newEntity));

        newEntity.setCode(domainFeatureModuleEntity.getCode());
        assertEquals(1, domainFeatureModuleMapper.update(newEntity));


        DomainFeatureModuleEntity retrieveEntity = domainFeatureModuleMapper.selectByCode(domainFeatureModuleEntity.getCode());
        domainFeatureModuleEntity.setName("name");
        domainFeatureModuleEntity.setType(2);
        domainFeatureModuleEntity.setDescription("description");
        domainFeatureModuleEntity.setUpdatedAt(retrieveEntity.getUpdatedAt());

        assertEquals(domainFeatureModuleEntity, retrieveEntity);
    }

    @Test
    void testDelete() {
        assertEquals(1, domainFeatureModuleMapper.delete(domainFeatureModuleEntity.getCode(), true));
        assertNull(domainFeatureModuleMapper.selectByCode(domainFeatureModuleEntity.getCode()));
    }
}

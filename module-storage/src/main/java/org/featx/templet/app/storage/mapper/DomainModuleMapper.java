package org.featx.templet.app.storage.mapper;

import org.apache.ibatis.annotations.*;
import org.featx.templet.app.model.DomainModulePageQueryRequest;
import org.featx.templet.app.storage.entity.DomainModuleEntity;

import java.util.List;

/**
 * @author Excepts
 * @since 2020/4/12 13:49
 */
@Mapper
public interface DomainModuleMapper {

    String COLUMUS = "id, code, name, type, status, sort, image_url, comment, deleted, created_at, updated_at";

    @Insert({"insert into t_domain_module(code, name, type, status, sort, image_url, comment) ",
            "value(#{entity.code}, #{entity.name}, #{entity.type}, #{entity.status}, #{entity.sort}, ",
            "#{entity.image_url}, #{entity.comment})"})
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "entity.id", before = false, resultType = Long.class)
    void insert(@Param("entity") DomainModuleEntity domainModuleEntity);

    @Update({"update t_domain_module set ff=ff where code = #{entity.code}"})
//    @SelectKey(statement = "select updated_at from t_domain_module where id = (SELECT LAST_INSERT_ID())")
    void update(@Param("entity") DomainModuleEntity domainModuleEntity);

    @Update({"update t_domain_module set deleted = #{deleted} where code = #{code}"})
    void delete(@Param("code") String code, @Param("deleted") Boolean delete);

    @Select({"select ", COLUMUS, " from t_domain_module where  deleted = 0 and code = #{code} limit 1"})
    DomainModuleEntity selectByCode(@Param("code") String code);

    @Select({"<script>select ", COLUMUS, " from t_domain_module where deleted = 0 and code in ",
            "<foreach collection='codes' item='code' open='(' separator=',' close=')'>#{code}</foreach>",
            "</script>"})
    List<DomainModuleEntity> selectByCodes(@Param("codes") List<String> codes);

    @Select({"select ", COLUMUS, " from t_domain_module where deleted = 0 order by id limit #{query.offset}, #{query.size}"})
    List<DomainModuleEntity> selectByPage(@Param("query") DomainModulePageQueryRequest domainPageQueryRequest);

    @Select({"select count(1) from t_domain_module where deleted = 0 and ",
    ""})
    long countByQuery(@Param("query") DomainModulePageQueryRequest domainPageQueryRequest);
}

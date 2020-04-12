package org.featx.templet.app.storage.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.featx.spec.entity.AbstractUnified;

/**
 * @author Excepts
 * @since 2020/4/12 13:52
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class DomainModuleEntity extends AbstractUnified<Long> {

    private static final long serialVersionUID = -4441039419344895608L;

    private Integer status;

    private Integer sort;

    private String imageUrl;

    private String comment;
}
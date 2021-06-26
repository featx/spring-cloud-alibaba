package org.featx.templet.app.criteria;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author Excepts
 * @since 2020/6/21 11:15
 */
@Data
@EqualsAndHashCode
@ToString
public class DomainFeatureModuleCriteria {

    private String code;

    private String name;

    private Integer type;
}

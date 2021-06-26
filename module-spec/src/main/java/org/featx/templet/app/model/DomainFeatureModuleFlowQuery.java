package org.featx.templet.app.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.featx.spec.model.FlowRequest;

/**
 * @author Excepts
 * @since 2020/4/11 23:26
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class DomainFeatureModuleFlowQuery extends FlowRequest {

    private static final long serialVersionUID = -3378756542362683471L;

//    private ${property.type} ${property.name}
    private String description;
}

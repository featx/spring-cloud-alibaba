package org.featx.templet.app.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.featx.spec.model.Record;

import java.time.LocalDateTime;


/**
 * @author Excepts
 * @since 2020/4/11 22:34
 */
@Data
@EqualsAndHashCode
@ToString(callSuper = true)
public class DomainFeatureModuleRecord {

    private static final long serialVersionUID = 3542473394788128677L;

//    private ${property.type} ${property.name}
    private String description;
}

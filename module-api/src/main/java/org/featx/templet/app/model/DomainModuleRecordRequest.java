package org.featx.templet.app.model;

import lombok.Data;
import org.featx.spec.model.Record;

import java.time.LocalDateTime;

/**
 * @author Excepts
 * @since 2020/4/11 22:34
 */
@Data
public class DomainModuleRecordRequest implements Record {

    private LocalDateTime createdAt;
}

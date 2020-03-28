package org.featx.templet.springcloudalibaba.entity;

import org.featx.spec.entity.AbstractUnified;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Excepts
 * @since 2019/11/23 15:18
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Channel extends AbstractUnified<Long> {

    private String specialCode;
}

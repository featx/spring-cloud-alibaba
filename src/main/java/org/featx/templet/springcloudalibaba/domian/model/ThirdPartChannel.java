package org.featx.templet.springcloudalibaba.domian.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Excepts
 * @since 2019-10-28 13:16
 */
@Data
public class ThirdPartChannel implements Serializable {

    private String code;

    private String name;

    private Integer type;

}

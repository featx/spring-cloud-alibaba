package org.featx.templet.app.enums;

import java.util.Arrays;

/**
 * @author Excepts
 * @since 2020/4/12 15:21
 */
public enum DomainModuleTypeEnum {
    /**
     * 推荐
     */
    Recommend(1, "Recommend"),
    /**
     * 快讯
     */
    Flash(2, "Flash"),
    /**
     * 穿搭
     */
    DressUp(3, "Dress up"),
    /**
     *
     */
    Unpacking(4, "Unpacking");

    private final Integer code;

    private final String value;

    DomainModuleTypeEnum(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    public boolean codeEquals(Integer code) {
        return this.code.equals(code);
    }

    public static DomainModuleTypeEnum of(Integer code) {
        return Arrays.stream(DomainModuleTypeEnum.values())
                .filter(channelTypeEnum -> channelTypeEnum.codeEquals(code))
                .findFirst().orElse(null);
    }
}

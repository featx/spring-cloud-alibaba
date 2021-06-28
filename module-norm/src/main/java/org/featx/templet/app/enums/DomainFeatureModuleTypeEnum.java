package org.featx.templet.app.enums;

import java.util.Arrays;

/**
 *
 */
public enum DomainFeatureModuleTypeEnum {
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

    DomainFeatureModuleTypeEnum(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    public boolean codeEquals(Integer code) {
        return this.code.equals(code);
    }

    public static DomainFeatureModuleTypeEnum of(Integer code) {
        return Arrays.stream(DomainFeatureModuleTypeEnum.values())
                .filter(channelTypeEnum -> channelTypeEnum.codeEquals(code))
                .findFirst().orElse(null);
    }
}

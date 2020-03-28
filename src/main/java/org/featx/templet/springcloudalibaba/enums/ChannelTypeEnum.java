package org.featx.templet.springcloudalibaba.enums;


import lombok.Getter;

import java.util.Arrays;

/**
 *
 * @author Excepts
 * @since 2019/11/23 14:43
 */

@Getter
public enum ChannelTypeEnum {
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
     * 开箱
     */
    Unpacking(4, "Unpacking")
    ;

    private Integer code;

    private String message;

    ChannelTypeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public boolean codeEquals(Integer code) {
        return this.code.equals(code);
    }

    public ChannelTypeEnum get(Integer code) {
        return Arrays.stream(ChannelTypeEnum.values())
                .filter(channelTypeEnum -> channelTypeEnum.codeEquals(code))
                .findFirst().orElse(null);
    }
}

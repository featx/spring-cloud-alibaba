package org.featx.templet.springcloudalibaba.facade.impl;

import org.featx.templet.springcloudalibaba.facade.ChannelRender;
import org.featx.templet.springcloudalibaba.service.ChannelService;

import javax.annotation.Resource;

/**
 * @author Excepts
 * @since 2019/11/23 12:32
 */
public abstract class AbstractChannelRender implements ChannelRender {

    @Resource
    private ChannelService channelService;
}

package org.featx.templet.springcloudalibaba.facade.impl;

import org.featx.templet.springcloudalibaba.controller.model.ChannelDetail;
import org.featx.templet.springcloudalibaba.controller.model.ChannelDetailQueryReq;
import org.featx.templet.springcloudalibaba.facade.ChannelFacade;
import org.featx.templet.springcloudalibaba.facade.ChannelRender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Excepts
 * @since 2019-10-28 15:11
 */
@Slf4j
@Component
public class ChannelFacadeImpl implements ChannelFacade {

    @Resource
    private List<ChannelRender> channelRenders;

    @Override
    public ChannelDetail renderChannel(final ChannelDetailQueryReq channelDetailQueryReq) {
        return channelRenders.parallelStream()
                .filter(crs -> crs.referable(channelDetailQueryReq.getType()))
                .findFirst()
                .orElseGet(() -> channelRequest -> {
                    log.error("Cannot find channel render for type {}", channelDetailQueryReq.getType());
                    return null;
//                    return new ChannelDetail();
                }).render(channelDetailQueryReq);
    }
}

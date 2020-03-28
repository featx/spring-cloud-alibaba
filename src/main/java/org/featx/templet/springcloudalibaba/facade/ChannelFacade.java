package org.featx.templet.springcloudalibaba.facade;

import org.featx.templet.springcloudalibaba.controller.model.ChannelDetail;
import org.featx.templet.springcloudalibaba.controller.model.ChannelDetailQueryReq;

/**
 * @author Excepts
 * @since 2019/11/23
 */
public interface ChannelFacade {
    ChannelDetail renderChannel(ChannelDetailQueryReq channelDetailQueryReq);
}

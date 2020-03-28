package org.featx.templet.springcloudalibaba.facade;

import org.featx.templet.springcloudalibaba.controller.model.ChannelDetail;
import org.featx.templet.springcloudalibaba.controller.model.ChannelDetailQueryReq;

/**
 * @author Excepts
 * @since 2019/11/23 12:31
 */
public interface ChannelRender {
    /**
     * Check if current renderer is able to render this type of channel
     * @param type Recommend
     * @return Able or not able to render this type of channel
     */
    default boolean referable(Integer type) {
        return false;
    }

    /**
     * Some channel render data
     * @param channelRequest The channel request parameters
     * @return ChannelDetail
     */
    ChannelDetail render(ChannelDetailQueryReq channelRequest);
}

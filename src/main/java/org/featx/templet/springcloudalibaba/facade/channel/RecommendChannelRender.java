package org.featx.templet.springcloudalibaba.facade.channel;

import org.featx.templet.springcloudalibaba.controller.model.ChannelDetail;
import org.featx.templet.springcloudalibaba.controller.model.ChannelDetailQueryReq;
import org.featx.templet.springcloudalibaba.enums.ChannelTypeEnum;
import org.featx.templet.springcloudalibaba.facade.impl.AbstractChannelRender;
import org.springframework.stereotype.Component;

/**
 * @author Excepts
 * @since 2019/11/23 12:32
 */
@Component
public class RecommendChannelRender extends AbstractChannelRender {

    @Override
    public boolean referable(Integer type) {
        return ChannelTypeEnum.Recommend.codeEquals(type);
    }

    @Override
    public ChannelDetail render(ChannelDetailQueryReq channelRequest) {
        ChannelDetail recommendChannelDetail = new ChannelDetail();
        //TODO
        return recommendChannelDetail;
    }
}

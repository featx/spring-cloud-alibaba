package org.featx.templet.springcloudalibaba.facade.channel;

import org.featx.templet.springcloudalibaba.controller.model.ChannelDetail;
import org.featx.templet.springcloudalibaba.controller.model.ChannelDetailQueryReq;
import org.featx.templet.springcloudalibaba.enums.ChannelTypeEnum;
import org.featx.templet.springcloudalibaba.facade.impl.AbstractChannelRender;
import org.springframework.stereotype.Component;

/**
 * @author Excepts
 * @since 2019/11/23 15:12
 */
@Component
public class DressUpChannelRender extends AbstractChannelRender {

    @Override
    public boolean referable(Integer type) {
        return ChannelTypeEnum.DressUp.codeEquals(type);
    }

    @Override
    public ChannelDetail render(ChannelDetailQueryReq channelRequest) {
        ChannelDetail dressUpChannelDetail = new ChannelDetail();
        //TODO
        return dressUpChannelDetail;
    }
}

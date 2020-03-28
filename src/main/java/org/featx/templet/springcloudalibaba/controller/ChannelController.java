package org.featx.templet.springcloudalibaba.controller;

import org.featx.spec.model.BaseResponse;
import org.featx.templet.springcloudalibaba.controller.model.ChannelDetail;
import org.featx.templet.springcloudalibaba.controller.model.ChannelDetailQueryReq;
import org.featx.templet.springcloudalibaba.facade.ChannelFacade;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;

/**
 * @author Excepts
 * @since 2019-10-28 15:07
 */
@RestController("/channel")
@RefreshScope
public class ChannelController {

    @Resource
    private ChannelFacade channelFacade;

    @GetMapping("info")
    public BaseResponse<ChannelDetail> render(@RequestBody ChannelDetailQueryReq channelDetailQueryReq) {
        return BaseResponse.succeeded(channelFacade.renderChannel(channelDetailQueryReq));
    }

    @GetMapping("info-mono")
    public Mono<BaseResponse<ChannelDetail>> renderAsMono(@RequestBody final ChannelDetailQueryReq channelDetailQueryReq) {
        return Mono.create(s -> {
            ChannelDetail channelDetail = channelFacade.renderChannel(channelDetailQueryReq);
            s.success(BaseResponse.succeeded(channelDetail));
        });
    }

    @GetMapping("info-flux")
    public Flux<BaseResponse<ChannelDetail>> renderAsFlux(@RequestBody final ChannelDetailQueryReq channelDetailQueryReq) {
        return Flux.create(fluxSink -> {
            ChannelDetail channelDetail = channelFacade.renderChannel(channelDetailQueryReq);
            fluxSink.next(BaseResponse.succeeded(channelDetail));
        });
    }

}

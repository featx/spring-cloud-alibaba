package org.featx.templet.springcloudalibaba.service.impl;

import org.featx.templet.springcloudalibaba.domian.mapper.ChannelMapper;
import org.featx.templet.springcloudalibaba.entity.Channel;
import org.featx.templet.springcloudalibaba.service.ChannelService;
import lombok.Data;
import org.springframework.messaging.core.MessageSendingOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Excepts
 * @since 2019/11/23 15:13
 */
@Data
@Service
public class ChannelServiceImpl implements ChannelService {
    @Resource
    private ChannelMapper channelMapper;

    @Resource
    private MessageSendingOperations messageSendingOperations;

    @Override
    public Channel findCoinByCode(String code) {
        messageSendingOperations.convertAndSend("Message");
        return channelMapper.selectByCode(code);
    }
}

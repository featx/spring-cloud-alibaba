package org.featx.templet.springcloudalibaba.service;

import org.featx.templet.springcloudalibaba.entity.Channel;

/**
 * @author Excepts
 * @since 2019-10-28 14:23
 */
public interface ChannelService {
    Channel findCoinByCode(String code);
}

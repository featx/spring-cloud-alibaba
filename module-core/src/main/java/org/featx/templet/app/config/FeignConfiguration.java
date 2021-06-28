package org.featx.templet.app.config;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;

/**
 *
 */
//@Configuration
public class FeignConfiguration {

    @Bean
    public ResponseEntityDecoder feignDecoder(@Qualifier("fastJsonConverter") HttpMessageConverter fastJsonConverter) {
        ObjectFactory<HttpMessageConverters> objectFactory = () -> new HttpMessageConverters(fastJsonConverter);
        return new ResponseEntityDecoder(new SpringDecoder(objectFactory));
    }

    @Bean
    public SpringEncoder feignEncoder(@Qualifier("fastJsonConverter") HttpMessageConverter fastJsonConverter){
        ObjectFactory<HttpMessageConverters> objectFactory = () -> new HttpMessageConverters(fastJsonConverter);
        return new SpringEncoder(objectFactory);
    }
}

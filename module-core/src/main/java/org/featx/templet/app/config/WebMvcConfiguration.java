package org.featx.templet.app.config;

import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 */

//@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

    @Resource
    HttpMessageConverter fastJsonConverter;

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(0, fastJsonConverter);
    }
}

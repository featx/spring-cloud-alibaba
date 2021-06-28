package org.featx.templet.app.config;

import org.featx.spec.feature.ModelConvert;
import org.featx.spec.feature.ReflectionModelConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 */
@Configuration
public class BeanConfiguration {
    @Bean
    ModelConvert reflectionModelConverter() {
        return BeanUtils.instantiateClass(ReflectionModelConverter.class);
    }
}

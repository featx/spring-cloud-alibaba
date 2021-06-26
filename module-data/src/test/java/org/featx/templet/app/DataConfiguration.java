package org.featx.templet.app;


import com.zaxxer.hikari.HikariDataSource;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.jeasy.random.randomizers.range.IntegerRangeRandomizer;
import org.jeasy.random.randomizers.range.LongRangeRandomizer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.nio.charset.StandardCharsets;
import java.time.LocalTime;

@Configuration
@MapperScan("org.featx.templet.app.mapper")
class DataConfiguration {
    @Bean
    @ConfigurationProperties("spring.datasource.hikari")
    DataSource dataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Bean
    EasyRandom easyRandom() {
        EasyRandomParameters easyRandomParameters = new EasyRandomParameters()
                .seed(1000L)
                .objectPoolSize(1000)
                .randomizationDepth(10)
                .randomize(Long.class, new LongRangeRandomizer(1L, 1000000L))
                .randomize(Integer.class, new IntegerRangeRandomizer(1, 100000))
                .charset(StandardCharsets.UTF_8)
                .timeRange(LocalTime.MIN, LocalTime.MAX)
//                .dateRange(LocalDate.MIN, LocalDate.now())
                .stringLengthRange(8, 100)
                .collectionSizeRange(6, 20)
                .scanClasspathForConcreteTypes(true)
                .overrideDefaultInitialization(false)
                .ignoreRandomizationErrors(true);
        return new EasyRandom(easyRandomParameters);
    }
}


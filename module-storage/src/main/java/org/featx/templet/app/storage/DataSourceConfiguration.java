package org.featx.templet.app.storage;

import com.zaxxer.hikari.HikariDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

//import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * @author Excepts
 * @since 2020/4/6 0:10
 */

@Configuration
//@EntityScan("org.featx.sta2ry.entity")
@MapperScan("org.featx.templet.app.storage.mapper")
public class DataSourceConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public DataSource dataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

}

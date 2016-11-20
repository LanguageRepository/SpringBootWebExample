package com.example.configuration;

import org.apache.tomcat.jdbc.pool.PoolConfiguration;
import org.apache.tomcat.jdbc.pool.PoolProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.username}")
    private String username;

    @Bean
    public DataSource getDataSource() {
        PoolConfiguration config = new PoolProperties();
        config.setDriverClassName(driverClassName);
        config.setUrl(url);
        config.setUsername(username);
        config.setPassword(password);

        return new org.apache.tomcat.jdbc.pool.DataSource(config);
    }
}

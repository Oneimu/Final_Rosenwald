package com.example.demorosenwald.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource dataSource(){
        return DataSourceBuilder.create()
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .url("jdbc:mysql://rosenwald-database-collection.cogizoqxpnzn.us-east-1.rds.amazonaws.com:3306/rosenwald")
                .username("root")
                .password("Davidson2001*")
                .build();
    }

}

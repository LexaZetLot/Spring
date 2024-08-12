package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "org.example")
@PropertySource("classpath:db.properties")
public class DAOConfig {
    @Bean(name = "test")
    public JDBCDAO jdbcdao() {
        return new JDBCDAO();
    }
}

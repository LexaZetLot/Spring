package org.example.config;

import org.example.FoodProviderService;
import org.example.kindergarten.FoodProviderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("kindergarten")
public class KindergartenConfig {
    @Bean
    public FoodProviderService foodProviderService(){
        return new FoodProviderServiceImpl();
    }
}

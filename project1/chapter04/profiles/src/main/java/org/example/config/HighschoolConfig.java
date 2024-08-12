package org.example.config;


import org.example.FoodProviderService;
import org.example.highschool.FoodProviderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("highschool")
public class HighschoolConfig {
    @Bean
    public FoodProviderService foodProviderService(){
        return new FoodProviderServiceImpl();
    }
}

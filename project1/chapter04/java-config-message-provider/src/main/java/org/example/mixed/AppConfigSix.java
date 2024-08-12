package org.example.mixed;

import org.example.ConfigurableMessageProvider;
import org.example.MessageProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfigSix {
    @Bean
    MessageProvider provider(){
        return new ConfigurableMessageProvider("Love on the weekend");
    }
}

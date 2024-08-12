package org.example.annotated;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = {"org.example.annotated"})
@Configuration
public class HelloWorldConfiguration {
}

package com.example.project;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@EnableAutoConfiguration
@ComponentScan("com.example.project")
@PropertySources({
        @PropertySource("classpath:/some.properties"),
        @PropertySource("classpath:/override.properties")
})
public class SomeConfig {
}

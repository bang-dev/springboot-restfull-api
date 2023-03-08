package com.dev.springbootmongorestapi;

import com.dev.springbootmongorestapi.controllers.urls.ProfileURL;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebServiceConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping(ProfileURL.ORG_URL)
                        .allowedOrigins("http://localhost:8076");
            }
        };
    }
}

package com.dev.config;

import com.dev.services.MailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    @Bean
    public MailService mailService(){
        return new MailService();
    }

    @Bean
    @Scope("prototype")
    public MailService prototypeMailService(){
        return new MailService();
    }
}

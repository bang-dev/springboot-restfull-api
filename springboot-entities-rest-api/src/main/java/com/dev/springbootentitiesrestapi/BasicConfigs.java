package com.dev.springbootentitiesrestapi;

import com.dev.springbootentitiesrestapi.services.IProfileEntityService;
import com.dev.springbootentitiesrestapi.services.impls.ProfileEntityServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan("com.dev.springbootentitiesrestapi.*")
@EnableJpaRepositories(basePackages = "com.dev.springbootentitiesrestapi.repositories")
@PropertySource("classpath:application.properties")
public class BasicConfigs {

    @Bean
    public IProfileEntityService iProfileEntityService(){
        return new ProfileEntityServiceImpl();
    }

}

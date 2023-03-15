package com.dev.springbootentitiesrestapi;

import com.dev.springbootentitiesrestapi.services.*;
import com.dev.springbootentitiesrestapi.services.impls.*;
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

    @Bean
    public IRoleEntity1Service iRoleEntity1Service(){
        return new RoleEntity1ServiceImpl(){};
    }

    @Bean
    public IRoleEntity2Service iRoleEntity2Service(){
        return new RoleEntity2ServiceImpl(){};
    }

    @Bean
    public IUserEntity1Service iUserEntity1Service(){
        return new UserEntity1ServiceImpl(){};
    }

    @Bean
    public IUserEntity2Service iUserEntity2Service(){
        return new UserEntity2ServiceImpl(){};
    }

}

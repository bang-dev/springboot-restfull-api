package com.dev.springbootmongorestapi;

import com.dev.springbootmongorestapi.mappers.IEnumMapper;
import com.dev.springbootmongorestapi.mappers.impls.EnumMapperImpl;
import com.dev.springbootmongorestapi.services.IProfileService;
import com.dev.springbootmongorestapi.services.IUserService;
import com.dev.springbootmongorestapi.services.impls.ProfileServiceImpl;
import com.dev.springbootmongorestapi.services.impls.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@ComponentScan("com.dev.springbootmongorestapi.*")
@EnableMongoRepositories(basePackages = "com.dev.springbootmongorestapi.repositories")
@PropertySource("classpath:application.properties")
public class BeanConfigs {

    @Bean
    public IUserService iUserService(){
        return new UserServiceImpl();
    }

    @Bean
    public IProfileService iProfileService(){
        return new ProfileServiceImpl();
    }

    @Bean
    public IEnumMapper iEnumMapper(){
        return new EnumMapperImpl();
    }


}

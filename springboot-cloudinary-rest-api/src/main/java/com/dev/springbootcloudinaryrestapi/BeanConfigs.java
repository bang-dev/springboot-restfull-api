package com.dev.springbootcloudinaryrestapi;

import com.dev.springbootcloudinaryrestapi.services.ICloudinaryService;
import com.dev.springbootcloudinaryrestapi.services.IPhotoService;
import com.dev.springbootcloudinaryrestapi.services.impls.CloudinaryServiceImpl;
import com.dev.springbootcloudinaryrestapi.services.impls.PhotoServiceImpl;
import com.dev.springbootmongorestapi.mappers.IEnumMapper;
import com.dev.springbootmongorestapi.mappers.impls.EnumMapperImpl;
import com.dev.springbootmongorestapi.services.IProfileService;
import com.dev.springbootmongorestapi.services.IUserService;
import com.dev.springbootmongorestapi.services.impls.ProfileServiceImpl;
import com.dev.springbootmongorestapi.services.impls.UserServiceImpl;
import org.springframework.context.annotation.*;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@ComponentScan("com.dev.springbootcloudinaryrestapi.*")
@EnableMongoRepositories(basePackages = "com.dev.springbootcloudinaryrestapi")
@PropertySource({"classpath:application.properties","classpath:cloudinary.properties"})
public class BeanConfigs {

    @Bean
    public ICloudinaryService iCloudinaryService(){
        return new CloudinaryServiceImpl(){};
    }

    @Bean
    public IPhotoService iPhotoService(){
        return new PhotoServiceImpl();
    }



}

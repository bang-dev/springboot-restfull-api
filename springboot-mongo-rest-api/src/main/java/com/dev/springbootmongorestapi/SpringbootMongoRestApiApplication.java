package com.dev.springbootmongorestapi;

import com.dev.SwaggerOrgConfigs;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import springfox.documentation.swagger2.configuration.Swagger2DocumentationConfiguration;


@SpringBootApplication(exclude = {Swagger2DocumentationConfiguration.class},scanBasePackages = "com.dev.springbootmongorestapi.*")
@Import(SwaggerOrgConfigs.class)
public class SpringbootMongoRestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMongoRestApiApplication.class, args);
        System.out.print("======= Springboot Rest API With Mongodb ...");
    }

}

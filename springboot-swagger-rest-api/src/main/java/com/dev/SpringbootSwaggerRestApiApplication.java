package com.dev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.configuration.Swagger2DocumentationConfiguration;

@SpringBootApplication(exclude = {Swagger2DocumentationConfiguration.class})
public class SpringbootSwaggerRestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSwaggerRestApiApplication.class, args);
    }

}

package com.dev.springbootmongorestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.dev.springbootmongorestapi.*")
public class SpringbootMongoRestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMongoRestApiApplication.class, args);
        System.out.print("======= Springboot Rest API With Mongodb ...");
    }

}

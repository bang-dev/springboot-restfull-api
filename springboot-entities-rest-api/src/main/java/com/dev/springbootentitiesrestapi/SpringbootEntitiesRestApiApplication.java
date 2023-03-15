package com.dev.springbootentitiesrestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.dev.springbootentitiesrestapi.*")
public class SpringbootEntitiesRestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootEntitiesRestApiApplication.class, args);
        System.out.println("Welcome to my springboot with JPA...");
    }

}


package com.dev.springbootentitiesrestapi.services;

import com.dev.springbootentitiesrestapi.entities.unidirectional.UserEntity1;

import java.util.List;

public interface IUserEntity1Service {

    List<UserEntity1> getAll();
    UserEntity1 create(UserEntity1 userEntity1);


}

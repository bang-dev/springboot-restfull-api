package com.dev.springbootentitiesrestapi.services.impls;

import com.dev.springbootentitiesrestapi.entities.unidirectional.UserEntity1;
import com.dev.springbootentitiesrestapi.repositories.IUserEntity1Repository;
import com.dev.springbootentitiesrestapi.services.IUserEntity1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserEntity1ServiceImpl implements IUserEntity1Service {
    
    @Autowired
    private IUserEntity1Repository iUserEntity1Repository;


    @Override
    public List<UserEntity1> getAll() {
        List<UserEntity1> userEntity1s = iUserEntity1Repository.findAll();
        return userEntity1s;
    }

    @Override
    public UserEntity1 create(UserEntity1 userEntity1) {
        UserEntity1 temp = iUserEntity1Repository.save(userEntity1);
        return temp;
    }
}

package com.dev.springbootentitiesrestapi.services.impls;

import com.dev.springbootentitiesrestapi.entities.unidirectional.UserEntity1;
import com.dev.springbootentitiesrestapi.repositories.IUserEntity1ServiceRepository;
import com.dev.springbootentitiesrestapi.services.IUserEntity1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserEntity1ServiceImpl implements IUserEntity1Service {
    
    @Autowired
    private IUserEntity1ServiceRepository iUserEntity1ServiceRepository;
    
    @Override
    public UserEntity1 create(UserEntity1 userEntity1) {
        UserEntity1 temp = iUserEntity1ServiceRepository.save(userEntity1);
        return temp;
    }
}

package com.dev.springbootentitiesrestapi.services.impls;

import com.dev.springbootentitiesrestapi.entities.bidirectional.UserEntity2;
import com.dev.springbootentitiesrestapi.repositories.IUserEntity2Repository;
import com.dev.springbootentitiesrestapi.services.IUserEntity2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserEntity2ServiceImpl implements IUserEntity2Service {

    @Autowired
    private IUserEntity2Repository iUserEntity2Repository;

    @Override
    public UserEntity2 create(UserEntity2 userEntity2) {
        UserEntity2  temp = iUserEntity2Repository.save(userEntity2);
        return temp;
    }
}

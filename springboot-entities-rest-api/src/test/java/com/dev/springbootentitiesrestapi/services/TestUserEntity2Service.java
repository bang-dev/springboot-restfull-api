package com.dev.springbootentitiesrestapi.services;

import com.dev.springbootentitiesrestapi.SpringbootEntitiesRestApiApplication;
import com.dev.springbootentitiesrestapi.entities.bidirectional.RoleEntity2;
import com.dev.springbootentitiesrestapi.entities.bidirectional.UserEntity2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
public class TestUserEntity2Service {
    @Autowired
    @Qualifier("userEntity2ServiceImpl")
    private IUserEntity2Service iUserEntity2Service;

    @Autowired
    @Qualifier("roleEntity2ServiceImpl")
    private IRoleEntity2Service iRoleEntity2Service;
    @Test
    public void testCreate(){
        UserEntity2 userEntity2 = new UserEntity2();
        userEntity2.setUsername("bcd@gmail.com");
        userEntity2.setPassword(UUID.randomUUID().toString());

        RoleEntity2 roleEntity2 = iRoleEntity2Service.getRoleEntity2("34ebf2dc9c424d17ad8158ac945ebcb8");
        userEntity2.setRoleEntity2(roleEntity2);
        iUserEntity2Service.create(userEntity2);
    }
}

package com.dev.springbootentitiesrestapi.services;

import com.dev.springbootentitiesrestapi.entities.unidirectional.RoleEntity1;
import com.dev.springbootentitiesrestapi.entities.unidirectional.UserEntity1;
import com.dev.springbootentitiesrestapi.enums.impls.EnumRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.UUID;

@SpringBootTest
public class TestUserEntity1Service {

    @Autowired
    private IUserEntity1Service iUserEntity1Service;

    @Autowired
    private IRoleEntity1Service iRoleEntity1Service;

    @Test
    public void testFindAll(){
        List<UserEntity1> list = iUserEntity1Service.getAll();
        list.forEach(userEntity1 ->
            System.out.println(userEntity1.getRoleEntity1().getRoleType())

        );
    }

    @Test
    public void testCreate(){
        UserEntity1 temp = new UserEntity1();
        temp.setUsername("def@gmail.com");
        temp.setPassword(UUID.randomUUID().toString());
        RoleEntity1 roleEntity1 = iRoleEntity1Service.getRoleEntity1("75363ab2a1424d6d9362558dc490db9f");
        temp.setRoleEntity1(roleEntity1);
        this.iUserEntity1Service.create(temp);

     }
}

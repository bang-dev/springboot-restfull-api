package com.dev.springbootentitiesrestapi.services;

import com.dev.springbootentitiesrestapi.entities.unidirectional.RoleEntity1;
import com.dev.springbootentitiesrestapi.enums.impls.EnumRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestRoleEntity1Service {


    @Autowired
     private IRoleEntity1Service iRoleEntity1Service;

    @Test
     public void testCreate(){
       /* RoleEntity1 roleEntity1 = new RoleEntity1();
        roleEntity1.setRoleType(EnumRole.ADMIN.roleValue());
        roleEntity1.setDescription("Administrator");
        iRoleEntity1Service.create(roleEntity1);*/
    }
}

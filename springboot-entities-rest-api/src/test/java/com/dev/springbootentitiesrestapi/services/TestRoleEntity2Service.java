package com.dev.springbootentitiesrestapi.services;

import com.dev.springbootentitiesrestapi.SpringbootEntitiesRestApiApplication;
import com.dev.springbootentitiesrestapi.entities.bidirectional.RoleEntity2;
import com.dev.springbootentitiesrestapi.enums.impls.EnumRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = SpringbootEntitiesRestApiApplication.class)
public class TestRoleEntity2Service {

    @Autowired
    private IRoleEntity2Service iRoleEntity2Service;

    @Test
     public void testCreate(){
        RoleEntity2 roleEntity2 = new RoleEntity2();
        roleEntity2.setRoleType(EnumRole.USER.roleValue());
        roleEntity2.setDescription("User.....");
        iRoleEntity2Service.create(roleEntity2);
     }

}

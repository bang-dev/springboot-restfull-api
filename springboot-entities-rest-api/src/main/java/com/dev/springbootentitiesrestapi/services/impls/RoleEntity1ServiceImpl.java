package com.dev.springbootentitiesrestapi.services.impls;

import com.dev.springbootentitiesrestapi.entities.unidirectional.RoleEntity1;
import com.dev.springbootentitiesrestapi.repositories.IRoleEntity1Repository;
import com.dev.springbootentitiesrestapi.services.IRoleEntity1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleEntity1ServiceImpl implements IRoleEntity1Service {

    @Autowired
    private IRoleEntity1Repository iRoleEntity1Repository;

    @Override
    public RoleEntity1 create(RoleEntity1 roleEntity1) {
        RoleEntity1 roleEntityTemp = iRoleEntity1Repository.save(roleEntity1);
        return  roleEntityTemp;
    }

    @Override
    public RoleEntity1 getRoleEntity1(String id) {
        RoleEntity1 temp = iRoleEntity1Repository.findById(id).orElse(null);
        return temp;
    }
}

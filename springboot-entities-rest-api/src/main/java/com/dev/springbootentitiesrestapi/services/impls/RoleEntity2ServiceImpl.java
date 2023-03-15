package com.dev.springbootentitiesrestapi.services.impls;

import com.dev.springbootentitiesrestapi.entities.bidirectional.RoleEntity2;
import com.dev.springbootentitiesrestapi.repositories.IRoleEntity2Repository;
import com.dev.springbootentitiesrestapi.services.IRoleEntity2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleEntity2ServiceImpl implements IRoleEntity2Service {

    @Autowired
    private IRoleEntity2Repository iRoleEntity2Repository;

    @Override
    public RoleEntity2 getRoleEntity2(String id) {
        RoleEntity2 roleEntity2 = iRoleEntity2Repository.findById(id).orElse(null);
        return roleEntity2;
    }

    @Override
    public RoleEntity2 create(RoleEntity2 roleEntity2) {
        RoleEntity2  temp = this.iRoleEntity2Repository.save(roleEntity2);
        return temp;
    }
}

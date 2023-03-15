package com.dev.springbootentitiesrestapi.repositories;

import com.dev.springbootentitiesrestapi.entities.unidirectional.RoleEntity1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleEntity1ServiceRepository extends JpaRepository<RoleEntity1,String> {

}

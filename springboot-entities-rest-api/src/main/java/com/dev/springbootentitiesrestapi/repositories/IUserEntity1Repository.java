package com.dev.springbootentitiesrestapi.repositories;

import com.dev.springbootentitiesrestapi.entities.unidirectional.UserEntity1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserEntity1Repository extends JpaRepository<UserEntity1,String> {

}

package com.dev.springbootentitiesrestapi.repositories;

import com.dev.springbootentitiesrestapi.entities.bidirectional.UserEntity2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserEntity2Repository extends JpaRepository<UserEntity2,String> {
}

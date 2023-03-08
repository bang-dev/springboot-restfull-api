package com.dev.springbootmongorestapi.repositories;

import com.dev.springbootmongorestapi.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends MongoRepository<User,String> {
}

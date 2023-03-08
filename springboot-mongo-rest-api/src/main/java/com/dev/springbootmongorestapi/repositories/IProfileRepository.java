package com.dev.springbootmongorestapi.repositories;

import com.dev.springbootmongorestapi.entities.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProfileRepository extends MongoRepository<Profile,String> {
}

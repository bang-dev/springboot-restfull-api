package com.dev.springbootentitiesrestapi.repositories;

import com.dev.springbootentitiesrestapi.entities.ProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProfileEntityRepository extends JpaRepository<ProfileEntity,String> {
}

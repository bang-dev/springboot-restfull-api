package com.dev.springbootentitiesrestapi.services;


import com.dev.springbootentitiesrestapi.entities.ProfileEntity;

import java.util.List;

public interface IProfileEntityService {
    List<ProfileEntity> all();

    ProfileEntity create(ProfileEntity profileEntity);

}

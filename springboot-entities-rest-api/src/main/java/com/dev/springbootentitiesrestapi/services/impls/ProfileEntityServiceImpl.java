package com.dev.springbootentitiesrestapi.services.impls;


import com.dev.springbootentitiesrestapi.entities.ProfileEntity;
import com.dev.springbootentitiesrestapi.repositories.IProfileEntityRepository;
import com.dev.springbootentitiesrestapi.services.IProfileEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@Transactional
public class ProfileEntityServiceImpl implements IProfileEntityService {

    @Autowired
    private IProfileEntityRepository iProfileEntityRepository;

    @Override
    public List<ProfileEntity> all() {
        return null;
    }

    @Override
    public ProfileEntity create(ProfileEntity profileEntity) {
        ProfileEntity temp = iProfileEntityRepository.save(profileEntity);
        return temp;
    }
}

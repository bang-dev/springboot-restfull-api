package com.dev.springbootentitiesrestapi.services;

import com.dev.springbootentitiesrestapi.entities.ProfileEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.Table;

@SpringBootTest
public class TestProfileServiceEntity {

    @Autowired
    private IProfileEntityService iProfileEntityService;


    @Test
    public void testSave(){
        ProfileEntity profileEntity = new ProfileEntity();
        profileEntity.setFirstName("Bằng");
        profileEntity.setLastName("Võ Anh");
        profileEntity.setBirthday("05-12-1997");

        iProfileEntityService.create(profileEntity);
    }
}

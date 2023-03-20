/*
package com.dev.springbootmongorestapi.services;

import com.dev.springbootmongorestapi.SpringbootMongoRestApiApplication;
import com.dev.springbootmongorestapi.builders.ProfileBuilder;
import com.dev.springbootmongorestapi.entities.Profile;
import com.dev.springbootmongorestapi.utils.GenerateUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest(classes = SpringbootMongoRestApiApplication.class)
public class TestProfileService {

    @Autowired
    @Qualifier("profileServiceImpl")
    private IProfileService iProfileService;


    @Test
    public void testAddNewProfile(){
        Profile profile = new ProfileBuilder()
                .builderID(GenerateUtils.generateNewId(UUID.randomUUID().toString()))
                .builderFirstName("Huyền2")
                .builderLastName("Trần Khánh")
                .builderBirthday("20-10-2004")
                .builderEmail("trankhanhhuyen2004@gmail.com")
                .builderAvatar("####")
                .builder();

        Profile tempProfile = this.iProfileService.save(profile);
       // Assertions.assertNotNull(tempProfile);
      //  Assertions.assertSame("OLD: "+profile.getId(),"NEW: "+tempProfile.getId());
        Assertions.assertEquals(profile.getId(),tempProfile.getId());
    }
}
*/

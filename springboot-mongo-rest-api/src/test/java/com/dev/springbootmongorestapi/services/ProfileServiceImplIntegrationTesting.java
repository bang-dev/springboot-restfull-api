/*
package com.dev.springbootmongorestapi.services;

import com.dev.springbootmongorestapi.SpringbootMongoRestApiApplication;
import com.dev.springbootmongorestapi.builders.ProfileBuilder;
import com.dev.springbootmongorestapi.entities.Profile;
import com.dev.springbootmongorestapi.services.impls.ProfileServiceImpl;
import com.dev.springbootmongorestapi.utils.DateTimeUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import java.util.List;


@SpringBootTest(classes = SpringbootMongoRestApiApplication.class)
@Import(ProfileServiceImplIntegrationTesting.ProfileServiceImplTestContextConfiguration.class)
public class ProfileServiceImplIntegrationTesting {
    @TestConfiguration
    static class ProfileServiceImplTestContextConfiguration{
        @Bean
        public IProfileService iProfileService(){
            return new ProfileServiceImpl(){
                @Override
                public List<Profile> all() {
                    return super.all();
                }

                @Override
                public boolean checkExists(String id) {
                    return super.checkExists(id);
                }

                @Override
                public Profile save(Profile profile) {
                    return super.save(profile);
                }
            };
        }
    }

    @Autowired
    private IProfileService iProfileService;

    @Test
    public void testViewAllProfile(){
        List<Profile> list = iProfileService.all();
        list.forEach(profile -> {
            System.out.println(profile.getEmail());
            Assertions.assertEquals(list.get(1).getEmail(),"bangvorio@gmail.com");
        });
    }

    @Test
    public void testCreateNewProfile(){
        Profile profile = new ProfileBuilder().builderFirstName("Thúy")
                .builderLastName("Võ")
                .builderBirthday(DateTimeUtils.birthdayRandom())
                .builderEmail("vothuy@gmail.com")
                .builderAvatar("####")
                .builder();
        Profile profileResult = this.iProfileService.save(profile);
        Assertions.assertNotNull(profileResult);
        Assertions.assertEquals(profile.getEmail(),profileResult.getEmail());
    }

    @Test
    public void testUpdateProfileByID_FirstName_LastName(){
        String id = "02489a2e51674f979f5a78ffa0627455";
        String first = "BằngG";
        String last = "Võ Anh";
        String fullname = last +" "+first;
        List<Profile> profileList = this.iProfileService.all();
        String tempId = null;
        for (int i = 0; i < profileList.size(); i++){
            if(profileList.get(i).getId().equals(id)){
                tempId = profileList.get(i).getId();
            }
        }
        Assertions.assertEquals(tempId,id);
        this.iProfileService.updateByFullName(id,first,last);



    }

}
*/

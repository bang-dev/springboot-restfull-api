package com.dev.springbootmongorestapi.services.impls;

import com.dev.springbootmongorestapi.entities.Profile;
import com.dev.springbootmongorestapi.exceptions.CustomParameterConstraintException;
import com.dev.springbootmongorestapi.exceptions.ProfileException;
import com.dev.springbootmongorestapi.exceptions.ValidationCode;
import com.dev.springbootmongorestapi.services.IProfileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
//@Transactional
public class ProfileServiceImpl implements IProfileService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProfileServiceImpl.class);

    @Autowired
    private MongoTemplate mongoTemplate;

    public ProfileServiceImpl() {
    }


    @Override
    public List<Profile> all() {
        List<Profile> profileList = this.mongoTemplate.findAll(Profile.class);
        LOGGER.info("Loading..... >>>> Profile List.");
        return profileList;
    }

    @Override
    public boolean checkExists(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").exists(Boolean.parseBoolean(id)));
        boolean check = this.mongoTemplate.exists(query,Profile.class);
        return check;
    }

    @Override
    public Profile findById(String id) {
        Profile profileResultOnly = this.mongoTemplate.findById(id,Profile.class);
        if (null != profileResultOnly){
            return profileResultOnly;
        }
        return null;
    }

    @Override
    public Profile save(Profile profile) {
        List<Profile> profileList = all();

        if (profileList != null && profileList.size() > 0){
         //   for (Profile profileCheck : profileList){
                boolean checkId = this.checkExists(profile.getId());
                if(checkId){
                    LOGGER.error("======> Profile is duplicate ID: "+profile.getId() +" !!!");
                    throw new ProfileException("Please re-add with another id", ValidationCode.CREATE_FAILED);
                }
                else {
                    Profile profileResult = this.mongoTemplate.insert(profile);
                    return profileResult;
                }
         //   }
        }else {
            this.mongoTemplate.insert(profile);
        }
        return null;
    }


    @Override
    public Profile updateByFullName(String id,String firstName, String lastName) {
        try {
            Profile profileSearch = findById(id);
            boolean checkId = checkExists(id);
            if(!checkId) {
                LOGGER.info("ID: " + id + " not found !");
            }
            profileSearch.setFirstName(firstName);
            profileSearch.setLastName(lastName);
            profileSearch.setUpdatedAt(LocalDateTime.now());
            profileSearch.setUpdatedBy("admin A");
            Profile profileResult = this.mongoTemplate.save(profileSearch);
            LOGGER.info(">>>> Updated success.");
            return profileResult;
        }catch (CustomParameterConstraintException e){
            throw new ProfileException("Can't update profile :: firstname and lastname !",e,ValidationCode.UPDATED_FAIL);
        }
    }

    @Override
    public Profile updateByBirthday(String birthday) {
        return null;
    }

    @Override
    public Profile updateByEmail(String email) {
        return null;
    }

    @Override
    public Profile updateByAvatar(String avatar) {
        return null;
    }

    @Override
    public Profile updateAll(String id, String firstName, String lastName, String birthday, String email, String avatar) {
        return null;
    }

    @Override
    public boolean checkAuthAndEmailExists(String authToken,String email) {
        Query query = new Query();
        query.addCriteria(Criteria.where("authToken").exists(Boolean.parseBoolean(authToken))
                .and(String.valueOf(Criteria.where("email").exists(Boolean.parseBoolean(email)))));
        boolean check = this.mongoTemplate.exists(query,Profile.class);
        return check;
    }

    @Override
    public Profile findByEmail(String email) {
        return null;
    }

    @Override
    public Profile getProfile(String authToken, String email) {
        Query query = new Query();
        query.addCriteria(Criteria.where("authToken").is(authToken).and(String.valueOf(Criteria.where("email").is(email))));
        Profile check = (Profile) this.mongoTemplate.find(query,Profile.class);
        return check;
    }
}

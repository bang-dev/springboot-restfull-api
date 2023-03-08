package com.dev.springbootmongorestapi.builders;

import com.dev.springbootmongorestapi.entities.Profile;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
@Getter
@Setter
public class ProfileBuilder implements Serializable {
    private Profile profile;

    public ProfileBuilder() {
        if(profile == null){
            this.profile = new Profile();
        }


    }

    public ProfileBuilder builderID(String id){
        profile.setId(id);
        return this;
    }

    public ProfileBuilder builderFirstName(String firstName){
        profile.setFirstName(firstName);
        return this;
    }
    public ProfileBuilder builderLastName(String lastName){
        profile.setLastName(lastName);
        return this;
    }
    public ProfileBuilder builderBirthday(String birthday){
        profile.setBirthday(birthday);
        return this;
    }
    public ProfileBuilder builderEmail(String email){
        profile.setEmail(email);
        return this;
    }
    public ProfileBuilder builderAvatar(String avatar){
        profile.setAvatar(avatar);
        return this;
    }

    public ProfileBuilder builderPath(String path){
        profile.setAvatar(path);
        return this;
    }

    public Profile builder(){
        return profile;
    }

}

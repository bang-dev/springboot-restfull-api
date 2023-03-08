package com.dev.springbootmongorestapi.builders;

import com.dev.springbootmongorestapi.dtos.ProfileDTO;
import com.dev.springbootmongorestapi.entities.Profile;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
@Getter
@Setter
public class ProfileDTOBuilder implements Serializable {
    private ProfileDTO profileDTO;

    public ProfileDTOBuilder builderIdDTO(String id){
        profileDTO.setId(id);
        return this;
    }

    public ProfileDTOBuilder builderFirstNameDTO(String firstName){
        profileDTO.setFirstName(firstName);
        return this;
    }
    public ProfileDTOBuilder builderLastNameDTO(String lastName){
        profileDTO.setLastName(lastName);
        return this;
    }
    public ProfileDTOBuilder builderBirthdayDTO(String birthday){
        profileDTO.setBirthday(birthday);
        return this;
    }
    public ProfileDTOBuilder builderEmailDTO(String email){
        profileDTO.setEmail(email);
        return this;
    }
    public ProfileDTOBuilder builderAvatarDTO(String avatar){
        profileDTO.setAvatar(avatar);
        return this;
    }
    public ProfileDTOBuilder builderPathDTO(String path){
        profileDTO.setPath(path);
        return this;
    }

    public ProfileDTO builder(){
        return profileDTO;
    }
}

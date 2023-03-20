package com.dev.springbootmongorestapi.mappers.impls;

import com.dev.springbootmongorestapi.dtos.ProfileDTO;
import com.dev.springbootmongorestapi.entities.Profile;
import com.dev.springbootmongorestapi.mappers.IProfileMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.List;

@Generated(
        value = "org.mapstruct.ap.MappingProcessor",
        date = "2021-03-11T19:21:44+0100",
        comments = "version: 1.4.2.Final, compiler: javac, environment: Java 13.0.2 (Oracle Corporation)"
)
@Component
public class ProfileMapperImpl implements IProfileMapper {
    @Override
    public ProfileDTO convertFromProfileToProfileDto(Profile profile) {
        if(null == profile){
            return new ProfileDTO();
        }
        ProfileDTO profileDto = new ProfileDTO();
        profileDto.setId(profile.getId());
        profileDto.setFirstName(profile.getFirstName());
        profileDto.setLastName(profile.getLastName());
        profileDto.setBirthday(profile.getBirthday());
        profileDto.setEmail(profile.getEmail());
        profileDto.setAvatar(profile.getAvatar());
        profileDto.setPath(profile.getPath());
        profileDto.setAuthToken(profile.getAuthToken());
        profileDto.setVersion(profile.getVersion());
        profileDto.setCreatedAt(profile.getCreatedAt());
        profileDto.setUpdatedAt(profile.getUpdatedAt());
        profileDto.setCreatedBy(profile.getCreatedBy());
        profileDto.setUpdatedBy(profile.getUpdatedBy());
        return profileDto;
    }

    @Override
    public Profile convertFromProfileDtoToProfile(ProfileDTO profileDto) {
        if(null == profileDto){
            return new Profile();
        }
        Profile profile = new Profile();
        profile.setId(profileDto.getId());
        profile.setFirstName(profileDto.getFirstName());
        profile.setLastName(profileDto.getLastName());
        profile.setBirthday(profileDto.getBirthday());
        profile.setEmail(profileDto.getEmail());
        profile.setAvatar(profileDto.getAvatar());
        profile.setPath(profileDto.getPath());
        profile.setVersion(profileDto.getVersion());
        profile.setAuthToken(profileDto.getAuthToken());
        profile.setCreatedAt(profileDto.getCreatedAt());
        profile.setUpdatedAt(profileDto.getUpdatedAt());
        profile.setCreatedBy(profileDto.getCreatedBy());
        profile.setUpdatedBy(profileDto.getUpdatedBy());
        return profile;
    }

    @Override
    public List<ProfileDTO> convertFromListProfileToListProfileDto(List<Profile> profiles) {
        if(null == profiles){
            return new ArrayList<>();
        }

        List<ProfileDTO> dtoAll = new ArrayList<>(profiles.size());
        for(Profile profile : profiles){
            dtoAll.add(convertFromProfileToProfileDto(profile));
        }

        return dtoAll;
    }

    @Override
    public List<Profile> convertFromListProfileDtoToListProfile(List<ProfileDTO> profileDtoList) {
        if(null == profileDtoList){
            return new ArrayList<>();

        }

        List<Profile> orgAll = new ArrayList<>(profileDtoList.size());
        for (ProfileDTO profileDto : profileDtoList){
            orgAll.add(convertFromProfileDtoToProfile(profileDto));
        }
        return orgAll;
    }
}


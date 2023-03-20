package com.dev.springbootgraphqlrestapi.mutations;

import com.dev.springbootmongorestapi.dtos.ProfileDTO;
import com.dev.springbootmongorestapi.entities.Profile;
import com.dev.springbootmongorestapi.mappers.IProfileMapper;
import com.dev.springbootmongorestapi.services.IProfileService;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@GraphQLApi
@Component
public class ProfileMutation {
    @Autowired
    private IProfileService iProfileService;

    @Autowired
    private IProfileMapper iProfileMapper;

    @GraphQLMutation
    public ProfileDTO createProfile(ProfileDTO profileDTO){
        Profile temp = iProfileMapper.convertFromProfileDtoToProfile(profileDTO);
        Profile profile = this.iProfileService.save(temp);
        ProfileDTO profileDTOTemp = this.iProfileMapper.convertFromProfileToProfileDto(profile);
        return profileDTOTemp;
    }

    @GraphQLMutation
    public ProfileDTO updateProfile(String id, ProfileDTO profileDTO){
        Profile profile = iProfileMapper.convertFromProfileDtoToProfile(profileDTO);
        Profile profileNew =  new Profile();
                profileNew.setFirstName(profile.getFirstName());
                profileNew.setLastName(profile.getLastName());
                profileNew.setBirthday(profile.getBirthday());
                profileNew.setEmail(profile.getEmail());
                profileNew.setAvatar(profile.getAvatar());
       Profile result = iProfileService.updateAll(id,
                profileNew.getFirstName(),
                profileNew.getLastName(),
                profileNew.getBirthday(),
                profileNew.getEmail(),
                profileNew.getAvatar())  ;
        ProfileDTO profileTemp = this.iProfileMapper.convertFromProfileToProfileDto(result);

        return profileTemp;
    }
}

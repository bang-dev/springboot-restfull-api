package com.dev.springbootgraphqlrestapi.resolvers;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.dev.springbootmongorestapi.dtos.ProfileDTO;
import com.dev.springbootmongorestapi.entities.Profile;
import com.dev.springbootmongorestapi.mappers.IProfileMapper;
import com.dev.springbootmongorestapi.services.IProfileService;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@GraphQLApi
@Component
public class ProfileResolver implements GraphQLResolver<ProfileDTO> {
    @Autowired
    @Qualifier("profileServiceImpl")
    private IProfileService iProfileService;

    @Autowired
    @Qualifier("profileMapperImpl")
    private IProfileMapper iProfileMapper;


   public ProfileDTO getProfileById(String id){
       Profile profile = this.iProfileService.findById(id);
       ProfileDTO profileDTO = iProfileMapper.convertFromProfileToProfileDto(profile);
       return profileDTO;
   }
}

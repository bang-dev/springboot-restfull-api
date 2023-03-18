package com.dev.springbootgraphqlrestapi.queries;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.dev.springbootmongorestapi.dtos.ProfileDTO;
import com.dev.springbootmongorestapi.entities.Profile;
import com.dev.springbootmongorestapi.mappers.IProfileMapper;
import com.dev.springbootmongorestapi.services.IProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProfileQuery implements GraphQLQueryResolver {

    @Autowired
    private IProfileService iProfileService;

    @Autowired
    private IProfileMapper iProfileMapper;

    public List<ProfileDTO> getProfiles(){
        List<Profile> profiles = this.iProfileService.all();
        List<ProfileDTO> list = this.iProfileMapper.convertFromListProfileToListProfileDto(profiles);
        if(null == list){list = new ArrayList<>(); }
        return list;
    }
}

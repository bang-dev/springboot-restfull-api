package com.dev.springbootgraphqlrestapi.graphql.api;

import com.dev.springbootgraphqlrestapi.mutations.ProfileMutation;
import com.dev.springbootgraphqlrestapi.queries.ProfileQuery;
import com.dev.springbootgraphqlrestapi.resolvers.ProfileResolver;
import com.dev.springbootmongorestapi.dtos.ProfileDTO;
import com.dev.springbootmongorestapi.entities.Profile;
import com.dev.springbootmongorestapi.mappers.IProfileMapper;
import com.dev.springbootmongorestapi.services.IProfileService;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@GraphQLApi
@Component
public class ProfileGraphQLApi {

    @Autowired
   private final ProfileQuery profileQuery;
    @Autowired
   private final ProfileResolver profileResolver;
    @Autowired
   private final ProfileMutation profileMutation;
    @Autowired
   private final IProfileMapper iProfileMapper;


    public ProfileGraphQLApi(ProfileQuery profileQuery,
                             ProfileResolver profileResolver,
                             ProfileMutation profileMutation,
                             IProfileMapper iProfileMapper) {
        this.profileQuery = profileQuery;
        this.profileResolver =profileResolver;
        this.profileMutation = profileMutation;
        this.iProfileMapper = iProfileMapper;
    }

    @GraphQLQuery(name = "getProfiles",description = "Get all profile.")
    public List<ProfileDTO> getProfiles(){
        List<ProfileDTO> profileDTOS = profileQuery.getProfiles();
        return profileDTOS;
    }

    @GraphQLQuery(name = "profile",description = "Get profile by id")
    public ProfileDTO getProfileById(@GraphQLArgument(name = "id",description = "id of profile") String id){
       ProfileDTO profileDTO = profileQuery.getProfileById(id);
       return profileDTO;
    }

    @GraphQLMutation(name = "createProfile",description = "Add new profile")
    public ProfileDTO createProfile(@GraphQLArgument(name = "inputProfile") ProfileDTO inputProfile){
        ProfileDTO profileDTO = profileMutation.createProfile(inputProfile);
        return profileDTO;
    }


    @GraphQLMutation(name = "updateProfile",description = "Update info profile")
    public ProfileDTO updateProfile(@GraphQLArgument(name = "id") String id,@GraphQLArgument(name = "inputProfile") ProfileDTO inputProfile){
        ProfileDTO profileNew = profileMutation.updateProfile(id,inputProfile);
        return profileNew;
    }

}

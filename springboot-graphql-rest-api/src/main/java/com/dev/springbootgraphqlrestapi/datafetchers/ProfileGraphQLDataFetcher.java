package com.dev.springbootgraphqlrestapi.datafetchers;

import com.dev.springbootgraphqlrestapi.batchloaders.ProfileBatchLoader;
import com.dev.springbootgraphqlrestapi.mutations.ProfileMutation;
import com.dev.springbootgraphqlrestapi.queries.ProfileQuery;
import com.dev.springbootgraphqlrestapi.resolvers.ProfileResolver;
import com.dev.springbootmongorestapi.dtos.ProfileDTO;
import com.dev.springbootmongorestapi.mappers.IProfileMapper;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.dataloader.BatchLoader;
import org.dataloader.DataLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

@Component
public class ProfileGraphQLDataFetcher implements DataFetcher<CompletableFuture<ProfileDTO>> {


    @Autowired
    private ProfileBatchLoader profileBatchLoader;


    @Autowired
    @Qualifier("profileResolver")
    private ProfileResolver profileResolver;

    @Autowired
    private ProfileQuery profileQuery;

    @Autowired
    private ProfileMutation profileMutation;

    @Autowired
    private IProfileMapper iProfileMapper;

    private DataLoader<String, ProfileDTO>  dataLoader;

    public ProfileGraphQLDataFetcher() {
    }

    public ProfileGraphQLDataFetcher(DataLoader<String, ProfileDTO> dataLoader) {
        this.dataLoader = dataLoader;
    }

      public ProfileGraphQLDataFetcher(ProfileBatchLoader profileBatchLoader, DataLoader<String, ProfileDTO> dataLoader) {
        this.profileBatchLoader = profileBatchLoader;
        this.dataLoader = dataLoader;
    }

    @Override
    public CompletableFuture<ProfileDTO> get(DataFetchingEnvironment environment) throws Exception {
        String profileId = environment.getArgument("id");
        return dataLoader.load(profileId)
                .thenApply(profile -> {
                    // If the profile is not found in the cache, fetch it from the service
                    if (profile == null) {
                        ProfileDTO profileDTO = profileResolver.getProfileById(profileId);
                        // Cache the profile using the data loader
                        dataLoader.prime(profileId, profileDTO);
                    }
                    return profile;
                });
    }

    public DataFetcher getDataFetcherAllProfile(){
        return dataFetchingEnvironment->  profileQuery.getProfiles();
    }

    public DataFetcher getDataFetcherProfileById(){
        return environment -> {
            String id = environment.getArgument("id");
            ProfileDTO profileDTO = profileResolver.getProfileById(id);
            return  profileDTO;
        };
    }
}

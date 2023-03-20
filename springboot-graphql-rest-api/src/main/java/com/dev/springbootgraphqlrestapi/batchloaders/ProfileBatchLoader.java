package com.dev.springbootgraphqlrestapi.batchloaders;

import com.dev.springbootgraphqlrestapi.mutations.ProfileMutation;
import com.dev.springbootgraphqlrestapi.queries.ProfileQuery;
import com.dev.springbootgraphqlrestapi.resolvers.ProfileResolver;
import com.dev.springbootmongorestapi.dtos.ProfileDTO;
import com.dev.springbootmongorestapi.entities.Profile;
import com.dev.springbootmongorestapi.mappers.IProfileMapper;
import org.dataloader.BatchLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

@Component
public class ProfileBatchLoader implements BatchLoader<String, ProfileDTO> {

    @Autowired
    private ProfileResolver profileResolver;

    @Autowired
    private ProfileQuery profileQuery;

    @Autowired
    private ProfileMutation profileMutation;

    @Autowired
    private IProfileMapper iProfileMapper;

    @Override
    public CompletionStage<List<ProfileDTO>> load(List<String> keys) {
        return CompletableFuture.supplyAsync(() -> {
            List<ProfileDTO> values = new ArrayList<>();
            for (String key : keys) {
                // Load data for the current key and add it to the list of values
                ProfileDTO value = loadDataForKey(key);
                values.add(value);
            }
            return values;
        });
    }



    private ProfileDTO loadDataForKey(String key) {
        // Load data for the given key from some data source
        // For example, you might load data from a database or a REST API
        ProfileDTO profileDTO = this.profileResolver.getProfileById(key);
        return  profileDTO;
    }


    public BatchLoader getProfileBatchLoader(){
        return data -> (CompletionStage<List>) profileQuery.getProfiles();
    }
}

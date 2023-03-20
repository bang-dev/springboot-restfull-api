package com.dev.springbootgraphqlrestapi;

import com.dev.springbootgraphqlrestapi.mutations.ProfileMutation;
import com.dev.springbootgraphqlrestapi.queries.ProfileQuery;
import com.dev.springbootgraphqlrestapi.resolvers.ProfileResolver;
import com.dev.springbootgraphqlrestapi.utils.datatypes.GraphQLDate;
import com.dev.springbootgraphqlrestapi.utils.datatypes.GraphQLDateTime;
import graphql.schema.GraphQLSchema;
import io.leangen.graphql.GraphQLSchemaGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@Configuration
public class GraphQLConfiguration {
    @Bean
    @Lazy
    @Scope("prototype")
    public GraphQLDate dateScalar(){
        return new GraphQLDate();
    }

    @Bean
    @Lazy
    @Scope("prototype")
    public GraphQLDateTime dateTimeScalar(){
        return new GraphQLDateTime();
    }


/*
 @Bean
    public GraphQLSchema schema(ProfileQuery profileQuery, ProfileResolver profileResolver, ProfileMutation profileMutation) {
        return new GraphQLSchemaGenerator()
                .withOperationsFromSingletons(profileQuery, profileResolver,profileMutation)
                .generate();
    }
*/



}

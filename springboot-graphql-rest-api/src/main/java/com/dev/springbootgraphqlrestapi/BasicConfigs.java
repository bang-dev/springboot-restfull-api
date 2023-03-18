package com.dev.springbootgraphqlrestapi;

import com.dev.springbootgraphqlrestapi.basics.ProfileType;
import com.dev.springbootgraphqlrestapi.basics.QueryType;
import com.dev.springbootgraphqlrestapi.datafetchers.ProfileGraphQLDataFetcher;
import com.dev.springbootgraphqlrestapi.mutations.ProfileMutation;
import com.dev.springbootgraphqlrestapi.resolvers.ProfileResolver;
import com.dev.springbootmongorestapi.BeanConfigs;
import com.dev.springbootmongorestapi.mappers.IEnumMapper;
import com.dev.springbootmongorestapi.services.IProfileService;
import com.dev.springbootmongorestapi.services.IUserService;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BasicConfigs extends BeanConfigs {
    @Bean
    public GraphQL graphQL() {
        // Define the schema
        GraphQLSchema schema = GraphQLSchema.newSchema()
                .query(QueryType.QUERY_TYPE)
                .build();

        // Create the GraphQL bean
        GraphQL graphQL = GraphQL.newGraphQL(schema).build();
        return graphQL;
    }


    @Bean
    public ProfileGraphQLDataFetcher graphQLDataFetcher(){
        return new ProfileGraphQLDataFetcher();
    }


    @Bean
    public ProfileResolver profileResolver(){
        return new ProfileResolver();
    }

    @Bean
    public ProfileMutation profileMutation(){
        return new ProfileMutation();
    }

    @Override
    public IUserService iUserService() {
        return super.iUserService();
    }

    @Override
    public IProfileService iProfileService() {
        return super.iProfileService();
    }

    @Override
    public IEnumMapper iEnumMapper() {
        return super.iEnumMapper();
    }
}

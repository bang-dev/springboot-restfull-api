package com.dev.springbootgraphqlrestapi.basics;

import com.dev.springbootgraphqlrestapi.resolvers.ProfileResolver;
import graphql.schema.GraphQLList;
import graphql.schema.GraphQLNonNull;
import graphql.schema.GraphQLObjectType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import static graphql.Scalars.GraphQLString;

public class QueryType {

    @Autowired
    private static ApplicationContext applicationContext;
    public static final GraphQLObjectType QUERY_TYPE = GraphQLObjectType.newObject()
            .name("Query")
            .field(field -> field
                    .name("profile")
                    .type(ProfileType.profileType)
                    .description("Get a profile by ID")
                    .argument(arg -> arg.name("id").type(new GraphQLNonNull(GraphQLString)))
                    .dataFetcher(environment -> {
                        ProfileResolver resolver =  applicationContext.getBean(ProfileResolver.class);
                        String id = environment.getArgument("id");
                        return resolver.getProfileById(id);
                    })
            )
            .build();
}

package com.dev.springbootgraphqlrestapi.basics;

import com.dev.springbootgraphqlrestapi.utils.datatypes.GraphQLDate;
import com.dev.springbootgraphqlrestapi.utils.datatypes.GraphQLDateTime;
import graphql.Scalars;
import graphql.scalars.datetime.DateScalar;
import graphql.scalars.datetime.DateTimeScalar;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLScalarType;
import org.springframework.stereotype.Component;

import static graphql.Scalars.*;

@Component
public class ProfileType {
    public static final GraphQLObjectType PROFILE_TYPE = GraphQLObjectType.newObject()
            .name("Profile")
            .description("A user profile")
            .field(field -> field
                    .name("id")
                    .type(GraphQLID)
                    .description("The ID of the profile"))
            .field(field -> field
                    .name("firstName")
                    .type(GraphQLString)
                    .description("The first name of the profile"))
            .field(field -> field
                    .name("lastName")
                    .type(GraphQLString)
                    .description("The last name of the profile"))
            .field(field -> field
                    .name("birthday")
                    .type(GraphQLDate.dateScalar())
                    .description("The birthday of the profile"))
            .field(field -> field
                    .name("email")
                    .type(GraphQLString)
                    .description("The email of the profile"))
            .field(field -> field
                    .name("avatar")
                    .type(GraphQLString)
                    .description("The avatar of the profile"))
            .field(field -> field
                    .name("path")
                    .type(GraphQLString)
                    .description("The path of the profile"))
            .field(field -> field
                    .name("authToken")
                    .type(GraphQLString)
                    .description("The authToken of the profile"))
            .field(field -> field
                    .name("version")
                    .type(GraphQLInt)
                    .description("The version of the profile"))
            .field(field -> field
                    .name("createdAt")
                    .type(GraphQLString)
                    .description("The createdAt of the profile"))
            .field(field -> field
                    .name("updatedAt")
                    .type(GraphQLString)
                    .description("The updatedAt of the profile"))
            .field(field -> field
                    .name("createdBy")
                    .type(GraphQLString)
                    .description("The createdBy of the profile"))
            .field(field -> field
                    .name("updatedBy")
                    .type(GraphQLString)
                    .description("The updatedBy of the profile"))

            .build();
}

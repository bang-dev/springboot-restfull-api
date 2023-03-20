package com.dev.springbootgraphqlrestapi.utils;

import graphql.GraphQL;
import graphql.scalars.ExtendedScalars;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import java.io.File;
import java.io.IOException;

import static graphql.GraphQL.newGraphQL;
import static graphql.schema.idl.RuntimeWiring.newRuntimeWiring;

@Component
public class GraphQLUtility {
    @Value("classpath:graphqls/schema/profiles.graphqls")
    protected static Resource schemaResource;
    private GraphQL graphQL;
    // private AllUsersDataFetcher allUsersDataFetcher;
    // private CreateUserDataFetcher createUserDataFetcher;
    // private UpdateUserDataFetcher updateUserDataFetcher;


  /*  @PostConstruct
    public static GraphQL createGraphQlObject() throws IOException {
        File schemas = schemaResource.getFile();
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(schemas);
        RuntimeWiring wiring = buildRuntimeWiring();
        GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
        return newGraphQL(schema).build();
    }*/


    public static RuntimeWiring buildRuntimeWiring() {
        return newRuntimeWiring()
                .scalar(ExtendedScalars.Date)
               /* .type("Query", typeWiring -> typeWiring
                        .dataFetcher("users", allUsersDataFetcher)
                        .dataFetcher("user", createUserDataFetcher)
                        .dataFetcher("change", updateUserDataFetcher)
                )*/

                .build();
    }

    public static Resource getSchemaResource() {
        return schemaResource;
    }

    public static void setSchemaResource(Resource schemaResource) {
        GraphQLUtility.schemaResource = schemaResource;
    }
}

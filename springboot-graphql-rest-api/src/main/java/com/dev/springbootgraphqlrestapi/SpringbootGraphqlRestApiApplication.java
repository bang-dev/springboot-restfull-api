package com.dev.springbootgraphqlrestapi;

import com.dev.springbootgraphqlrestapi.graphql.api.ProfileGraphQLApi;
import com.dev.springbootgraphqlrestapi.mutations.ProfileMutation;
import com.dev.springbootgraphqlrestapi.queries.ProfileQuery;
import com.dev.springbootgraphqlrestapi.resolvers.ProfileResolver;
import com.dev.springbootgraphqlrestapi.utils.GraphQLProvider;
import com.dev.springbootgraphqlrestapi.utils.GraphQLUtility;
import com.dev.springbootmongorestapi.mappers.IProfileMapper;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import io.leangen.graphql.GraphQLSchemaGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;


@SpringBootApplication(scanBasePackages = "com.dev.springbootgraphqlrestapi.*")
@Import(value = {GraphQLConfiguration.class,BasicConfigs.class, GraphQLUtility.class, GraphQLProvider.class})
public class SpringbootGraphqlRestApiApplication {

    @Autowired
    static ProfileMutation profileMutation;
    @Autowired
    static ProfileResolver profileResolver;
    @Autowired
    static ProfileQuery profileQuery;

    @Autowired
    static IProfileMapper iProfileMapper;

    public static void main(String[] args) {

        SpringApplication.run(SpringbootGraphqlRestApiApplication.class, args);
        /*GraphQLSchema schema = new GraphQLSchemaGenerator()
                .withOperationsFromSingleton(new ProfileGraphQLApi(profileQuery,profileResolver,profileMutation,iProfileMapper))
                .generate();

        GraphQL graphQL = GraphQL.newGraphQL(schema).build();

        String query = "query{\n" +
                "    getProfiles{    \n" +
                "         id\n" +
                "         firstName\n" +
                "         lastName\n" +
                "         birthday\n" +
                "         email\n" +
                "         avatar\n" +
                "           \n" +
                "    }\n" +
                "}";

        ExecutionResult result = graphQL.execute(query);

        System.out.println(result.getData().toString());
*/    }

}

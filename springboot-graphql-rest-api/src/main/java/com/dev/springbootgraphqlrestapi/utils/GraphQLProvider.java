package com.dev.springbootgraphqlrestapi.utils;

import com.dev.springbootgraphqlrestapi.batchloaders.ProfileBatchLoader;
import com.dev.springbootgraphqlrestapi.datafetchers.ProfileGraphQLDataFetcher;
import com.dev.springbootgraphqlrestapi.utils.datatypes.GraphQLBlob;
import com.dev.springbootgraphqlrestapi.utils.datatypes.GraphQLDate;
import com.dev.springbootgraphqlrestapi.utils.datatypes.GraphQLDateTime;
import com.dev.springbootgraphqlrestapi.utils.datatypes.GraphQLOffsetDateTimeScalar;
import com.dev.springbootmongorestapi.dtos.ProfileDTO;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import graphql.GraphQL;
import graphql.scalars.ExtendedScalars;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.dataloader.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URL;

import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;


@Component
public class GraphQLProvider {


     @Autowired
     private Environment env;

     @Autowired
     private GraphQL graphQL;

     @Autowired
     private ProfileGraphQLDataFetcher profileGraphQLDataFetcher;

     @Autowired
     private ProfileBatchLoader profileBatchLoader;

     public GraphQLProvider(GraphQL graphQL) {
          this.graphQL = graphQL;
     }

     public Environment getEnv() {
          return env;
     }

     public void setEnv(Environment env) {
          this.env = env;
     }

     public GraphQL getGraphQL() {
          return graphQL;
     }

     public void setGraphQL(GraphQL graphQL) {
          this.graphQL = graphQL;
     }

     @Bean
     @Scope(value = WebApplicationContext.SCOPE_APPLICATION, proxyMode = ScopedProxyMode.TARGET_CLASS)
     @Profile("global")
     public DataLoaderRegistry globalDataLoaderRegistry(@Value("${cache.maxCacheSize}") long maxCacheSize,
                                                        @Value("${cache.expiryInSeconds}") long expiryInSeconds) {
          DataLoaderRegistry dataLoaderRegistry = new DataLoaderRegistry();

          CacheMap customCache = new CustomGuavaBasedCache(maxCacheSize, expiryInSeconds);
          DataLoaderOptions options = DataLoaderOptions.newOptions().setCacheMap(customCache);

         DataLoader<String, ProfileDTO> profileLoaders = DataLoader.newDataLoader(profileBatchLoader.getProfileBatchLoader(), options);// dataLoaderRegistry.register("countries", countryLoader);
          dataLoaderRegistry.register("getProfiles", profileLoaders);
          return dataLoaderRegistry;
     }

     @SuppressWarnings("Beta")
     @PostConstruct
     public void init() throws IOException {
          //graphqls/schema/profiles.graphqls
          URL url = Resources.getResource("graphqls/schema/profiles.graphqls");
          String sdl = Resources.toString(url, Charsets.UTF_8);
          GraphQLSchema graphQLSchema = buildSchema(sdl);
          graphQL = GraphQL.newGraphQL(graphQLSchema).build();
          //********************

         // this.graphQL = GraphQLUtility.createGraphQlObject();

     }

     private GraphQLSchema buildSchema(String sdl) {
          TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(sdl);
          RuntimeWiring runtimeWiring = buildWiring();
          SchemaGenerator schemaGenerator = new SchemaGenerator();
          return schemaGenerator.makeExecutableSchema(typeRegistry, runtimeWiring);
     }

     private RuntimeWiring buildWiring() {
          return RuntimeWiring.newRuntimeWiring()
                  .scalar(GraphQLDateTime.dateTimeScalar())
                  .scalar(GraphQLDate.dateScalar())
                  .scalar(GraphQLBlob.blobScalar())
                  .scalar(GraphQLOffsetDateTimeScalar.graphQLOffsetDateTimeScalar())
                 /* .scalar(ExtendedScalars.DateTime)
                  .scalar(ExtendedScalars.Date)*/
                  .type(newTypeWiring("Query")
                          .dataFetcher("getProfiles", profileGraphQLDataFetcher.getDataFetcherAllProfile())
                  )
                  .type(newTypeWiring("Resolver")
                          .dataFetcher("getProfileById",profileGraphQLDataFetcher.getDataFetcherProfileById())
                  )
                  .type(newTypeWiring("Mutation")

                  )
                  .build();
     }

}

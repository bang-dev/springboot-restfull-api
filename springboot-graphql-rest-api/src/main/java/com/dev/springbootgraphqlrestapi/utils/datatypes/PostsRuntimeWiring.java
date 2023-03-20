/*
package com.dev.springbootgraphqlrestapi.utils.datatypes;

import com.dev.springbootgraphqlrestapi.datafetchers.ProfileGraphQLDataFetcher;
import graphql.schema.idl.RuntimeWiring;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PostsRuntimeWiring implements RuntimeWiringConfigurer {
    private final ProfileGraphQLDataFetcher dataFetchers;

    @Override
    public void configure(RuntimeWiring.Builder builder) {
        builder
                .scalar(Scalars.localDateTimeType())
                .build();
    }
}
*/

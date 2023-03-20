package com.dev.springbootgraphqlrestapi.utils.datatypes;

import graphql.schema.GraphQLScalarType;

public class Scalars {
    public static GraphQLScalarType localDateTimeType() {
        return GraphQLScalarType.newScalar()
                .name("LocalDateTime")
                .description("LocalDateTime type")
                .coercing(GraphQLDateTime.dateTimeScalar().getCoercing())
                .build();
    }
}

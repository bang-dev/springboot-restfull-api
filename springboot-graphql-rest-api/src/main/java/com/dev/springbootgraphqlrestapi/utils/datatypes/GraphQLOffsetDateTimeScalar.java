package com.dev.springbootgraphqlrestapi.utils.datatypes;

import graphql.language.StringValue;
import graphql.schema.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Component
public class GraphQLOffsetDateTimeScalar {

    @Bean
    public static GraphQLScalarType graphQLOffsetDateTimeScalar() {
        return GraphQLScalarType.newScalar()
                .name("OffsetDateTime")
                .description("A date-time with an offset from UTC, in the format of `yyyy-MM-dd'T'HH:mm:ss.SSSZZ'")
                .coercing(
                        new Coercing<OffsetDateTime, String>() {
                            @Override
                            public String serialize(Object input) throws CoercingSerializeException {
                                if (input instanceof OffsetDateTime) {
                                    return ((OffsetDateTime) input).format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
                                } else {
                                    throw new CoercingSerializeException("Expected OffsetDateTime but was " + input.getClass().getSimpleName());
                                }
                            }

                            @Override
                            public OffsetDateTime parseValue(Object input) throws CoercingParseValueException {
                                if (input instanceof String) {
                                    try {
                                        return OffsetDateTime.parse((String) input, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
                                    } catch (DateTimeParseException e) {
                                        throw new CoercingParseValueException("Invalid OffsetDateTime value: " + input, e);
                                    }
                                } else {
                                    throw new CoercingParseValueException("Expected String but was " + input.getClass().getSimpleName());
                                }
                            }

                            @Override
                            public OffsetDateTime parseLiteral(Object input) throws CoercingParseLiteralException {
                                if (input instanceof StringValue) {
                                    try {
                                        return OffsetDateTime.parse(((StringValue) input).getValue(), DateTimeFormatter.ISO_OFFSET_DATE_TIME);
                                    } catch (DateTimeParseException e) {
                                        throw new CoercingParseLiteralException("Invalid OffsetDateTime value: " + input, e);
                                    }
                                } else {
                                    throw new CoercingParseLiteralException("Expected StringValue but was " + input.getClass().getSimpleName());
                                }
                            }
                        }
                )
                .build();
    }
}

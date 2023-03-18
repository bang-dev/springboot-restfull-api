package com.dev.springbootgraphqlrestapi.utils.datatypes;

import graphql.language.StringValue;
import graphql.schema.Coercing;
import graphql.schema.GraphQLScalarType;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class GraphQLDateTime {


    private static final String DEFAULT_NAME = "DateTime";
    private static final String DEFAULT_DESCRIPTION = "Custom scalar for representing date-time values";
    public static final String ISO_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(ISO_FORMAT);

    @Bean
    public static GraphQLScalarType dateTimeScalar() {
        return GraphQLScalarType.newScalar()
                 .name(DEFAULT_NAME)
                 .description(DEFAULT_DESCRIPTION)
                 .coercing(
                         new Coercing<LocalDateTime, String>() {

                             @Override
                             public String serialize(Object o) {
                                 if (o instanceof LocalDateTime) {
                                     return FORMATTER.format((LocalDateTime) o);
                                 } else {
                                     throw new IllegalArgumentException("Unable to serialize " + o + " as a LocalDateTime");
                                 }
                             }

                             @Override
                             public LocalDateTime parseValue(Object o) {
                                 try {
                                     return LocalDateTime.parse(o.toString(), FORMATTER);
                                 } catch (Exception e) {
                                     throw new IllegalArgumentException("Unable to parse value " + o + " as a LocalDateTime");
                                 }
                             }

                             @Override
                             public LocalDateTime parseLiteral(Object o) {
                                 if (o instanceof StringValue) {
                                     return LocalDateTime.parse(((StringValue) o).getValue(), FORMATTER);
                                 } else {
                                     throw new IllegalArgumentException("Unable to parse literal " + o + " as a LocalDateTime");
                                 }
                             }
                         }
                 )

                .build();
    }
}
package com.dev.springbootgraphqlrestapi.utils.datatypes;

import graphql.language.StringValue;
import graphql.schema.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class GraphQLDate {

    private static final String DEFAULT_NAME = "Date";
    private static final String DEFAULT_DESCRIPTION = "Custom scalar for representing date values";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE;

    @Bean
    public static GraphQLScalarType dateScalar() {
        return GraphQLScalarType.
                newScalar().name(DEFAULT_NAME)
                .description(DEFAULT_DESCRIPTION)
                .coercing(
                        new Coercing<LocalDate, String>() {

                            @Override
                            public String serialize(Object o) {
                                if (o instanceof LocalDate) {
                                    return FORMATTER.format((LocalDate) o);
                                } else {
                                    throw new IllegalArgumentException("Unable to serialize " + o + " as a LocalDate");
                                }
                            }

                            @NotNull
                            @Override
                            public LocalDate parseValue(Object o) {
                                try {
                                    return LocalDate.parse(o.toString(), FORMATTER);
                                } catch (Exception e) {
                                    throw new IllegalArgumentException("Unable to parse value " + o + " as a LocalDate");
                                }
                            }

                            @NotNull
                            @Override
                            public LocalDate parseLiteral(Object o) {
                                if (o instanceof StringValue) {
                                    return LocalDate.parse(((StringValue) o).getValue(), FORMATTER);
                                } else {
                                    throw new IllegalArgumentException("Unable to parse literal " + o + " as a LocalDate");
                                }
                            }
                        }
                )
                .build();

    }
}


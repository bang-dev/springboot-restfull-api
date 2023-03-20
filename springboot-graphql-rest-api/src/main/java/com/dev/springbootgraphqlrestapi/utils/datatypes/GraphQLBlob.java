package com.dev.springbootgraphqlrestapi.utils.datatypes;

import graphql.language.StringValue;
import graphql.schema.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Base64;

@Component
public class GraphQLBlob {

    private static final String DEFAULT_NAME = "Blob";
    private static final String DEFAULT_DESCRIPTION = "Custom scalar for representing binary data";

    @Bean
    public static GraphQLScalarType blobScalar() {
        return GraphQLScalarType.newScalar()
                .name(DEFAULT_NAME)
                .description(DEFAULT_DESCRIPTION)
                .coercing(
                        new Coercing<byte[], String>() {
                            @Override
                            public String serialize(Object dataFetcherResult) throws CoercingSerializeException {
                                if (dataFetcherResult instanceof byte[]) {
                                    return Base64.getEncoder().encodeToString((byte[]) dataFetcherResult);
                                } else {
                                    throw new CoercingSerializeException("Unable to serialize " + dataFetcherResult + " as a byte[]");
                                }
                            }

                            @Override
                            public byte[] parseValue(Object input) throws CoercingParseValueException {
                                if (input instanceof String) {
                                    try {
                                        return Base64.getDecoder().decode((String) input);
                                    } catch (IllegalArgumentException e) {
                                        throw new CoercingParseValueException("Unable to parse value " + input + " as a byte[]");
                                    }
                                } else {
                                    throw new CoercingParseValueException("Unable to parse value " + input + " as a byte[]");
                                }
                            }

                            @Override
                            public byte[] parseLiteral(Object input) throws CoercingParseLiteralException {
                                if (input instanceof StringValue) {
                                    try {
                                        return Base64.getDecoder().decode(((StringValue) input).getValue());
                                    } catch (IllegalArgumentException e) {
                                        throw new CoercingParseLiteralException("Unable to parse literal " + input + " as a byte[]");
                                    }
                                } else {
                                    throw new CoercingParseLiteralException("Unable to parse literal " + input + " as a byte[]");
                                }
                            }
                        }
                )
                .build();
    }
}


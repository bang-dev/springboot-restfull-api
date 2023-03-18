package com.dev.springbootgraphqlrestapi;

import com.dev.springbootgraphqlrestapi.utils.datatypes.GraphQLDate;
import com.dev.springbootgraphqlrestapi.utils.datatypes.GraphQLDateTime;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@Configuration
public class GraphQLConfiguration {
    @Bean
    @Lazy
    @Scope("prototype")
    public GraphQLDate dateScalar(){
        return new GraphQLDate();
    }

    @Bean
    @Lazy
    @Scope("prototype")
    public GraphQLDateTime dateTimeScalar(){
        return new GraphQLDateTime();
    }


}

package com.dev.springbootgraphqlrestapi.controllers.graphqls;

import com.dev.springbootgraphqlrestapi.controllers.data.Data;
import com.dev.springbootgraphqlrestapi.graphql.api.ProfileGraphQLApi;
import com.dev.springbootgraphqlrestapi.utils.GraphQLProvider;
import graphql.ExecutionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class ProfileGraphQLController {
    @Autowired
    private GraphQLProvider graphQLProvider;

    @QueryMapping
    @GetMapping("/getProfiles")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> getProfiles(@RequestBody @Argument Data query){
        ExecutionResult execute = graphQLProvider.getGraphQL().execute(query.getQuery());
        return new ResponseEntity<>(execute, HttpStatus.OK);
    }
}

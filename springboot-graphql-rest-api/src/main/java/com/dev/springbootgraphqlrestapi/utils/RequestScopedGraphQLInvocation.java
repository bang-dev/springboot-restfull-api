package com.dev.springbootgraphqlrestapi.utils;

import graphql.ExecutionInput;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.spring.web.servlet.GraphQLInvocation;
import graphql.spring.web.servlet.GraphQLInvocationData;
import org.dataloader.annotations.Internal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;
import java.util.concurrent.CompletableFuture;


@Component
@Internal
@Primary
@Profile({"request", "default"})
public class RequestScopedGraphQLInvocation implements GraphQLInvocation {

    @Autowired
    private Environment env;

    private final GraphQL graphQL;

    public RequestScopedGraphQLInvocation(GraphQL graphQL) {
        this.graphQL = graphQL;
    }

    @Override
    public CompletableFuture<ExecutionResult> invoke(GraphQLInvocationData invocationData, WebRequest webRequest) {
        ExecutionInput.Builder executionInputBuilder = ExecutionInput.newExecutionInput()
                .query(invocationData.getQuery())
                .operationName(invocationData.getOperationName())
                .variables(invocationData.getVariables());


        //  invocationData.getVariables().put("partnerId","test");
        ExecutionInput executionInput = executionInputBuilder.build();
        String format = env.getProperty("com.dev.springboot-graphql-rest-api.path.format");
        if (null != format) {
            Map<String, String> pathVariables = getPathVariable(format,((ServletWebRequest) webRequest).getRequest().getRequestURI());
            if(null!=pathVariables)
                pathVariables.entrySet()
                        .stream()
                        .forEach(entry-> executionInput.getGraphQLContext().put(entry.getKey(),entry.getValue()));
            //  executionInput.getVariables().putAll(pathVariables);
        }
        return graphQL.executeAsync(executionInput);
    }

    public Map<String, String> getPathVariable(String format, String path) {
        AntPathMatcher pathMatcher = new AntPathMatcher();
        return pathMatcher.extractUriTemplateVariables(format, path);
    }


}

package com.gapjincoup.economeans.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.schema.DataFetchingEnvironment;

import java.util.NoSuchElementException;

@ControllerAdvice
public class GraphQLExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public GraphQLError handleNoSuchElementException(NoSuchElementException exception, DataFetchingEnvironment environment) {
        return GraphqlErrorBuilder.newError()
                .message("Resource not found" + exception.getMessage())
                .path(environment.getExecutionStepInfo().getPath())
                .location(environment.getField().getSourceLocation())
                .build();
    }

    @ExceptionHandler(Exception.class)
    public GraphQLError handleGeneralException(Exception exception, DataFetchingEnvironment environment) {
        return GraphqlErrorBuilder.newError()
                .message("An error occurred: " + exception.getMessage())
                .path(environment.getExecutionStepInfo().getPath())
                .location(environment.getField().getSourceLocation())
                .build();
    }
}
package com.gapjincoup.economeans.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.GraphQlTest;
import org.springframework.graphql.test.tester.GraphQlTester;

@GraphQlTest(WelcomeController.class)
class WelcomeControllerTest extends ControllerTest {
    @Autowired
    private GraphQlTester graphQlTester;

    @Test
    void testHello() throws Exception {
        String query = """
                query {
                    welcome
                }
                """;

        graphQlTester.document(query)
                .execute()
                .path("welcome")
                .entity(String.class)
                .isEqualTo("Hello World!");
    }
}
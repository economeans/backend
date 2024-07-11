package com.gapjincoup.economeans.controllers;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class WelcomeController {
    @QueryMapping
    public String welcome() {
        return "Hello World!";
    }
}

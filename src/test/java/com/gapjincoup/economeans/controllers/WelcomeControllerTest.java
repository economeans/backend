package com.gapjincoup.economeans.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(WelcomeController.class)
class WelcomeControllerTest extends ControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void testHello() throws Exception {
        RequestBuilder builder = get("");

        mockMvc.perform(builder)
                .andExpect(status().isOk())
                .andExpect(content().string("Hello World!"));
    }
}
package com.gapjincoup.economeans.controllers;

import com.gapjincoup.economeans.application.articles.GetArticleService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ArticleController.class)
class ArticleControllerTest extends ControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    GetArticleService getArticleService;

    @Test
    @DisplayName("GET /api/v1/articles")
    void testGetListArticle() throws Exception {
        String category = "category";

        given(getArticleService.getListArticle(category))
                .willReturn(List.of());

        RequestBuilder builder = get("/api/v1/articles")
                .param("category", category);

        mockMvc.perform(builder)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.articles").exists());

        verify(getArticleService).getListArticle(category);
    }
}
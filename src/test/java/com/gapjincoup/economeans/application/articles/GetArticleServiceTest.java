package com.gapjincoup.economeans.application.articles;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GetArticleServiceTest {
    private GetArticleService getArticleService;

    @BeforeEach
    void setUp() {
        getArticleService = new GetArticleService();
    }

    @Test
    void testGetListArticle() {
        String category = "category";

        assertThat(getArticleService.getListArticle(category)).isEqualTo(List.of());
    }
}